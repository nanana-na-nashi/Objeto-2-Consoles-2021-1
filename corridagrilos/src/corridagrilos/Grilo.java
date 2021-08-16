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
        System.out.println("O grilo "+numero+" comecou a pular!!");
        while(distancia<Corrida.distancia) {
            try {
                semaphore.acquire();
                int pulo = random.nextInt(Corrida.maximoPulo);
                distancia += pulo;
                pulos++;
                System.out.println("O grilo "+numero+" pulou "+ pulo+ " cm! Ja percorreu "+ distancia +" cm");
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            finally {
                semaphore.release();
            }
        }
        if(Corrida.posicao == 1)
            Corrida.vencedor = time;
        System.out.println("O grilo "+numero+" foi o "+(Corrida.posicao++)+"º a chegar com "+pulos+" pulos!");

    }

    public int GetPulos() {
        return pulos;
    }

    public int GetDist() {
        return distancia;
    }
    public int GetTime() {
        return time;
    }
}