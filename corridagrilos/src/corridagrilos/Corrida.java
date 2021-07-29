package corridagrilos;

public class Corrida {
	int numGrilos = 4;//numero de Grilos
	public static int distancia = 100;//distancia da corrida
	public static int maximoPulo = 20;//distancia maxima por pulo
    
    Grilo[] grilos;
    public Corrida() {
		System.out.println("A corrida Começou!");
    	grilos = new Grilo[numGrilos];
		for(int i = 0; i <numGrilos;i++) {
			grilos[i] = new Grilo(i+1);
			grilos[i].start();
		}	
		
    }
}
