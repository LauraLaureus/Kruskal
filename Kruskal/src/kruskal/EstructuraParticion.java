package kruskal;

public class EstructuraParticion {

    private final int[] conjunto;

    public EstructuraParticion(int numeroVertices) {
        conjunto = new int[numeroVertices + 1];
        inicializar();
    }

    public int getConjunto(int i) {
        return conjunto[i];
    }

    public void setConjunto(int pos, int value) {
        conjunto[pos] = value;
    }

    private void inicializar() {
        for (int i = 0; i < conjunto.length; i++) {
            conjunto[i] = 0;
        }
    }

    //posición i = vertice i+1
    public int buscar(int vertice) {
        int i = vertice;

        while (conjunto[i] > 0) {
            i = conjunto[i];//Retoque Laura
        }

        return i;
    }

    public void fusionar(int verticeA, int verticeB) {

        if (conjunto[verticeA] == conjunto[verticeB]) {
            conjunto[verticeA] = conjunto[verticeA] - 1;
            conjunto[verticeB] = verticeA;
        } else {
            if (conjunto[verticeA] < conjunto[verticeB]) {
                conjunto[verticeB] = verticeA;
            } else {
                conjunto[verticeA] = verticeB;
            }
        }
    }

}
