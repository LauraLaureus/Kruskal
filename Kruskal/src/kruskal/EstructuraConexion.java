package kruskal;

import java.util.HashMap;
import java.util.HashSet;

class EstructuraConexion {

    private final HashSet<Integer> conectados;
    private final HashMap<Integer, Vertice> conjunto;

    public EstructuraConexion(HashMap<Integer, Vertice> conjunto) {
        conectados = new HashSet<>();
        this.conjunto = conjunto;
    }

    public void conecta(Vertice v) {
        conectados.add(v.getId());
    }

    public boolean estaTotalmenteConectado() {
        exploraGrafo(this.conjunto.entrySet().iterator().next().getValue());
        return conectados.size() == conjunto.size();
    }

    private void exploraGrafo(Vertice v) {
        if (!estaVerticeConectado(v)) {
            conecta(v);
            for (Vertice value : v.getPosibilidades().values()) {
                exploraGrafo(value);
            }
        }
    }

    public boolean estaVerticeConectado(Vertice v) {
        return conectados.contains(v.getId());
    }

}

