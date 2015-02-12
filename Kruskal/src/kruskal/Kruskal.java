
package kruskal;
public class Kruskal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numVertices = 5; //cargar numero de vertices
        Grafo G = new Grafo(numVertices);
        G.añadirContenedorAristas(new ContenedorAristas()); //cargar aristas
        ContenedorAristas solucion = kruskal(G);
        
    }
    
    private static ContenedorAristas kruskal (Grafo G){
        int n = G.getNumVertices();
        ContenedorAristas T = new ContenedorAristas();
        //La inicialización ya está echa sola al crear Grafo
        
        Arista[] aristasOrdenadas = G.obtenerConjuntoAristasOrdenado();
        int uconj, vconj;
        
        for (Arista arista : aristasOrdenadas) {
            uconj = G.getEstructuraParticion().buscar(arista.getU());
            vconj = G.getEstructuraParticion().buscar(arista.getV());
            
            if (uconj != vconj){
                G.getEstructuraParticion().fusionar(uconj, vconj);
                T.añadirArista(arista);
            }
            if (T.size() >= n){
                break;
            }
        }
        return T;
    }
}
