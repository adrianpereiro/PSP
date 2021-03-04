import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Desencriptado {

	public static void main(String[] args) {
		try {
			// RECUPERAMOS CLAVE SECRETA DEL FICHERO
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\clave.ken"));
			Key clavesecreta = (Key) oin.readObject();
			oin.close();

			// SE DEFINE EL OBJETO Cipher para desencriptar
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, clavesecreta);

			// OBJETO CipherlnputStream CUYO CONTENIDO SE VA A DESCIFRAR
			CipherInputStream in = new CipherInputStream(new FileInputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\Fichero.Cifrado"), c);
			int tambloque = c.getBlockSize();
			byte[] bytes = new byte[tambloque];

			// FICHERO CON EL CONTENIDO DESCIFRADO QUE SE CREARÁ
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\PC33\\git\\PSP\\Practica7\\src\\FICHEROdescifrado.pdf");

			// LEEMOS BLOQUES DE BYTES DEL FICHERO cifrado
			// Y LO VAMOS ESCRIBIENDO desencriptados al FileOutputStream
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
	}// main

	}


