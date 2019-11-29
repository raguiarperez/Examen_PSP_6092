package ExamenPSP6092_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 6092-Rafa Aguiar Pérez
 */
public class ExamenPSP6092_2 extends Thread{

    String nome;

    public ExamenPSP6092_2(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 25; i++) { //contador de repetir 25 veces el hilo
            System.out.println(i + ": " + getName());
            int tiempo=(int)(Math.random() * 250 + 1); // se especifica el tiempo de espera que sea aleatorio y apareza cada 250ms la escritura del hilo
            try {
                Thread.sleep(tiempo); //bloqueo de tiempo aleatorio
            } catch (InterruptedException ex) {
                Logger.getLogger(ExamenPSP6092_2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        /*Creación de nuevos Hilos*/
        ExamenPSP6092_2 h1 = new ExamenPSP6092_2("Hilo 1"); 
        ExamenPSP6092_2 h2 = new ExamenPSP6092_2("Hilo 2");
        ExamenPSP6092_2 h3 = new ExamenPSP6092_2("Hilo 3");
        /* Se comienza por el hilo 3, se escribe 25 veces y da paso al hilo 2 
           que a su vez escribe 25 veces y se acaba con el hilo 1 escirbiendo
           25 veces y con la terminación del programa principal*/
        h3.start();
        h3.join();
        h2.start();
        h2.join();
        h1.start();
        h1.join();

        System.out.println("Thread main terminated");
    }

}