package ppc03concorrentes;

public class Consumidor extends Thread implements Runnable {
    
    public BufferCircular bufferCompartilhado;
    public Contador co;
    int tam;
    
    public Consumidor( BufferCircular buffer, int j){
        bufferCompartilhado = buffer;
        co = new Contador();
        tam = j;
    }
    
    public void insert(int i){
        if(i < 20){
            co.menor20();
        }
        if(i >= 20 && i < 30){
            co.entre20e30();
        }
        if(i >= 30 && i < 40){
            co.entre30e40();
        }
        if(i >= 40 && i < 50){
            co.entre40e50();
        }
        if(i >= 50 && i < 60){
            co.entre50e60();
        }
        if(i >= 60 && i < 70){
            co.entre60e70();
        }
        if(i >= 70 && i < 80){
            co.entre70e80();
        }
        if(i >= 80){
            co.maior80();
        }
    }
    
    @Override
    public void run() {
        while(!bufferCompartilhado.fimProcesso){
            try
            {
                insert(bufferCompartilhado.get());
                //System.out.println("entrei consumidor");
            } 
            catch (InterruptedException | ArrayIndexOutOfBoundsException exception) {
                break;
            }
        }
    }
}
