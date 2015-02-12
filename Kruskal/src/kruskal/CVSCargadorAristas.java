package kruskal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class CVSCargadorAristas {

    private final TreeSet<Integer> conjuntoVertices;
    private BufferedReader lector = null;

    public CVSCargadorAristas(String ruta) {
        try {
            this.lector = new BufferedReader(new FileReader(ruta));
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
        this.conjuntoVertices = new TreeSet<>();
    }

    public Grafo carga() {

        /*
         mientras haya líneas 
            Lee una línea DONE
            parsea la línea
            añade los vértices al conjunto
            crea la arista
            añade la arista al conjunto

         Crear grafo con el conjunto de aristas y el número de vértices del conjunto
         */
        
        String line  = leerLinea();
        String[] lineaPartida;
        int[] lineaTraducida = new int[3];
        Arista nuevaArista;
        ContenedorAristas contAristas;
        
 
        while (line != null) {
            //si comienza por # es un comentario y nos lo saltamos
            if(line.charAt(0) != '#'){
                lineaPartida = line.split(",");
                lineaTraducida = traduceLinea(lineaPartida);
                
                
                
            }
            line = leerLinea();
        }

        return null;
    }
    
    private String leerLinea(){
        String line;
        try {
            line = lector.readLine();
        } catch (IOException ex) {
            line = null;
        }
        
        return line;
    }

    private int[] traduceLinea(String[] lineaPartida) {
        return new int[3] {
            Integer.parseInt(lineaPartida[0]),
            Integer.parseInt(lineaPartida[1]),
            Integer.parseInt(lineaPartida[2])
        };
    }
    }
}
