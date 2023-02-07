package calculadoraSegundos;

/* Ejercicio 1.6 página 32
 * Crear un programa que pida una cantidad de segundos y mostrar cuantas horas, minutos y segundos
 * hay en el número de segundos introducido           
 */

import java.util.Scanner;
public class calcularSegundos {
	static public void main(String[] args)
	{
		int segundos;
		Scanner scanner = new Scanner (System.in);
		
		System.out.print("Introduce los segundos: ");
		segundos = scanner.nextInt();
		
		/* Ejemplo: 4000 segundos
		 * Horas -> segundos / 3600 -> 1 hora
		 * Minutos -> (segundos%3600)/60 -> (400)/60 -> 6 minutos
		 * Segundos -> (segundos3600)%60 -> 40 segundos (resto de 400/60)
		 */
		
		System.out.print("Hay "+segundos/3600+" horas, "+(segundos%3600)/60+" minutos y "+((segundos%3600)%60)+" segundos en "+segundos+" segundos");
		scanner.close();
	}

}
