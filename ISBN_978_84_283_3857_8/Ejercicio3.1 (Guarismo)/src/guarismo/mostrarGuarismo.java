package guarismo;

/* Ejercicio 3.1 p�gina 74
 * Crear un programa que pida un n�mero de 3 cifras y lo muestre guarismo a guarismo.
 * Si introduces el 123, primero mostrar� el 1, luego el 2 y por �ltimo el 3.  
 */

import java.util.Scanner;
public class mostrarGuarismo {
	static public void main (String[] args)
	{
		int numero;
		Scanner scanner = new Scanner(System.in);
		
		/* Evitar n�meros mayores de 3 cifras
		 * Si escribes 0001 por ejemplo, mostrar� los 3 �ltimos.
		 */
		
		do
		{
			System.out.print("Introduce un n�mero de 3 cifras: ");
			numero = scanner.nextInt();
		}while(numero>999);
		
		for (int i=2;i>=0;i--)
			/*
			 * Dividimos el n�mero entre 10 elevado a i y le restamos la division entre n�mero entre 10 elevado a i-1 y lo multiplicamos por 10
			 * Introducimos 123 e inicia el bucle
			 * (123 / 10^2) -> 123/100 = 1,23 -> 1
			 * (123 / 10^3) -> 123/1000 = 0,123 -> 0 * 10 -> 0
			 * 1 - 0 = 1
			 * 
			 * (123 / 10^1) -> 123/10 -> 12,3 -> 12
			 * (123 / 10^2) -> 123/100 -> 1,23 -> 1 * 10 -> 10
			 * 12 - 10 = 2
			 * 
			 * (123 / 10^0) -> 123/1 -> 123
			 * (123 / 10^1) -> 123/10 -> 12,1 -> 12 * 10 = 120
			 * 123 - 120 = 3
			 * 
			 */
			System.out.println((int)(numero/Math.pow(10,i)) - (int)(numero/Math.pow(10,i+1))*10);

		scanner.close();
	}
}