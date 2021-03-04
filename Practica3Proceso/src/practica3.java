import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class practica3 {
	public static void main(String[] args) {
		File palindormo = new File("C:\\Users\\PC33\\Desktop\\palindromo.txt");
		String line;
		Runtime rt = Runtime.getRuntime();
		try {
			String command = "cmd /c start cmd.exe /K "
					+ "\"cd C:\\Users\\PC33\\Desktop\\Clase\\Eclipse\\PSP\\Practica 3\\bin\\ && "
					+ " C:\\PROGRA~1\\Java\\jdk-14.0.2\\bin\\java "
					+ "-cp . "
					+ "Ejercicio1.palindromo ";
			Process proc = rt.exec(command);
//			Process p = Runtime.getRuntime().exec("cmd /c start cmd.exe /K "
//					+ "\"cd C:\\Users\\PC33\\Desktop\\Clase\\Eclipse\\PSP\\Practica 3\\bin\\ && "
//					+ " C:\\PROGRA~1\\Java\\jdk-14.0.2\\bin\\java "
//					+ "-cp . "
//					+ "Ejercicio1.palindromo ");
//			BufferedReader in = new BufferedReader(new InputStreamReader (p.getInputStream()));
//					while ((line = input.readLine()) != null) {
//					System.out.println(line);
//					}
//					input.close();
//			p.waitFor(10, TimeUnit.SECONDS);
//	        int value = p.exitValue();
//	        if (value != 0) {
//	            throw new Exception(MessageFormat.format("Código de salida con error (%d)", value));
//	        }
//	     // Obtener la salida del proceso
//	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
//	        String result = br.lines().collect(Collectors.joining("\n"));
//	        br.close();
//	        
//	        System.out.println(result);
			
			BufferedReader stdInput = new BufferedReader(new 
				     InputStreamReader(proc.getInputStream()));

				BufferedReader stdError = new BufferedReader(new 
				     InputStreamReader(proc.getErrorStream()));
			
				// Read the output from the command
				System.out.println("Here is the standard output of the command:\n");
				String s = "";
				while ((s = stdInput.readLine()) != null) {
				    System.out.println(s);
				}
				
				// Read any errors from the attempted command
				System.out.println("Here is the standard error of the command (if any):\n");
				while ((s = stdError.readLine()) != null) {
				    System.out.println(s);
				}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
