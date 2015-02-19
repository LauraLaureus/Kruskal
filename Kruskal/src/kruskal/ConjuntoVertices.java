
package kruskal;

import java.util.HashMap;
import java.util.HashSet;

public class ConjuntoVertices {

    final private HashMap<Integer, Vertice> conjunto;
    
    private class EstructuraConexion{
    
        private HashSet<Vertice> conectados;
        private final int verticesEsperados;
        
        public EstructuraConexion(int numVertices) {
            conectados = new HashSet<>();
            verticesEsperados = numVertices;
        }
        
        public void conecta(Vertice id){
            conectados.add(id);
        }
        
        public boolean estaTotalmenteConectado(){
            return conectados.size() == verticesEsperados;
        }
        
        public boolean estaVerticeConectado(Vertice id){
            return conectados.contains(id);
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
        EstructuraConexion conectados = new EstructuraConexion(conjunto.size());
        
        //Obtener el primer elemento del mapa
        Vertice v = conjunto.entrySet().iterator().next().getValue();
        exploraGrafo(v,conectados); 
          
        return conectados.estaTotalmenteConectado();
    }

    private EstructuraConexion exploraGrafo(Vertice v, EstructuraConexion conectados) {
        if(!conectados.estaVerticeConectado(v)){
            conectados.conecta(v);
            for (Vertice value : v.getPosibilidades().values()) {
                exploraGrafo(value,conectados);
            }
        }
        return conectados;
    }


    
}
