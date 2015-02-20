package kruskal;

import java.util.HashMap;
import java.util.HashSet;

public class DetectorBucles {

    private final HashMap<Integer,HashSet<Integer>> id_vecinos;
    private boolean hayBucles;
    private final ContenedorAristas aristas;

    
    public DetectorBucles(ContenedorAristas aristas) {
        this.hayBucles = false;
        this.aristas = aristas;
        this.id_vecinos = new HashMap<>();
    }
    

    public boolean tieneBucles(){
        exploraGrafo();
        return hayBucles;
    }

    private void exploraGrafo() {
        for (Arista arista : aristas) {
            conectaAmbosVertices(arista);
            if(hayBucles)return;
        }
    }

    private void conecta(Integer vertice,Integer vecino) {
        if(estaVerticeConectado(vertice)){
            if(esteVecinoHaPasadoDosVeces(vertice,vecino)) hayBucles = true;
        }else{
            HashSet<Integer> vecinos = new HashSet<>();
            vecinos.add(vecino);
            id_vecinos.put(vertice,vecinos);
        }
    }


    private boolean estaVerticeConectado(Integer v) {
        return id_vecinos.containsKey(v);
    }

    private boolean esteVecinoHaPasadoDosVeces(Integer vertice, Integer vecino) {
        return this.id_vecinos.get(vertice).contains(vecino);
    }

    private void conectaAmbosVertices(Arista arista) {
        conecta(arista.getU(),arista.getV());
        conecta(arista.getV(),arista.getU());
    }
    
}
