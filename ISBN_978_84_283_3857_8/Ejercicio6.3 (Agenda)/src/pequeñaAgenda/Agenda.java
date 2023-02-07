package peque�aAgenda;
/* Ejercicio 6.3 p�gina 167
 * Dise�ar una aplicaci�n que se comporte como una peque�a agenda. Mediante un men� al usuario podr�
 * elegir entre:
 * 
 * 1) A�adir nuevo contacto (nombre y tel�fono) siempre y cuando la agenda no est� llena.
 * 2) Buscar el tel�fono de un contacto a partir de su nombre.
 * 3) Mostrar la informaci�n de todos los contactos ordenados alfab�ticamente mediante el nombre.
 * 
 * La agenda tendr� como m�ximo 20 contactos.
 * 
 * - Metodolog�a
 * agenda[i][0-1]
 * subIndice 0 -> Nombre
 * subIndice 1 -> Tel�fono
 */
import java.util.Scanner;
public class Agenda {
	static public void main(String[] args)
	{
		String[][] agenda = new String[1][2];
		int opcion=0, contactos=0, maxContactos=20;
		String nombre,telefono;
		Scanner scanner = new Scanner(System.in);
	
		do {
			System.out.println("\n1) A�adir nuevo contacto");
			System.out.println("2) Buscar tel�fono de un contacto a partir de su nombre");
			System.out.println("3) Mostrar la informaci�n de todos los contactos ordenados alfab�ticamente mediante el nombre");
			System.out.print("Selecciona una opci�n: ");
			opcion = scanner.nextInt();

			switch(opcion)
			{
				case 1:
					if(contactos<=maxContactos)
					{
						// Extendiendo la agenda por cada contacto que vaya a meter
						String nuevaAgenda[][] = new String[contactos+1][2];
						
						for(int i=0;i<agenda.length;i++)
							for(int j=0;j<2;j++)
								nuevaAgenda[i][j] = agenda[i][j];
						
						agenda = nuevaAgenda;
						
						System.out.print("\nIntroduce el nombre: ");
						nombre = scanner.next();
						System.out.print("Introduce el tel�fono: ");
						telefono = scanner.next();
						anadirNuevoContacto(agenda,nombre,telefono);
						contactos++;
					}
					else
						System.out.println("Alcanzado el l�mite de 20 contactos.\n\n");
					break;
				case 2:
					System.out.print("\nIntroduce el nombre: ");
					nombre = scanner.next();
					buscarTelefono(agenda,nombre);
					break;
				case 3:
					mostrarInformacionContactos(agenda);
					break;	
			}
		}while(opcion<=3);
		scanner.close();
	}
	
	static void anadirNuevoContacto(String[][] agenda, String nombre, String telefono)
	{
		for(int i=0;i<agenda.length;i++)
			if(agenda[i][0] == null)
			{
				agenda[i][0] = nombre;
				agenda[i][1] = telefono;
				break;
			}
	}
	
	static void buscarTelefono(String[][] agenda, String nombre)
	{
		boolean existe = false;
		for(int i=0;i<agenda.length;i++)
		{
			if(agenda[i][0]!=null)
			if(agenda[i][0].equalsIgnoreCase(nombre))
			{
				System.out.println("Tel�fono: "+agenda[i][1]);
				existe = true;
			}
		}
		if(!existe)
			System.out.println("No hay ning�n contacto con ese nombre.");
	}
	
	static void mostrarInformacionContactos(String[][] agenda)
	{
		System.out.println("[NOMBRE]       -      [TEL�FONO]");
		for(int i=0;i<agenda.length;i++)
		{
			for(int j=i+1;j<agenda.length;j++)
			{
				if(agenda[i][0].compareToIgnoreCase(agenda[j][0])>0) // Comparamos los nombres para ordenarlos
				{
						String nombreAux;
						String telefonoAux;
						nombreAux = agenda[i][0];
						telefonoAux = agenda[i][1];
						agenda[i][0] = agenda[j][0];
						agenda[i][1] = agenda[j][1];
						agenda[j][0] = nombreAux;
						agenda[j][1] = telefonoAux;						
				}
			}
		}
		for(int i=0;i<agenda.length;i++)
		{
			for(int j=0;j<2;j++)
				System.out.print(agenda[i][j]+"                  ");
			
			System.out.println("");
		}
		System.out.println("");
	}
} 
