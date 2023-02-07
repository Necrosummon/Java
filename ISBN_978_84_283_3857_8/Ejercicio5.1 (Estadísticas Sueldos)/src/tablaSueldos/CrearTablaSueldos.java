package tablaSueldos;

/* Ejercicio 5.1 página 134
 * Crear una aplicación que haga una estadística de un ayuntamiento para conocer el nivel adquisitivo.
 * Para ello tendremos que preguntar el sueldo a cada persona encuestada.
 * No se conoce el número de encuestados.
 * Para finalizar la entrada de datos, introducimos un sueldo con valor -1
 * Una vez introducidos todos los sueldos, mostraremos la siguiente información:
 * 
 *  Todos los sueldos ordenados decrecientemente
 *  El sueldo más alto y más bajo
 *  La media de los sueldos
 */

import java.util.Scanner;
public class CrearTablaSueldos {
	static public void main (String[] args)
	{
		double sueldo, sueldoMax = 0, sueldoMin = 9999999, totalSueldos=0;
		int numSueldos = 0;
		double tablaSueldos[] = new double[1];
		Scanner scanner = new Scanner(System.in);
		
		do
		{
			System.out.print("Introduce un sueldo (-1 para finalizar): ");
			sueldo = scanner.nextDouble();
			
			if(sueldo>-1)
			{
				// Creamos una nueva tabla con 1 índice más
				double nuevaTabla[] = new double[numSueldos+1];
				
				// Pasamos la información de tablaSueldos a nuevaTabla (que tiene un índice más vacío)
				for(int i=0;i<tablaSueldos.length;i++)
				{
					nuevaTabla[i] = tablaSueldos[i];
				}
				
				// tablaSueldos pasa a ser nuevaTabla (con 1 índice más)
				tablaSueldos = nuevaTabla;
				
				// Metemos el sueldo en el índice según el numSueldo
				tablaSueldos[numSueldos] = sueldo;
				totalSueldos += sueldo;
				numSueldos++;
				
				if(sueldo>sueldoMax)
					sueldoMax = sueldo;
				
				if(sueldo<sueldoMin && sueldo>-1)
					sueldoMin = sueldo;
			}
			
		}while(sueldo!=-1);
		
		System.out.println("Esta es la tabla salarial ordenada por sueldo decrecientemente:");
		
		// Ordenar la tabla 
		for(int i=0;i<tablaSueldos.length;i++)
		{
			for (int j=i+1; j<tablaSueldos.length; j++)
			{
				if(tablaSueldos[i]<tablaSueldos[j])
				{
					double sueldoAux;
					sueldoAux = tablaSueldos[i];
					tablaSueldos[i] = tablaSueldos[j];
					tablaSueldos[j] = sueldoAux;
				}
			}
			System.out.println((i+1)+"º) "+tablaSueldos[i]+"€");
		}
		
		System.out.println("El sueldo más alto es "+sueldoMax+"€. El sueldo más bajo es "+sueldoMin+"€. La media salarial es "+totalSueldos/numSueldos+"€");
		
		scanner.close();
	}
}
