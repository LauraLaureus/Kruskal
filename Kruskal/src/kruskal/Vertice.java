package kruskal;

public class Vertice {
    private static int semilla = 0;
    private final int id;

    public Vertice() {
        this.id = semilla;
        semilla++;
    }

    public int getId() {
        return id;
    }
    
}
