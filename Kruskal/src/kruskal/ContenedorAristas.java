
package kruskal;

import java.util.ArrayList;

public class ContenedorAristas extends ArrayList<Arista> {
    //se tiene que poder crear un contenedor de aristas vacío
    public void añadirArista(Arista nueva) {
        //TO-DO Añadir lógica para comprobar no hay aristas repetidas
        this.add(nueva);
    }

    Object ordernar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
