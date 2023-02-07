package calculadoraPatas;

/* Ejercicio 1.8 página 32
 * Crear un programa que solicite 3 especies de invertebrados capturados y el número total de patas
 * de estos.
 * 
 * Hormigas -> 6 patas
 * Arañas -> 8 patas
 * Cochinillas -> 14 patas
 */

import java.util.Scanner;
public class calcularPatas {
	static public void main (String[] args)
	{
		int hormigas,arañas,cochinillas;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el número de hormigas: ");
		hormigas = scanner.nextInt();
		System.out.print("Introduce el número de arañas: ");
		arañas = scanner.nextInt();
		System.out.print("Introduce el número de cochinillas: ");
		cochinillas = scanner.nextInt();
		
		System.out.print("Hay un total de "+((hormigas*6)+(arañas*8)+(cochinillas*14))+" patas");
		scanner.close();
	}

}
