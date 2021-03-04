package PracticaEncriptacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Clave {

	public static void main(String[] args) {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128);
			SecretKey clave = kg.generateKey();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\PC33\\eclipse-workspace\\PSP\\src\\PracticaEncriptacion\\clave.ken"));
			out.writeObject(clave);
			out.close();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
		}

