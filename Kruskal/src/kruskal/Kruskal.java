
package kruskal;
public class Kruskal {


    public static void main(String[] args) {
        CVSCargador cargador = new CVSCargador("Entrada.txt");
        Grafo g = cargador.carga();
        //System.out.println(g.esConexo());
        if(g.esConexo()){

        muestaNumeroVertices(g);
        ContenedorAristas solucion = kruskal(g);
        salidaKruskal(solucion);
        
        }else{
            System.out.println("El grafo pasado en la entrada no es conexo.");
        }
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
    
    private static void muestaNumeroVertices(Grafo g) {
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
