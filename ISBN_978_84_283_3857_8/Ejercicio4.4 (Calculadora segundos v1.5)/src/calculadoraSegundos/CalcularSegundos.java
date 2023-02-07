package calculadoraSegundos;

/* Ejercicio 4.4 p�gina 96
 * Crear una funci�n a la que se le pasen como par�metros de entrada una cantidad de d�as, horas y
 * minutos. La funci�n calcular� y devolver� el n�mero de segundos que existen en los datos de entrada.
 */

import java.util.Scanner;
public class CalcularSegundos {
	static public void main (String[] args)
	{
		int dias,horas,minutos;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce los d�as: ");
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
