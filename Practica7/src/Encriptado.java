import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class Encriptado {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\clave.ken"));
			Key clavesecreta = (Key) oin.readObject();
			oin.close();

			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, clavesecreta);

			FileInputStream filein = new FileInputStream("C:\\Users\\PC33\\Downloads\\T6_AMORTIZACIONES.pdf");

			CipherOutputStream out = new CipherOutputStream(new FileOutputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\Fichero.Cifrado"), c);
			int tambloque = c.getBlockSize();
			byte[] bytes = new byte[tambloque];

			int i = filein.read(bytes);
			while (i != -1) {
				out.write(bytes, 0, i);
				i = filein.read(bytes);
			}
			out.flush();
			out.close();
			filein.close();
			System.out.println("Fichero cifrado con clave secreta.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
