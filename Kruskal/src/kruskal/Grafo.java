package kruskal;

public class Grafo {

    private final int numVertices;
    private ContenedorAristas aristas;
    private final EstructuraParticion estructuraParticion;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        estructuraParticion = new EstructuraParticion(numVertices);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public EstructuraParticion getEstructuraParticion() {
        return estructuraParticion;
    }

    public void añadirContenedorAristas(ContenedorAristas contenedorAristas) {
        this.aristas = contenedorAristas;
    }
    
    public Arista[] obtenerConjuntoAristasOrdenado(){
        return null;
//return aristas.ordernar().toArray();
    }

}
