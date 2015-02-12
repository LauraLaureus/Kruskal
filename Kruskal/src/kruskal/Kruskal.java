
package kruskal;
public class Kruskal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CVSCargadorAristas cargador = new CVSCargadorAristas("Entrada.txt");
        Grafo g = cargador.carga();
        pruebaCargador(g);
        //ContenedorAristas solucion = kruskal();
        
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

    private static void pruebaCargador(Grafo g) {
        System.out.println("Num vértices:" + g.getNumVertices());
        
    }
}
