
package ppc03concorrentes;

public class Contador {
    int menor20 = 0;
    int entre20e30 = 0;
    int entre30e40 = 0;
    int entre40e50 = 0;
    int entre50e60 = 0;
    int entre60e70 = 0;
    int entre70e80 = 0;
    int maior80 = 0;
    
    public void menor20(){
        menor20++;
    }
    public void entre20e30(){
        entre20e30++;
    }
    public void entre30e40(){
        entre30e40++;
    }
    public void entre40e50(){
        entre40e50++;
    }
    public void entre50e60(){
        entre50e60++;
    }
    public void entre60e70(){
        entre60e70++;
    }
    public void entre70e80(){
        entre70e80++;
    }
    public void maior80(){
        maior80++;
    }
    public void printaDados(){
        System.out.println("[0,20) - " + this.menor20);
        System.out.println("[20,30) - " + this.entre20e30);
        System.out.println("[30,40) - " + this.entre30e40);
        System.out.println("[40,50) - " + this.entre40e50);
        System.out.println("[50,60) - " + this.entre50e60);
        System.out.println("[60,70) - " + this.entre60e70);
        System.out.println("[70,80) - " + this.entre70e80);
        System.out.println("[80,) - " + this.maior80);
    }
}
