package kruskal;

import java.util.HashMap;

public class ConjuntoVertices {

    final private HashMap<Integer, Vertice> conjunto;

    public ConjuntoVertices() {
        this.conjunto = new HashMap<>();
    }

    public void añadeVértice(Vertice v) {
        if (v == null) {
            return;
        }
        if (!conjunto.containsKey(v.getId())) {
            conjunto.put(v.getId(), v);
        }
    }

    public boolean esConexo() {
        return new EstructuraConexion(conjunto).estaTotalmenteConectado();
    }

    public boolean contiene(Vertice v) {
        return conjunto.containsValue(v);
    }

    public void enlaza(Vertice a, Vertice aAñadir) {
        conjunto.get(a.getId()).enlazar(aAñadir);

    }

    public int size() {
        return this.conjunto.size();
    }

    public Vertice dameVertice(Integer id) {
        return conjunto.get(id);
    }
}
