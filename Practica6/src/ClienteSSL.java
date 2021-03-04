import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClienteSSL {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.setProperty("javax.net.ssl.trustStore","D:\\Programacion\\PSP\\src\\Practica6\\AlmacenSSL2");
		System.setProperty("javax.net.ssl.trustStorePassword","123456");
		String Host = "localhost";
		int puerto = 6000;
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		//Punto de entrada para la creación de SSLSocket
		SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket Cliente = (SSLSocket) sfact.createSocket(Host, puerto);
		
		// CREO FLUJO DE ENTRADA AL SERVIDOR
		DataInputStream flujoEntrada = new
		DataInputStream(Cliente.getInputStream());
		
		//EL SERVIDOR ME ENVIA UN MENSAJE
		System.out.println("Recibiendo del SERVIDOR: \n\t" +
		flujoEntrada.readUTF());
		
		// CERRAR STREAMS Y SOCKETS
		flujoEntrada.close();
		Cliente.close();
		
		//DATOS DE SESIÓN 
				SSLSession session = ((SSLSocket) Cliente).getSession();
				System.out.println("Host: "+session.getPeerHost());
				System.out.println("Cifrado: " + session.getCipherSuite());
				System.out.println("Protocolo: " + session.getProtocol ());
				System.out.println("IDentificador:" + new
				BigInteger(session.getId()));
				System.out.println("Creación de la sesión: " +
				session.getCreationTime());
				X509Certificate certificate =
				(X509Certificate)session.getPeerCertificates()[0];
				System.out.println("Propietario: "+certificate.getSubjectDN());
				System.out.println("Algoritmo: "+certificate.getSigAlgName());
				System.out.println("Tipo: "+certificate.getType());
				System.out.println("Emisor: "+certificate.getIssuerDN());
				System.out.println("Número Serie: "+certificate.getSerialNumber());
		
	}

}