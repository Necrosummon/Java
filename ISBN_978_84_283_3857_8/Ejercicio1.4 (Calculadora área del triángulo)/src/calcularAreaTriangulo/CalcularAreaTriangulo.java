package calcularAreaTriangulo;

/* Ejercicio 1.4 p�gina 31
 * Crear un programa que pida la base y la altura de un tri�ngulo y muestre
 * su �rea.
 * 
 *         base x altura
 * �rea = ---------------
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
		
		System.out.println("El �rea del tri�ngulo es: "+(base*altura)/2);
		scanner.close();
	}

}
