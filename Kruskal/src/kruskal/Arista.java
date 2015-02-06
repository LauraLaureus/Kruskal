package kruskal;

public class Arista implements Comparable<Arista>{

    private final int uno;
    private final int dos;
    private final int peso;

    public Arista(int a, int b, int peso) {
        this.uno = a;
        this.dos = b;
        this.peso = peso;
    }

    public int getPeso() {
        return this.peso;
    }

    @Override
    public int compareTo(Arista o) {
        if(this.peso == o.peso) return 0;
        return this.peso-o.peso;
    }

}
