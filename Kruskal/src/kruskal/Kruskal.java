
package kruskal;
public class Kruskal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CVSCargadorAristas cargador = new CVSCargadorAristas("Entrada.txt");
        Grafo g = cargador.carga();
        pruebaCargador(g);
        ContenedorAristas solucion = kruskal(g);
        salidaKruskal(solucion);
        //pruebaAristas(g);
        
    }
    
    private static ContenedorAristas kruskal (Grafo g){
        int n = g.getNumVertices();
        ContenedorAristas T = new ContenedorAristas();
        //La inicialización ya está echa sola al crear Grafo
        
        Arista[] aristasOrdenadas = g.getAristas().getConjuntoAristasOrdenado();
        int uconj, vconj;
        
        for (Arista arista : aristasOrdenadas) {
            uconj = g.getEstructuraParticion().buscar(arista.getU());
            vconj = g.getEstructuraParticion().buscar(arista.getV());
            
            if (uconj != vconj){
                g.getEstructuraParticion().fusionar(uconj, vconj);
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

/*
    private static void pruebaAristas(Grafo g) {
        Arista[] aristas = g.getAristas().obtenerConjuntoAristasOrdenado();
        for (int i = 0; i < aristas.length; i++) {
            System.out.println(aristas[i].getPeso());
            
        }
    }*/

    private static void salidaKruskal(ContenedorAristas solucion) {
        solucion.getConjuntoAristasOrdenado();
        for (Arista arista : solucion) {
            System.out.println("Arista: " + arista.getU() + ", " + arista.getV() + "; con peso: " + arista.getPeso());
        }
    }
}
