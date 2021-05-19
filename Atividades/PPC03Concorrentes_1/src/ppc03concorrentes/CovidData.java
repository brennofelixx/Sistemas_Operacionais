
package ppc03concorrentes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CovidData {
    ArrayList<Integer> listaIdades = new ArrayList<>();
    int n=0;
    
    public CovidData(ArrayList<Integer> lista){
        listaIdades = lista;
    }
    
    public synchronized int nextValue(){
        int aux = 0;
        if (n < listaIdades.size()){
            aux = listaIdades.get(n);
            n = n + 1;
        }
        return aux;
    }
    
    boolean hasNext(){
        return n < listaIdades.size();
    }
}
