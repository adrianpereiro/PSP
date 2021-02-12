import java.io.IOException;

public class practica3 {
	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
					+ "\"cd C:\\Users\\PC33\\Desktop\\Clase\\Eclipse\\PSP\\Practica 3\\bin\\ && "
					+ " C:\\PROGRA~1\\Java\\jdk-14.0.2\\bin\\java "
					+ "-cp . "
					+ "Ejercicio1.palindromo ");
					//+ "\"C:\\PROGRA~1\\Java\\jdk-14.0.2\\bin\\java  \" -cp . "\"Ejercicio1.palindromo \"");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ProcessBuilder pb = new ProcessBuilder("CMD","/C","\"C:\\Program Files\\Java\\jdk-14.0.2\\bin\\java\" -cp . \"C:\\Users\\PC33\\Desktop\\Clase\\Eclipse\\PSP\\Practica 3\\bin\\Ejercicio1\"");
		//try {
		//	Process p = pb.start();
		//} catch (IOException e) {
		//	System.out.println("Error al lanzar el proceso");
		//	//e.printStackTrace();
		//}
		System.out.println("Hola");
	}
}
