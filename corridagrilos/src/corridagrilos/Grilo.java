package corridagrilos;

import java.util.Random;

public class Grilo extends Thread {
    int numero;
    int distancia;
    int pulos = 0;
    Random random;
    public Grilo(int numero) {
        this.numero = numero;
        random = new Random();
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