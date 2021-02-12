import java.io.*;
import java.net.*;

public class Servidor3Clientes {
	public static void main(String[] arg) throws IOException {
		int numeroPuerto = 6060;
		ServerSocket servidor = null;
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente ");

		for (int i = 1; i <= 3; i++) {
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

	}
}
