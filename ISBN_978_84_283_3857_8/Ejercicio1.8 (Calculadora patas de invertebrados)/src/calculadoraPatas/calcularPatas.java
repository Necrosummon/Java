package calculadoraPatas;

/* Ejercicio 1.8 p�gina 32
 * Crear un programa que solicite 3 especies de invertebrados capturados y el n�mero total de patas
 * de estos.
 * 
 * Hormigas -> 6 patas
 * Ara�as -> 8 patas
 * Cochinillas -> 14 patas
 */

import java.util.Scanner;
public class calcularPatas {
	static public void main (String[] args)
	{
		int hormigas,ara�as,cochinillas;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el n�mero de hormigas: ");
		hormigas = scanner.nextInt();
		System.out.print("Introduce el n�mero de ara�as: ");
		ara�as = scanner.nextInt();
		System.out.print("Introduce el n�mero de cochinillas: ");
		cochinillas = scanner.nextInt();
		
		System.out.print("Hay un total de "+((hormigas*6)+(ara�as*8)+(cochinillas*14))+" patas");
		scanner.close();
	}

}
