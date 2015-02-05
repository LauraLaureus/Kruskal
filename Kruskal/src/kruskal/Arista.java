
package kruskal;

public class Arista{

    private final Vertice uno;
    private final Vertice dos;
    private final int peso;
    
    public Arista(Vertice a, Vertice b, int peso){
        this.uno = a;
        this.dos = b;
        this.peso = peso;
    }
    
    
    public int getPeso(){
        return this.peso;
    }
}
