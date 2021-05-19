package ppc03concorrentes;

public class Produtor extends Thread implements Runnable {
    
    public Buffer bufferCompartilhado;
    public CovidData data;
    
    public Produtor( Buffer buffer, CovidData cd){
        bufferCompartilhado = buffer;
        data = cd;
    }
    
    public void run() {
        while(data.hasNext()){
            try
            {
                bufferCompartilhado.set(data.nextValue());
                //System.out.println(data.nextValue());
                //System.out.println("entrei produtor");
                //System.out.println("n:" + data.n);
            } 
            catch (InterruptedException exception) {
            }
            
        }bufferCompartilhado.encerrarProdutor();
    }
    
}
