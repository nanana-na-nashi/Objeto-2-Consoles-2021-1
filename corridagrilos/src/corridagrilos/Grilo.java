package corridagrilos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Grilo extends Thread {
    int numero;
    int distancia;
    int pulos = 0;
    int time;
    Random random;
    Semaphore semaphore;
    public Grilo(int numero, Semaphore _semaphore) {
        this.numero = numero;
        time = numero%3+1;//2,3,1,2,3,1
        random = new Random();
        semaphore = _semaphore;
    }
    public void run(){
        System.out.println("O grilo "+numero+" come�ou a pular!!");
        while(distancia<Corrida.distancia) {
            int pulo = random.nextInt(Corrida.maximoPulo);
            distancia += pulo;
            pulos++;
            System.out.println("O grilo "+numero+" pulou "+ pulo+ " cm! Ja percorreu "+ distancia +" cm");
        }
        System.out.println("O grilo "+numero+" pulou Chegou na linha de chegada com "+pulos +" pulos!");
    }
}