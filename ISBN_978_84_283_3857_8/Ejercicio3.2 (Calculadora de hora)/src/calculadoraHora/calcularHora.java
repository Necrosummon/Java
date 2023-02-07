package calculadoraHora;

/* Ejercicio 3.2 página 74
 * Crear un programa que incremente la hora de un reloj.
 * Se pedirá por teclado la hora, minutos y segundos y cuantos segundos se quiere incrementar.
 * Por ejemplo: Si las 13:59:51 se incrementan 10 segundos, resultan las 14:00:01
 */

import java.util.Scanner;
public class calcularHora {
	static public void main (String[] args)
	{
		int horas,minutos,segundos,incrementarSegundos;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Introduce las horas: ");
		horas = scanner.nextInt();
		System.out.print("Introduce los minutos: ");
		minutos = scanner.nextInt();
		System.out.print("Introduce los segundos: ");
		segundos = scanner.nextInt();
		System.out.print("Introduce el incremento en segundos: ");
		incrementarSegundos = scanner.nextInt();
		
		// Incrementamos los segundos por teclado
		segundos = segundos+incrementarSegundos;
		
		while(segundos>59){
			segundos = segundos - 60;
			minutos++;
			while(minutos>59) {
				minutos = minutos - 60;
				horas++;
			}	
		}
		
		System.out.print("Son las "+(horas));
		if(minutos<10)
			System.out.print(":0"+minutos);
		else
			System.out.print(":"+minutos);
		if(segundos<10)
			System.out.print(":0"+segundos);
		else
			System.out.print(":"+segundos);
		scanner.close();
	}

}
