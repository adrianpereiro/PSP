package Ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class palindromo {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una frase para saber si es palindromo o no\n");
		String frase = sc.nextLine();
		frase = frase.toLowerCase();
		String sinEspacio = "";

		if (frase.length() == 0) {
			System.out.println("La cadena esta vacia");
		} else {
			for (int i = 0; i < frase.length(); i++) {
				char a = frase.charAt(i);
				if (a != ' ') {
					sinEspacio = sinEspacio + a;
				}
			}

			// System.out.println(sinEspacio);

			String palindromo = "";
			for (int i = sinEspacio.length() - 1; i >= 0; i--) {
				char a = sinEspacio.charAt(i);
				palindromo = palindromo + a;
			}

			// System.out.println(palindromo + " palindromo\n");
			// System.out.println(sinEspacio + " sin espacios\n");

			if (palindromo.equals(sinEspacio)) {
				System.out.println("La frase que has introducido es un palindromo");
			} else {
				System.out.println("La frase que has introducido no es un palindromo");
			}
		}
		sc.close();
	}
}
