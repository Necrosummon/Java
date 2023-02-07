package calculadoraRaizCuadrada;

/* Ejercicio 3.4 p�gina 74
 * Crear un programa que calcule la ra�z cuadrada de un n�mero natural mediante aproximaci�n. En caso
 * de que no sea exacta, mostraremos el resto.
 * Ejemplo: 
 * La ra�z de 23, 5^2 es 25, nos pasamos, entonces es 4, y el resto es 23-16 = 7
 */

import java.util.Scanner;
public class calcularRaizCuadrada {
	static public void main (String[] args)
	{
		int numero;
		boolean exacta = false;
		int indice = 1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce un n�mero: ");
		numero = scanner.nextInt();
		
		while(numero>=(int)Math.pow(indice,2)){
			if(numero==(int)Math.pow(indice,2))
				exacta = true;
			
			indice++;
		}

		
		if(exacta)
			System.out.print("La ra�z cuadrada de "+numero+" es "+(int)Math.sqrt(numero));
		else
			System.out.print("La ra�z cuadrada de "+numero+" es "+(int)Math.sqrt(numero)+" y con resto "+(numero-((int)Math.pow(indice-1,2))));
		
		scanner.close();
	}
}
