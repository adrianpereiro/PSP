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
		System.setProperty("javax.net.ssl.trustStore","C:\\Users\\PC33\\git\\PSP\\Practica6\\src\\123456");
		System.setProperty("javax.net.ssl.trustStorePassword","123456");
		String Host = "localhost";
		int puerto = 6000;
		System.out.println("PROGRAMA CLIENTE INICIADO....");
		SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket Cliente = (SSLSocket) sfact.createSocket(Host, puerto);
		
		DataInputStream flujoEntrada = new
		DataInputStream(Cliente.getInputStream());
		
		System.out.println("Recibiendo del SERVIDOR: \n\t" +
		flujoEntrada.readUTF());
		
		flujoEntrada.close();
		Cliente.close();
		
				SSLSession session = ((SSLSocket) Cliente).getSession();
				System.out.println("Host: "+session.getPeerHost());
				System.out.println("Cifrado: " + session.getCipherSuite());
				System.out.println("Protocolo: " + session.getProtocol ());
				System.out.println("IDentificador:" + new
				BigInteger(session.getId()));
				System.out.println("Creaci�n de la sesi�n: " +
				session.getCreationTime());
				X509Certificate certificate =
				(X509Certificate)session.getPeerCertificates()[0];
				System.out.println("Propietario: "+certificate.getSubjectDN());
				System.out.println("Algoritmo: "+certificate.getSigAlgName());
				System.out.println("Tipo: "+certificate.getType());
				System.out.println("Emisor: "+certificate.getIssuerDN());
				System.out.println("N�mero Serie: "+certificate.getSerialNumber());
		
	}

}