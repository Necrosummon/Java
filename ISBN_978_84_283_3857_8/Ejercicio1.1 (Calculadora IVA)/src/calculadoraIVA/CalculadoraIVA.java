package calculadoraIVA;

/* Ejercicio 1.1 página 31
 * Realizar un programa que haga cálculos con IVA
 * La aplicación debe solicitar la base imponible y el IVA a aplicar
 * Debemos mostrar en pantalla el importe correspondiente al IVA y el total.
 */

import java.util.Scanner;

public class CalculadoraIVA {	
	public static void main (String[] args)
	{
		float baseImponible;
		float IVA;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce la base imponible: ");
		baseImponible = scanner.nextFloat();
		System.out.print("Introduce el IVA a aplicar: ");
		IVA = scanner.nextFloat();
		System.out.println("Base imponible: "+baseImponible+"€");
		System.out.println("IVA aplicado: "+IVA+"% -> "+((baseImponible*IVA)/100)+"€");
		System.out.println("Precio final: "+(baseImponible+((baseImponible*IVA)/100))+"€");
		scanner.close();
	}
}
