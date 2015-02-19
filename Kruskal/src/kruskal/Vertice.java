
package kruskal;

import java.util.HashMap;
import java.util.Objects;

public class Vertice {

    private final Integer id;
    private HashMap<Integer, Vertice> posibilidades;

    public Vertice(Integer id) {
        this.id = id;
        posibilidades = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }
    
    public void enlazar(Vertice v){
        if(!posibilidades.containsKey(v.getId())){
            posibilidades.put(v.getId(), v);
        }
    }

    public HashMap<Integer, Vertice> getPosibilidades() {
        return posibilidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.posibilidades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
