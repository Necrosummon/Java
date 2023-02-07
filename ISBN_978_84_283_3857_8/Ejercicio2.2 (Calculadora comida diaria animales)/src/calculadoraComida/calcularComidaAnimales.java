package calculadoraComida;

/* Ejercicio 2.2 página 55
 * Crear un programa que solicite 3 valores (comidaDiaria, numAnimales, kilosPorAnimal)
 * y determine si tenemos alimento suficiente para todos los animales. En caso contrario, ha de
 * calcular la ración que corresponde a cada animal.
 * 
 * Evitar que la aplicación realice divisiones por 0.
 * 
 */

import java.util.Scanner;
public class calcularComidaAnimales {
	static public void main (String[] args)
	{
		float comidaDiaria, kilosPorAnimal;
		int numAnimales;
		Scanner scanner = new Scanner (System.in);
		
		System.out.print("Introduce cantidad de comida diaria: ");
		comidaDiaria = scanner.nextFloat();
		System.out.print("Introduce el número de animales: ");
		numAnimales = scanner.nextInt();
		System.out.print("Introduce los kilos que come cada animal: ");
		kilosPorAnimal = scanner.nextFloat();
		
		if(numAnimales*kilosPorAnimal<=comidaDiaria)
			System.out.println("Se dispone de dicha cantidad de comida.");
		else
		{
			System.out.println("Cantidad de comida diaria insuficiente.");
			if(comidaDiaria/numAnimales > 0)
				System.out.println("Se ha reasignado una cantidad equitativa de "+comidaDiaria/numAnimales+ " kilos por animal.");
		}
		scanner.close();
	}
}
