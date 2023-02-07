package calcularAreaTriangulo;

/* Ejercicio 1.4 página 31
 * Crear un programa que pida la base y la altura de un triángulo y muestre
 * su área.
 * 
 *         base x altura
 * área = ---------------
 *              2
 */

import java.util.Scanner;

public class CalcularAreaTriangulo {
	static public void main (String[] args)
	{
		float base, altura;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce la base: ");
		base = scanner.nextFloat();
		System.out.print("Introduce la altura: ");
		altura = scanner.nextFloat();
		
		System.out.println("El área del triángulo es: "+(base*altura)/2);
		scanner.close();
	}

}
