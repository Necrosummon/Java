package calculadoraCentimetros;

/* Ejercicio 1.7 p�gina 32
 * Crear un programa que solicite 3 distancias, la primera en mil�metros, la segunda en cent�metros
 * y la tercera en metros.
 * 
 * Luego que sume las 3 distancias y d� el resultado en cent�metros.
 */

import java.util.Scanner;
public class calcularCentimetros {
	static public void main (String[] args)
	{
		int milimetros,centimetros,metros;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce los mil�metros: ");
		milimetros = scanner.nextInt();
		System.out.print("Introduce los cent�metros: ");
		centimetros = scanner.nextInt();
		System.out.print("Introduce los metros: ");
		metros = scanner.nextInt();
		
		System.out.print("La suma da un total de: "+((milimetros/10)+centimetros+(metros*100))+" cent�metros");
		scanner.close();
	}

}
