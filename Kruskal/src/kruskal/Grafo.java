package kruskal;

public class Grafo {

    private final int numVertices;
    private ContenedorAristas aristas;
    private final EstructuraParticionOO estructuraParticion;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        estructuraParticion = new EstructuraParticionOO(numVertices);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public EstructuraParticionOO getEstructuraParticion() {
        return estructuraParticion;
    }

    public void añadirContenedorAristas(ContenedorAristas contenedorAristas) {
        this.aristas = contenedorAristas;
    }

    public ContenedorAristas getAristas() {
        return aristas;
    }
    
}
