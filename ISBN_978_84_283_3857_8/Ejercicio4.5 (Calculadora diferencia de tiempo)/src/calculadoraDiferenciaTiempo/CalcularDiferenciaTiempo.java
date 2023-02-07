package calculadoraDiferenciaTiempo;

/* Ejercicio 4.5 página 96
 * Crear una función static int diferenciaMin(int hora1, int minuto1, int hora2, int minuto2)
 * La función devolverá la cantidad de minutos que existen de diferencia entre los 2 instantes
 * utilizados
 */

import java.util.Scanner;
public class CalcularDiferenciaTiempo {
	static public void main (String[] args)
	{
		int hora1,minuto1,hora2,minuto2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce la primera hora: ");
		hora1 = scanner.nextInt();
		System.out.print("Introduce los primeros minutos: ");
		minuto1 = scanner.nextInt();
		System.out.print("Introduce la segunda hora: ");
		hora2 = scanner.nextInt();
		System.out.print("Introduce los segundos minutos: ");
		minuto2 = scanner.nextInt();
		
		System.out.print("Hay un diferencia de "+diferenciaMin(hora1,minuto1,hora2,minuto2)+" minutos");
		scanner.close();
	}
	
	static int diferenciaMin (int hora1, int minuto1, int hora2, int minuto2)
	{
		int horas, minutos;
		
		if(hora1>hora2)
			horas = (hora2+24)-hora1;
		else
			horas = hora1-hora2;
		
		if(minuto1>minuto2)
		{
			minutos = 60-minuto1;
			horas--;
		}
		else
			minutos = minuto2-minuto1;
		
		return (horas*60) + minutos;			
	}
}
