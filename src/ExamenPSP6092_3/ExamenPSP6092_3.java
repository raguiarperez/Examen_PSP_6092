package ExamenPSP6092_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6092-Rafa Aguiar Pérez
 */
public class ExamenPSP6092_3 extends Thread {
  
    public static int contador=0;
    
    public ExamenPSP6092_3(String nombre){
        super(nombre);
    }
 
    @Override
    public void run() {        
        if(contador==0){
            contador=1;
            ExamenPSP6092_3 hilo2 = new ExamenPSP6092_3("Hilo 2");
            ExamenPSP6092_3 hilo3 = new ExamenPSP6092_3("Hilo 3");
            
            hilo2.start();
            hilo3.start();
        }
        
        for(int i=1;i<25;i++){
            int numero = (int) (Math.random() * 250) + 1000;
            System.out.println(this.getName()+"-Interacion "+i);
            try {
                sleep(numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExamenPSP6092_3.class.getName()).log(Level.SEVERE, null, ex);
            }
            yield();
        }       
    }
    
    public static void main(String[] args) throws InterruptedException {
        ExamenPSP6092_3 Hilo1 = new ExamenPSP6092_3("Hilo 1");
        Hilo1.start();
    }
    
}


