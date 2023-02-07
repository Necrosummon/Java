package calculadoraRaizCuadrada;

/* Ejercicio 3.4 página 74
 * Crear un programa que calcule la raíz cuadrada de un número natural mediante aproximación. En caso
 * de que no sea exacta, mostraremos el resto.
 * Ejemplo: 
 * La raíz de 23, 5^2 es 25, nos pasamos, entonces es 4, y el resto es 23-16 = 7
 */

import java.util.Scanner;
public class calcularRaizCuadrada {
	static public void main (String[] args)
	{
		int numero;
		boolean exacta = false;
		int indice = 1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un número: ");
		numero = scanner.nextInt();
		
		while(numero>=(int)Math.pow(indice,2)){
			if(numero==(int)Math.pow(indice,2))
				exacta = true;
			
			indice++;
		}

		
		if(exacta)
			System.out.print("La raíz cuadrada de "+numero+" es "+(int)Math.sqrt(numero));
		else
			System.out.print("La raíz cuadrada de "+numero+" es "+(int)Math.sqrt(numero)+" y con resto "+(numero-((int)Math.pow(indice-1,2))));
		
		scanner.close();
	}
}
