package kruskal;

public class EstructuraParticion {
    private final int[] conjunto;

    public EstructuraParticion(int numeroVertices) {
        conjunto = new int[numeroVertices];
        inicializar();
    }
    
    public int getConjunto (int i){
        return conjunto[i];
    }
    
    public void setConjunto (int pos, int value){
        conjunto[pos] = value;
    }
    
    private void inicializar (){
        for (int i=0; i<conjunto.length; i++){
            conjunto[i] = 0;
        }
    }
    
    //posición i = vertice i+1
    public int buscar (int vertice){
        int i = vertice;
        
        while (conjunto[i-1] > 0){
            i = conjunto[i];
        }
        
        return i+1;
    }
    
    public void fusionar(int verticeA, int verticeB){
        
        int l_verticeA = verticeA-1;
        int l_verticeB = verticeB-1;
        
        if(conjunto[l_verticeA] == conjunto[l_verticeB]){
            conjunto[l_verticeA] = conjunto[l_verticeA]-1;
            conjunto[l_verticeB] = l_verticeA;
        }else{
            if(conjunto[l_verticeA] < conjunto[l_verticeB]){
                conjunto[l_verticeB] = l_verticeA;
            }else{
                conjunto[l_verticeA] = l_verticeB;
            }
        }
    }
}
