package calculadoraDistancia;

/* Ejercicio 4.3 página 96
 * Crear una función static double distance (double x1, double y1, double x2, double y2)
 * que calcule y devuelva la distancia euclídea que separan los puntos x1,y1 de x2,y2
 * 
 * Distancia = Raíz cuadrada de (x1-x2)^2 + (y1-y2)^2
 * 
 */

import java.util.Scanner;
public class CalcularDistancia {
	static public void main (String[] args)
	{
		double x1,x2,y1,y2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce X1: ");
		x1 = scanner.nextDouble();
		System.out.print("Introduce X2: ");
		x2 = scanner.nextDouble();
		System.out.print("Introduce Y1: ");
		y1 = scanner.nextDouble();
		System.out.print("Introduce Y2: ");
		y2 = scanner.nextDouble();
		
		System.out.print("La distancia euclidiana es: "+distance(x1,y1,x2,y2));
		scanner.close();
	}
	
	static double distance (double x1, double y1, double x2, double y2)
	{
		// Math.sqrt es para raíces cuadradas
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}
}
