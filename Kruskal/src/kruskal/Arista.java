package kruskal;

public class Arista implements Comparable<Arista> {

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
        if (this.peso == o.peso) {
            return 0;
        }
        return this.peso - o.peso;
    }

    @Override
    public boolean equals(Object arista) {
        if (!(arista instanceof Arista)) {
            return false;
        }
        Arista o = (Arista) arista;
        if (this.getU() == o.getU() && this.getV() == o.getV()) {
            return true;
        } else if (this.getU() == o.getV() && this.getV() == o.getU()) {
            return true;
        }
        return false;
    }

}
