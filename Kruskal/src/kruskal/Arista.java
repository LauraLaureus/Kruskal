package kruskal;

public class Arista implements Comparable<Arista>{

    private final Integer u;
    private final Integer v;

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }
    private final int peso;

    public Arista(int a, int b, int peso) {
        this.u = a;
        this.v = b;
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
