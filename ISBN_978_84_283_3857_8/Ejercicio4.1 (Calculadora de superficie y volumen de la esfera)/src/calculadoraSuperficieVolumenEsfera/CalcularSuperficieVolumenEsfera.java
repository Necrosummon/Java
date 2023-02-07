package calculadoraSuperficieVolumenEsfera;

/* Ejercicio 4.1 página 96
 * Crear una función que calcule la superficie y volumen de una esfera
 * 
 * 	
 *  Superficie = 4pi * radio^2
 * 
 *             4
 *  Volumen = ---pi * radio^3
 *             3
 */

import java.util.Scanner;
public class CalcularSuperficieVolumenEsfera {
	static public void main (String[] args)
	{
		double radio;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el radio de la esfera: ");
		radio = scanner.nextDouble();
		
		System.out.println("Superficie: "+superficieEsfera(radio));
		System.out.println("Volumen: "+ volumenEsfera(radio));
		scanner.close();
	}
	
	static double superficieEsfera (double radio)
	{
		return (4*Math.PI) * Math.pow(radio, 2);
	}
	
	static double volumenEsfera (double radio)
	{
		return ((4*Math.PI)/3) * Math.pow(radio, 3);
	}
}
