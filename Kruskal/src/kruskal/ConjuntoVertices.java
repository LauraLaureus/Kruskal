
package kruskal;

import java.util.HashMap;
import java.util.HashSet;

public class ConjuntoVertices {

    final private HashMap<Integer, Vertice> conjunto;

    
    private class EstructuraConexion{
    
        private final HashSet<Integer> conectados;
        private final HashMap<Integer,Vertice> conjunto;
        
        public EstructuraConexion(HashMap<Integer,Vertice> conjunto) {
            conectados = new HashSet<>();
            this.conjunto = conjunto;
        }
        
        public void conecta(Vertice v){
            conectados.add(v.getId());
        }
        
        public boolean estaTotalmenteConectado(){
            exploraGrafo(this.conjunto.entrySet().iterator().next().getValue());
            return conectados.size() == conjunto.size();
        }
        
        private void  exploraGrafo(Vertice v) {
            if (!estaVerticeConectado(v)) {
                conecta(v);
                for (Vertice value : v.getPosibilidades().values()) {
                    exploraGrafo(value);
                }
            }
        }
        
        public boolean estaVerticeConectado(Vertice v){
            return conectados.contains(v.getId());
        }
        
    }

    public ConjuntoVertices() {
        this.conjunto = new HashMap<>();
    }
    
    public void añadeVértice(Vertice v){
        if(v == null) return;
        if( !conjunto.containsKey(v.getId())){
            conjunto.put(v.getId(), v);
        }
    }
    
    public boolean esConexo(){
        return new EstructuraConexion(conjunto).estaTotalmenteConectado();
    }


    public boolean contiene(Vertice v){
        return conjunto.containsValue(v);
    }

    public void enlaza(Vertice a, Vertice aAñadir){
        conjunto.get(a.getId()).enlazar(aAñadir);
                
    }
   
    public int size() {
        return this.conjunto.size();
    }
    
    public Vertice dameVertice(Integer id){
        return conjunto.get(id);
    }
}
