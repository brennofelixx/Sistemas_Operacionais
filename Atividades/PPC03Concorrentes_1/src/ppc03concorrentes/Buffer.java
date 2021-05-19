package ppc03concorrentes;


public interface Buffer {
    
    public void set(int valor) throws InterruptedException;
    public int get() throws InterruptedException;
    public void encerrarProdutor();
}
