package kruskal;

import java.util.ArrayList;

public class Grafo {

    //TODO cargarselo todo 
    private final int numVertices;
    private final ContenedorAristas aristas = new ContenedorAristas();
    private final EstructuraParticion estructuraParticion;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        estructuraParticion = new EstructuraParticion(numVertices);
    }

    public EstructuraParticion getEstructuraParticion() {
        return estructuraParticion;
    }

    public void añadirArista(int verticeA, int verticeB, int peso) {
        Arista nueva = new Arista (verticeA,verticeB,peso);
        aristas.añadirArista(nueva);
    }
    
    public Arista[] obtenerConjuntoAristasOrdenado(){
        return aristas.ordernar().toArray();
    }

}
