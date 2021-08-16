package corridagrilos;
import java.util.concurrent.Semaphore;

public class Corrida {
	int numGrilos = 6;//numero de Grilos
	public static int distancia = 100;//distancia da corrida
	public static int maximoPulo = 20;//distancia maxima por pulo
	public static int posicao = 1;
    public static int vencedor;
	
	Semaphore semaphore;
    Grilo[] grilos;
    public Corrida() {
    	semaphore = new Semaphore(1);

        System.out.println("A corrida Começou!");
        grilos = new Grilo[numGrilos];
        for(int i = 0; i <numGrilos;i++) {
            grilos[i] = new Grilo(i+1, semaphore);
            grilos[i].start();
        }
        int left = numGrilos;
        while(left!=0) {
            left = numGrilos;
            for(Grilo g : grilos) {
                if(g.GetDist()>= distancia)
                    left--;
            }
        }
        System.out.println("A corrida Acabou!");

        int[] pulos = new int[3];
        int[] dist = new int[3];
        for(Grilo g:grilos) {
            pulos[g.GetTime()-1]+=g.GetPulos();
            dist[g.GetTime()-1]+=g.GetDist();
        }

        for(int i =0; i<3;i++) {
            System.out.println("Time "+(i+1)+": Total de pulos: "+pulos[i]+" - Distância Percorrida: "+dist[i]);
        }
        System.out.println("Time "+vencedor +" foi o vencedor!");
    }
}
