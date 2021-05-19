package ppc03concorrentes;

public class BufferCircular implements Buffer{

    public BufferCircular(int np) {
        qtdProdutores = np;
        fimProcesso = false;
    }

    public final int[] buffer = {-1 , -1 , -1};
    int qtdProdutores;
    boolean fimProcesso;
    
    public int occupiedCells = 0;

    public int getOccupiedCells() {
        return occupiedCells;
    }
    public int writeIndex = 0;
    public int readIndex = 0;

    @Override
    public synchronized void set(int valor) throws InterruptedException {
        
        while( occupiedCells == buffer.length )
            wait();
        buffer[writeIndex] = valor;
        writeIndex = (writeIndex + 1) % buffer.length;
        ++occupiedCells;
        notifyAll();
        
    }

    @Override
    public synchronized int get() throws InterruptedException {
        
        while(occupiedCells == 0 && !fimProcesso)
            wait();
        int readValue = buffer[readIndex];
        readIndex = (readIndex + 1) % buffer.length;
        --occupiedCells;
        notifyAll();
        return readValue;
        
    }
    
    public synchronized void encerrarProdutor(){
        qtdProdutores -= 1;
        if(qtdProdutores <= 0)
            fimProcesso = true;
        System.out.println("entrei aqui\n");
        notifyAll();
    }
    
}
