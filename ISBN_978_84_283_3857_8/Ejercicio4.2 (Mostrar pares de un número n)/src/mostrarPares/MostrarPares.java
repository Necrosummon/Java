package mostrarPares;

/* Ejercicio 4.2 página 96
 * Crear una función muestraPares (int n) que muestre por consola los primeros n pares
 */

import java.util.Scanner;

public class MostrarPares {
	static public void main (String[] args)
	{
		int n;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un número n: ");
		n = scanner.nextInt();
		
		muestraPares(n);
		scanner.close();
	}
	
	static void muestraPares (int n)
	{
		for(int i=2;i<=n;i+=2)
		{
			System.out.println(i);
		}
	}
}
