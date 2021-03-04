import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class ServidorSSL {

	public static void main(String[] args) throws IOException {
		System.setProperty("javax.net.ssl.keyStore", "C:\\Users\\PC33\\git\\PSP\\Practica6\\src\\AlmacenSSL");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
		Scanner sc = new Scanner(System.in);
		int puerto = 6000;
		SSLServerSocketFactory sfact =(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		SSLServerSocket servidorSSL = null; 
		SSLSocket clienteConectado = null;
		DataOutputStream flujoSalida = null;
		
		int numeroClientes = 0;
		while(numeroClientes <= 0) {
		System.out.println("Clientes que se van a conectar a este Servidor ");
		numeroClientes = sc.nextInt();
		}
		
		System.out.println(+numeroClientes+" clientes");
		servidorSSL = (SSLServerSocket) sfact.createServerSocket(puerto);
		for(int i= 1; i<=numeroClientes; i++) {
			clienteConectado = (SSLSocket) servidorSSL.accept();
			flujoSalida = new DataOutputStream(clienteConectado.getOutputStream () ) ;
			flujoSalida.writeUTF("Socket número: "+i);
			flujoSalida.close ();
			
		}
		clienteConectado.close ();
		servidorSSL.close () ;
		
		SSLSession session = ((SSLSocket) clienteConectado).getSession();
		System.out.println("Host: "+session.getPeerHost());
		System.out.println("Cifrado: " + session.getCipherSuite());
		System.out.println("Protocolo: " + session.getProtocol ());
		System.out.println("IDentificador:" + new
		BigInteger(session.getId()));
		System.out.println("Creación de la sesión: " +
		session.getCreationTime());
		X509Certificate certificate =
		(X509Certificate)session.getLocalCertificates()[0];
		System.out.println("Propietario: "+certificate.getSubjectDN());
		System.out.println("Algoritmo: "+certificate.getSigAlgName());
		System.out.println("Tipo: "+certificate.getType());
		System.out.println("Emisor: "+certificate.getIssuerDN());
		System.out.println("Número Serie: "+certificate.getSerialNumber());
		
	}

}
