package ppc03concorrentes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PPC03Concorrentes {

    public static void main(String[] args) throws InterruptedException {
        
        long tempoInicial = System.currentTimeMillis();
        ArrayList<Integer> listaIdades = new ArrayList<>();
        int np = 2;
        int nc = 2;
        
        String path = "C:\\Users\\Brenno felix\\casos_obitos_doencas_preexistentes.csv";
        String separador = ";";

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            
            String line = br.readLine();
            line = br.readLine();//ignora primeira linha
            while (line != null){
                String[] dado = line.split(separador);
                //dado[2] = idade
                //dado[6] = obito
                if(Integer.parseInt(dado[6]) == 1){
                    listaIdades.add(Integer.parseInt(dado[2]));
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        BufferCircular buffer = new BufferCircular(np);
        CovidData cd = new CovidData(listaIdades);
        //Produtor p = new Produtor(buffer, cd);
        //Consumidor consumidor = new Consumidor(buffer, listaIdades.size());
        //Thread p1 = new Thread(new Produtor(buffer,cd));
        //Thread c1 = new Thread(consumidor);
        
        Produtor p[] = new Produtor[np];
        Consumidor c[] = new Consumidor[nc];
        for (int i=0; i<np; i++)
            p[i] = new Produtor(buffer, cd);
        for (int i=0; i<nc; i++){
            c[i] = new Consumidor(buffer, listaIdades.size());
        }
            
        for (int j=0; j<np; j++)
            p[j].start();
        for (int j=0; j<nc; j++)
            c[j].start();
        for (int j=0; j<np; j++)
            p[j].join();
        for (int j=0; j<nc; j++)
            c[j].join();
        //Consumidor consumidor2 = new Consumidor(buffer, listaIdades.size());
        //Thread p2 = new Thread(new Produtor(buffer,cd));
        //Thread c2 = new Thread(consumidor2);
        
        //p.run();
        //consumidor.run();
        
        //p1.start();
        //c1.start();
        //p2.start();
        //c2.start();
        //p1.join();
        //c1.join();
        //p2.join();
        //c2.join();
        //c[1].co.printaDados();
        //c[0].co.printaDados();
        System.out.println("[0,20) - " + (c[1].co.menor20+c[0].co.menor20));
        System.out.println("[20,30) - " + (c[1].co.entre20e30+c[0].co.entre20e30));
        System.out.println("[30,40) - " + (c[1].co.entre30e40+c[0].co.entre30e40));
        System.out.println("[40,50) - " + (c[1].co.entre40e50+c[0].co.entre40e50));
        System.out.println("[50,60) - " + (c[1].co.entre50e60+c[0].co.entre50e60));
        System.out.println("[60,70) - " + (c[1].co.entre60e70+c[0].co.entre60e70));
        System.out.println("[70,80) - " + (c[1].co.entre70e80+c[0].co.entre70e80));
        System.out.println("[80,) - " + (c[1].co.maior80+c[0].co.maior80));
        System.out.println("O método foi executado em " + (System.currentTimeMillis() - tempoInicial) + " milisegundos");

    } 
}
