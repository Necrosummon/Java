package calendario;
/* Ejercicio 7.2 p�gina 219
 * Dise�ar la clase Calendario que represente una fecha concreta (a�o,mes y d�a). La clase debe
 * disponer de los m�todos:
 * 
 * Calendario(int a�o, int mes, int dia)
 * void incrementarDia(int cantidad)
 * void incrementarMes(int cantidad)
 * void incrementarA�o(int cantidad)
 * void mostrar()
 * boolean iguales(Calendario otroCalendario)
 * 
 * */
import java.util.Scanner;
public class Main {
	static public void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int a�o,mes,dia,opcion;
		Calendario calendario = new Calendario(1,1,1);
		
		do {
			System.out.println("\n1. Crear fecha de calendario.");
			System.out.println("2. Incrementar la fecha a�os / meses / d�as.");
			System.out.println("3. Mostrar la fecha del calendario.");
			System.out.println("4. Comparar fechas de calendario.");
			System.out.println("5. Salir");
			System.out.print("Selecciona una opci�n: ");
			opcion = scanner.nextInt();
			
			switch(opcion)
			{
				case 1:
					System.out.print("\nIntroduce un a�o: ");
					a�o = scanner.nextInt();
					System.out.print("Introduce un mes: ");
					mes = scanner.nextInt();
					System.out.print("Introduce un dia: ");
					dia = scanner.nextInt();			
					calendario = new Calendario(a�o,mes,dia);
					break;
				case 2:
					System.out.println("\n1. Incrementar en a�os.");
					System.out.println("2. Incrementar en meses.");
					System.out.println("3. Incrementar en d�as");
					System.out.print("Selecciona una opci�n: ");
					opcion = scanner.nextInt();
					
					switch(opcion)
					{
						case 1:
							System.out.print("\nIncremento de a�os: ");
							calendario.incrementarA�o(opcion=scanner.nextInt());
							opcion = 0;
							break;
						case 2:
							System.out.print("Incremento de meses: ");
							calendario.incrementarMes(opcion=scanner.nextInt());
							opcion = 0;
							break;
						case 3:
							System.out.print("Incremento de d�as: ");
							calendario.incrementarDia(opcion=scanner.nextInt());
							opcion = 0;
							break;
					}
					break;
				case 3:
					calendario.mostrar();
					break;
				case 4:
					System.out.print("\nIntroduce un a�o: ");
					a�o = scanner.nextInt();
					System.out.print("Introduce un mes: ");
					mes = scanner.nextInt();
					System.out.print("Introduce un dia: ");
					dia = scanner.nextInt();
					calendario.iguales(new Calendario(a�o,mes,dia));					
			}
		}while(opcion<5);
		
		scanner.close();		
	}
}
