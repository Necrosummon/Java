package multiplo7;

/* Ejercicio 1.2 página 31
 * Realizar un programa que tome como entrada un número entero (int) y nos indique
 * que cantidad hay que sumarle para que el resultado sea múltiplo de 7.
 * Ej: A 2 hay que sumarle 5 para que sea múltiplo de 7.
 * 	   A 13 hay que sumarle 1 para que sea múltiplo de 7.
 * Si proporcionamos los números 2 o 13 la salida debería ser 5 o 1.
 */

import java.util.Scanner;

public class Multiplo7 {
	public static void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int numero;
		float x;
		
		System.out.print("Introduce un número: ");
		numero = scanner.nextInt();
		
		x = (float)numero/7; 
		x = x - (int)numero/7; 
		x = x*7; 
		x = 7-x; 
		
		/*
		 * Ejemplo: Introducimos 11 por teclado
		 * 
		 * x = 11/7 = 1.5 -> Dividimos el número por 7
		 * x = 1.5 - 1 = 0.5 -> Restamos la parte entera al número decimal
		 * x = 0.5*7 = 3.5 -> Multiplicamos el resultado previo por 7
		 * x = 7-3.5 = 3.5 -> A 7 le restamos el resultado previo y lo redondeamos
		 * 
		 * Se redondea a 3, entonces 11+3 = 14, que es múltiplo de 7.
		 */
		
		x = x != 7 ? x : 0; // Operador terciario -> Si X es diferente de 7 toma el valor de X, si no toma 0.
		
		System.out.print("A "+numero+" hay que añadirle "+Math.round(x)+" para que sea múltiplo de 7");
		
		scanner.close();
	}
}
