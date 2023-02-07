package calculadoraSegundos;

/* Ejercicio 4.4 página 96
 * Crear una función a la que se le pasen como parámetros de entrada una cantidad de días, horas y
 * minutos. La función calculará y devolverá el número de segundos que existen en los datos de entrada.
 */

import java.util.Scanner;
public class CalcularSegundos {
	static public void main (String[] args)
	{
		int dias,horas,minutos;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce los días: ");
		dias = scanner.nextInt();
		System.out.print("Introduce las horas: ");
		horas = scanner.nextInt();
		System.out.print("Introduce los minutos: ");
		minutos = scanner.nextInt();
		
		System.out.print("Hay un total de "+calcularSegundos(dias,horas,minutos)+" segundos");
		
		scanner.close();
	}
	
	static int calcularSegundos (int dias, int horas, int minutos)
	{
		return (86400*dias)+(3600*horas)+(60*minutos);
	}
}
