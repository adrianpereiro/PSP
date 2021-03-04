import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Desencriptado {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\clave.ken"));
			Key clavesecreta = (Key) oin.readObject();
			oin.close();

			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, clavesecreta);

			CipherInputStream in = new CipherInputStream(new FileInputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\Fichero.Cifrado"), c);
			int tambloque = c.getBlockSize();
			byte[] bytes = new byte[tambloque];

			FileOutputStream fileout = new FileOutputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\FICHEROdescifrado.pdf");

			int i = in.read(bytes);
			while (i != -1) {
				fileout.write(bytes, 0, i);
				i = in.read(bytes);
			}
			fileout.close();
			in.close();
			System.out.println("Fichero descifrado con clave secreta.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


