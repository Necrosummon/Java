package tablaIndices;

/* Ejercicio 5.2 página 134
 * Crear una tabla que ordene de manera decreciente por índice los números de otra tabla externa llamada tablaOriginal.
 * 
 *  Ejemplo:
 *  tablaOriginal [3, 5, 1, 4]
 *  
 *  Nuestra tabla tiene que ordenar esos números por indice
 *  
 *  tablaConIndices [2, 0, 3, 1]
 *  
 *  Siendo el 5 -> 0
 *			  4 -> 1
 *            3 -> 2
 *            1 -> 3
 * 
 */

public class CrearTablaIndices {
	static public void main (String[] args)
	{
		int tablaOriginal[] = {3,5,1,4};
		int tablaConIndices[] = new int[tablaOriginal.length];
		
		System.out.println("tabla Original:");
		for(int i=0;i<tablaOriginal.length;i++)
			System.out.println(tablaOriginal[i]);	
		
		crearTablaConIndices(tablaOriginal,tablaConIndices);
		
		System.out.println("\nGenerada la tablaConIndices:");
		for(int i=0;i<tablaConIndices.length;i++)
			System.out.println(tablaConIndices[i]);	
				
	}
	
	static int[] crearTablaConIndices(int[] tablaOriginal,int[] tablaConIndices)
	{
		// Rellenamos la tablaConIndices con los valores de la tablaOriginal
				for(int i=0;i<tablaConIndices.length;i++)
					tablaConIndices[i] = tablaOriginal[i];
				
				// Ordenamos la tablaConIndices
				for(int i=0;i<tablaConIndices.length;i++)
				{
					for (int j=i+1; j<tablaConIndices.length; j++)
					{
						if(tablaConIndices[i]<tablaConIndices[j])
						{
							int indiceAux;
							indiceAux = tablaConIndices[i];
							tablaConIndices[i] = tablaConIndices[j];
							tablaConIndices[j] = indiceAux;
						}
					}
				}
				
				// Tabla auxiliar temporal para rellenar comparando ambas tablas
				int tablaAuxiliar[] = new int[tablaOriginal.length];
				
				// Modificamos la tablaConIndices, añadiendo los índices según los números de mayor a menor de tablaOriginal
				for(int i=0;i<tablaOriginal.length;i++)
				{				
					int numeroABuscar = tablaConIndices[i];
					
					for(int j=0;j<tablaOriginal.length;j++)
					{
						if(tablaOriginal[j]==numeroABuscar)
							tablaAuxiliar[j] = i;
					}
				}
				
				// Pasamos a tablaConIndices los indices ordenados de tablaAuxiliar
				for(int i=0;i<tablaConIndices.length;i++)
					tablaConIndices[i] = tablaAuxiliar[i];
				
				tablaAuxiliar = null;
				
		return tablaConIndices;
	}
}
