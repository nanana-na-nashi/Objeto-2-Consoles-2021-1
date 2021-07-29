package corridagrilos;

public class Grilo extends Thread {
	int numero;
	public Grilo(int numero) {
		this.numero = numero;
	}
    public void run(){
        System.out.println("O grilo "+numero+" começou a pular!!");
    }
}