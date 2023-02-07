package polinomioSegundoGrado;

/* Ejercicio 1.5 página 32
 * Crear un programa que pida los coeficientes a,b y c, así como la x de un polinomio de 2º grado.
 *         
 * y = ax^2+bx+c;
 *              
 */

import java.util.Scanner;
public class calcularPolinomioSegundoGrado {
	static public void main (String[] args)
	{
		int a,b,c,x;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el valor de a: ");
		a = scanner.nextInt();
		System.out.print("Introduce el valor de b: ");
		b = scanner.nextInt();
		System.out.print("Introduce el valor de c: ");
		c = scanner.nextInt();
		System.out.print("Introduce el valor de x: ");
		x = scanner.nextInt();
		
		// Potencias en Java
		// Math.pow(a,b); -> Eleva el valor a a b -> Math.pow(5,2) = 25;
		System.out.println("El valor de Y es: "+Math.round(Math.pow(a*x, 2)+(b*x)+c));
		scanner.close();
	}

}
