import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6060;
		ServerSocket servidor = null;
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente");
		Scanner sc = new Scanner(System.in);

		System.out.println("Cuantos clientes se conectaran?");
		int numeroClientes = sc.nextInt();

		for (int i = 1; i <= numeroClientes; i++) {
			servidor = new ServerSocket(numeroPuerto);
			clienteConectado = servidor.accept();
			OutputStream salida = clienteConectado.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			flujoSalida.writeUTF("Eres el cliente " + i);

			flujoSalida.close();
			salida.close();
			clienteConectado.close();
			servidor.close();
		}
		sc.close();
	}
}
