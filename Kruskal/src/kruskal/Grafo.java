package kruskal;

public class Grafo {

    private final int numVertices;
    private ContenedorAristas aristas;
    private final EstructuraParticion estructuraParticion;
    private ConjuntoVertices vertices;

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

    public ContenedorAristas getAristas() {
        return aristas;
    }

    public void añadirVertices(ConjuntoVertices vertices) {
        this.vertices = vertices;
    }

    public boolean esConexo() {
        return vertices.esConexo();
    }
}
