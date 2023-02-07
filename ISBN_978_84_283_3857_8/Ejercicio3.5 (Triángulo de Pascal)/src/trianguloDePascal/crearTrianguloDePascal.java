package trianguloDePascal;

/* Ejercicio 3.5 página 74
 * Crear un programa que dibuje un triángulo de Pascal para n filas, numerando filas desde 0.
 * Ejemplo Pascal con 5 filas (n=4)
 * 
 * 	1
 *  1 1
 *  1 2 1
 *  1 3 3 1
 *  1 4 6 4 1
 */

import java.util.Scanner;
public class crearTrianguloDePascal {
	static public void main (String[] args)
	{
		int n;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce el valor de n: ");
		n = scanner.nextInt();
		
		for(int i=0;i<n+1;i++)
		{
			int number = 1;
			System.out.println();
			for(int j=0;j<=i;j++)
			{
				System.out.print(number+" ");
				number = number * (i-j) / (j+1); // Fórmula Triángulo Pascal
			}
		}		
		scanner.close();
	}
}
