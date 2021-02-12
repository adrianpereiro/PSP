import java.io.*;
import java.net.*;

public class Cliente {
	public static void main(String[] args) throws Exception {
		String Host = "localhost";
		int Puerto = 6000;
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket Cliente = new Socket(Host, Puerto);

		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

		System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());

		flujoEntrada.close();
		Cliente.close();
	}
}
