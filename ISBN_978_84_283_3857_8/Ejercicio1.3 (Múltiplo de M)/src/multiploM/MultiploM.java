package multiploM;

/* Ejercicio 1.3 p�gina 31
 * Realizar un programa que tome como entrada dos n�meros entero (int) y nos indique
 * que cantidad hay que sumarle al primero para que sea m�ltiplo del segundo.
 * Ej: Si introducimos 2 y 5, al primero hay que sumarle 3 para que sea m�ltiplo del segundo.
 */

import java.util.Scanner;

public class MultiploM {
	static public void main (String[] args)
	{
		int numeroN, numeroM;
		float x;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un n�mero N: ");
		numeroN = scanner.nextInt();
		System.out.print("Introduce un n�mero M: ");
	    numeroM = scanner.nextInt();
	    
	    x = (float)numeroN/(float)numeroM;
	    x = x - (int)x;
	    x = x * numeroM;
	    x = numeroM - x;
	    
	    x = x != numeroM ? x : 0; // Operador terciario -> Si x es diferente de numeroM, vale X, si x = numeroM vale 0.
	    
	    System.out.println("A "+numeroN+" hay que a�adirle "+Math.round(x)+" para que sea m�ltiplo de "+numeroM);
		scanner.close();
		
	}
}
