
package kruskal;

import java.util.HashMap;

public class ConjuntoVertices {

    final private HashMap<Integer, Vertice> conjunto;

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
        boolean[] vertices = new boolean[conjunto.size()+1];
        boolean flag = false;
        Integer id = conjunto.entrySet().iterator().next().getKey();
        exploraGrafo(id,vertices); 
          
        return flag;
    }

    private void exploraGrafo(Integer id, boolean[] vertices) {
        vertices[id] = true;
        for (boolean b : vertices) {
            exploraGrafo(conjunto.get(id).getId(), vertices);
        }
    }

    private boolean compruebaConexo(boolean[] vertices) {
        for (boolean b : vertices) {
            if(!b) return false;
        }
        return true;
    }
    
}
