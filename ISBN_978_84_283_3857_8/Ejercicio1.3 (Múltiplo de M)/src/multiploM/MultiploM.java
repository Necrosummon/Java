package multiploM;

/* Ejercicio 1.3 página 31
 * Realizar un programa que tome como entrada dos números entero (int) y nos indique
 * que cantidad hay que sumarle al primero para que sea múltiplo del segundo.
 * Ej: Si introducimos 2 y 5, al primero hay que sumarle 3 para que sea múltiplo del segundo.
 */

import java.util.Scanner;

public class MultiploM {
	static public void main (String[] args)
	{
		int numeroN, numeroM;
		float x;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un número N: ");
		numeroN = scanner.nextInt();
		System.out.print("Introduce un número M: ");
	    numeroM = scanner.nextInt();
	    
	    x = (float)numeroN/(float)numeroM;
	    x = x - (int)x;
	    x = x * numeroM;
	    x = numeroM - x;
	    
	    x = x != numeroM ? x : 0; // Operador terciario -> Si x es diferente de numeroM, vale X, si x = numeroM vale 0.
	    
	    System.out.println("A "+numeroN+" hay que añadirle "+Math.round(x)+" para que sea múltiplo de "+numeroM);
		scanner.close();
		
	}
}
