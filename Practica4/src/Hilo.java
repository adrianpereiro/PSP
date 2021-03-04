
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Observable implements Runnable {

	private String nombre;

	public Hilo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {

		int porcentaje = 0;
		int numAleatorio;
		try {
			while (porcentaje < 100) {
				int sleep = generaNumeroAleatorio(10, 250);
				porcentaje += 10;

				this.setChanged();
				this.notifyObservers(porcentaje);
				this.clearChanged();
                for(int i=1 ; i<100000; i++) {
                	System.out.println("hilo " + nombre + " " + i );
                	System.out.flush();
                }
//                if(numAleatorio>12) {
//                	System.out.println("Hilo "+ nombre + " prioridad " + Thread.currentThread().getPriority());
//                }

				Thread.sleep(sleep);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Hilo interrumpido");
		}

	}

	public static int generaNumeroAleatorio(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;
	}

}
