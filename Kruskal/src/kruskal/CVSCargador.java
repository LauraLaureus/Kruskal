package kruskal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class CVSCargador {


    private final TreeSet<Integer> conjuntoVertices;
    private BufferedReader lector = null;

    public CVSCargador(String ruta) {
        try {
            this.lector = new BufferedReader(new FileReader(ruta));
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
        this.conjuntoVertices = new TreeSet<>();
    }

    public Grafo carga() {

       
        String line = leerLinea();
        String[] lineaPartida;
        Arista arista;
        ContenedorAristas contAristas = new ContenedorAristas();
        ConjuntoVertices vertices = new ConjuntoVertices();

        while (line != null) {
            //si comienza por # es un comentario y nos lo saltamos
            if ( (line.length() > 0) && (line.charAt(0) != '#')) {
                lineaPartida = line.split(",");
                vertices.añadeVértice(traduceVertice(lineaPartida,0));
                vertices.añadeVértice(traduceVertice(lineaPartida,1));
                arista = creaArista(lineaPartida);
                if(arista != null){
                    contAristas.añadirArista(arista);
                }}
                
            line = leerLinea();
        }
        
        Grafo resultado = new Grafo( conjuntoVertices.size());
        resultado.añadirContenedorAristas(contAristas);
        resultado.añadirVertices(vertices);
        
        return resultado;
    }

    private String leerLinea() {
        String line;
        try {
            line = lector.readLine();
        } catch (IOException ex) {
            line = null;
        }

        return line;
    }

    private Integer[] traduceLinea(String[] lineaPartida) {
        
        //si es Inf entonces no existe arista pero existen los vértices
        for (int i = 0; i < lineaPartida.length; i++) {
            if( lineaPartida[i].equalsIgnoreCase("Inf")){
                lineaPartida[i] = "-1";
            }
        }

        Integer[] resultado = {
            Integer.parseInt(lineaPartida[0]),
            Integer.parseInt(lineaPartida[1]),
            Integer.parseInt(lineaPartida[2])
        };
        
        if(resultado[0] < 0) resultado[0] = null;
        else if(resultado[1] < 0) resultado[1] = null;
        else if(resultado[2] < 0) resultado[2] = null;
        
        return resultado;
    }

    private void añadeVerticesAlConjunto(Integer[] lineaTraducida) {
        conjuntoVertices.add(lineaTraducida[0]);
        conjuntoVertices.add(lineaTraducida[1]);
    }
}
