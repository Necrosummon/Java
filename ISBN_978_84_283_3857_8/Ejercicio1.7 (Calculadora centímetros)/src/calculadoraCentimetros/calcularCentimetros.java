package calculadoraCentimetros;

/* Ejercicio 1.7 página 32
 * Crear un programa que solicite 3 distancias, la primera en milímetros, la segunda en centímetros
 * y la tercera en metros.
 * 
 * Luego que sume las 3 distancias y dé el resultado en centímetros.
 */

import java.util.Scanner;
public class calcularCentimetros {
	static public void main (String[] args)
	{
		int milimetros,centimetros,metros;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce los milímetros: ");
		milimetros = scanner.nextInt();
		System.out.print("Introduce los centímetros: ");
		centimetros = scanner.nextInt();
		System.out.print("Introduce los metros: ");
		metros = scanner.nextInt();
		
		System.out.print("La suma da un total de: "+((milimetros/10)+centimetros+(metros*100))+" centímetros");
		scanner.close();
	}

}
