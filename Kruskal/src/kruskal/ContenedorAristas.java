
package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContenedorAristas extends ArrayList<Arista> {
    //se tiene que poder crear un contenedor de aristas vacío
    public void añadirArista(Arista nueva) {
        boolean condicion  = !this.contains(nueva);
        if (!this.contains(nueva)) this.add(nueva);
    }
    
    @Override
    public Arista[] toArray(){
        Arista[] arista = new Arista[this.size()];
        for (int i = 0; i < this.size(); i++) {
            arista[i] = this.get(i);
        }
        return arista;
    }
    
    public Arista[] getConjuntoAristasOrdenado(){
        Comparator<Arista> comparador = new Comparator<Arista>() {

            @Override
            public int compare(Arista o1, Arista o2) {
                return new Integer(o1.getPeso()).compareTo(new Integer(o2.getPeso()));
            }
        };
        Collections.sort(this, comparador);
        return this.toArray();
    }
}