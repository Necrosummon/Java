package ecoApp;

/* Ejercicio 3.3 p�gina 74
 * Crear un programa que pida un n�mero a introducir por el usuario y repita "Eco..."
 * Tantas veces como el n�mero indicado
 */

import java.util.Scanner;
public class startEcoApp {
	static public void main (String[] args)
	{
		int ecoTimes;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un n�mero: ");
		ecoTimes = scanner.nextInt();
		
		for(int i=0;i<ecoTimes;i++)
		{
			System.out.println("Eco...");
		}
		scanner.close();
	}
}
