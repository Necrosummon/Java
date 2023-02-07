package calendario;
/* Ejercicio 7.2 página 219
 * Diseñar la clase Calendario que represente una fecha concreta (año,mes y día). La clase debe
 * disponer de los métodos:
 * 
 * Calendario(int año, int mes, int dia)
 * void incrementarDia(int cantidad)
 * void incrementarMes(int cantidad)
 * void incrementarAño(int cantidad)
 * void mostrar()
 * boolean iguales(Calendario otroCalendario)
 * 
 * */
import java.util.Scanner;
public class Main {
	static public void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int año,mes,dia,opcion;
		Calendario calendario = new Calendario(1,1,1);
		
		do {
			System.out.println("\n1. Crear fecha de calendario.");
			System.out.println("2. Incrementar la fecha años / meses / días.");
			System.out.println("3. Mostrar la fecha del calendario.");
			System.out.println("4. Comparar fechas de calendario.");
			System.out.println("5. Salir");
			System.out.print("Selecciona una opción: ");
			opcion = scanner.nextInt();
			
			switch(opcion)
			{
				case 1:
					System.out.print("\nIntroduce un año: ");
					año = scanner.nextInt();
					System.out.print("Introduce un mes: ");
					mes = scanner.nextInt();
					System.out.print("Introduce un dia: ");
					dia = scanner.nextInt();			
					calendario = new Calendario(año,mes,dia);
					break;
				case 2:
					System.out.println("\n1. Incrementar en años.");
					System.out.println("2. Incrementar en meses.");
					System.out.println("3. Incrementar en días");
					System.out.print("Selecciona una opción: ");
					opcion = scanner.nextInt();
					
					switch(opcion)
					{
						case 1:
							System.out.print("\nIncremento de años: ");
							calendario.incrementarAño(opcion=scanner.nextInt());
							opcion = 0;
							break;
						case 2:
							System.out.print("Incremento de meses: ");
							calendario.incrementarMes(opcion=scanner.nextInt());
							opcion = 0;
							break;
						case 3:
							System.out.print("Incremento de días: ");
							calendario.incrementarDia(opcion=scanner.nextInt());
							opcion = 0;
							break;
					}
					break;
				case 3:
					calendario.mostrar();
					break;
				case 4:
					System.out.print("\nIntroduce un año: ");
					año = scanner.nextInt();
					System.out.print("Introduce un mes: ");
					mes = scanner.nextInt();
					System.out.print("Introduce un dia: ");
					dia = scanner.nextInt();
					calendario.iguales(new Calendario(año,mes,dia));					
			}
		}while(opcion<5);
		
		scanner.close();		
	}
}
