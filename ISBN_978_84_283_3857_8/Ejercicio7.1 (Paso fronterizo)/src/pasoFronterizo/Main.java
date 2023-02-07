package pasoFronterizo;
/* Ejercicio 7.1 página 219
 * Diseñar una aplicación que presente las siguientes opciones:
 * 
 * 1. Paso de frontera
 * 2. Mostrar todas las personas
 * 3. Búsqueda por nombre
 * 4. Búsqueda por DNI
 * 5. Salir
 * 
 * La opción 1 recoge los datos de la persona que transita a través de la frontera
 * La opción 2 muestra la información de todas las personas que han pasado por la frontera
 * La opción 3 solicita un nombre por teclado y muestra  la información de todas las personas que
 * cuyo nombre sea el introducido
 * La opción 4 introducimos un DNI por teclado y nos mostrará la información de esa persona
 */
import java.util.Scanner;
public class Main {
	static public void main(String[] args)
	{
		int opcion = 0;
		String nombre, dni;
		Scanner scanner = new Scanner(System.in);
		ListaPersonas listaPersonas = new ListaPersonas();
		
		do {
			System.out.println("1. Paso de frontera");
			System.out.println("2. Mostrar todas las personas");
			System.out.println("3. Búsqueda por nombre");
			System.out.println("4. Búsqueda por DNI");
			System.out.println("5. Salir");
			System.out.print("Elige una opción: ");
			opcion = scanner.nextInt();
			
			switch(opcion)
			{
				case 1:
					scanner.nextLine();// Para hacer un salto de línea antes de introducir el nombre
					System.out.print("\nIntroduce el nombre completo: ");
					nombre = scanner.nextLine();
					System.out.print("Introduce el DNI: ");
					dni = scanner.next();
					Persona persona = new Persona(nombre,dni);
					if(persona.esDNIValido(dni))
						listaPersonas.insertarPersona(persona);
					else
						System.out.println("DNI Incorrecto. La persona no se ha introducido en la lista.");
					break;
				case 2:
					listaPersonas.mostrarListaPersonas();
					break;
				case 3:
					System.out.print("\nIntroduce el nombre a buscar: ");
					nombre = scanner.next();
					listaPersonas.buscarPorNombre(nombre);
					break;
				case 4:
					System.out.print("\nIntroduce el DNI a buscar: ");
					dni = scanner.next();
					listaPersonas.buscarPorDNI(dni);
					break;
			}
		}while(opcion<5);
		scanner.close();
	}
}
