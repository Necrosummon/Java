package pasoFronterizo;

public class ListaPersonas {
	private Persona tablaPersonas[];
	private int numPersonas = 1;
	
	public ListaPersonas()
	{
		tablaPersonas = new Persona[numPersonas];
	}
	
	void insertarPersona (Persona persona)
	{
		for (int i=0;i<numPersonas;i++)
		{
			if(tablaPersonas[i]==null)
			{
				tablaPersonas[i] = persona;
				break;
			}
		}
		
		/* Hacemos la lista 1 espacio más grande al acabar de insertar la persona
		 * Por si se quieren seguir ampliando
		 */
		numPersonas++;
		Persona nuevaTabla[] = new Persona[numPersonas];
		
		for(int i=0;i<numPersonas-1;i++)
				nuevaTabla[i] = tablaPersonas[i];
		
		tablaPersonas = nuevaTabla;
	}
	
	void mostrarListaPersonas()
	{
		System.out.println("[NOMBRE] - [DNI]");
		for (int i=0;i<numPersonas;i++)
			if(tablaPersonas[i]!=null)
				System.out.println(tablaPersonas[i].nombre +" - "+tablaPersonas[i].dni);
		System.out.println("\n");
	}
	
	void buscarPorNombre (String nombre)
	{
		boolean existe = false;
		
		System.out.println("[NOMBRE] - [DNI]");
		for (int i=0;i<numPersonas;i++)
		{
			if(tablaPersonas[i]!=null) {
				if(tablaPersonas[i].nombre.contains(nombre)){
					System.out.println(tablaPersonas[i].nombre +" - "+tablaPersonas[i].dni);
					existe = true;
				}
			}
		}
		System.out.println();
		if(!existe)
			System.out.println("No se ha encontrado personas con ese nombre.\n");
	}
	void buscarPorDNI (String dni)
	{
		boolean existe = false;
		for (int i=0;i<numPersonas;i++)
		{
			if(tablaPersonas[i]!=null) {
				if(tablaPersonas[i].dni.equalsIgnoreCase(dni)){
					System.out.println("Nombre: "+tablaPersonas[i].nombre +"\nDNI: "+tablaPersonas[i].dni);
					existe = true;
				}
			}
		}
		System.out.println();
		if(!existe)
			System.out.println("No se ha encontrado personas con ese DNI.\n");
	}
}
