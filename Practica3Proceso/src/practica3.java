import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class practica3 {
	public static void main(String[] args) {
		File palindormo = new File("C:\\Users\\PC33\\Desktop\\palindromo.txt");
		try {
			Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
					+ "\"cd C:\\Users\\PC33\\Desktop\\Clase\\Eclipse\\PSP\\Practica 3\\bin\\ && "
					+ " C:\\PROGRA~1\\Java\\jdk-14.0.2\\bin\\java "
					+ "-cp . "
					+ "Ejercicio1.palindromo ");
			p.getInputStream(palindormo);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Hola");
	}
}
