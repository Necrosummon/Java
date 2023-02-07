package puntoXY;

/* Ejercicio 7.3 p�gina 220
 * Escribir la clase Punto que represente un punto de 2 dimensiones (componente x, componente y)
 * y disponer de los m�todos:
 * 
 * Punto(double x, double y) -> Crea el objeto Punto
 * void desplaza(double dx) -> Desplaza la componente x la cantidad dx
 * void desplaza(double dx, double dy) -> Desplaza la componente x la cantidad dx, 
 * y desplaza la componente y la cantidad dy.
 * double distanciaEuclidea(Punto otro) -> Devuelve la distancia eucl�dea entre el punto invocante
 * y el Punto otro. 
 * void muestra() -> Muestra por consola la informaci�n relativa al punto.
*/

import java.util.Scanner;
public class Main {
	static public void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		double x,y;
		int opcion;
		Punto punto = new Punto(1,1);
		
		do {
			System.out.println("\n1. Crear punto");
			System.out.println("2. Mostrar coordenadas del punto.");
			System.out.println("3. Desplazar punto en el eje X.");
			System.out.println("4. Desplazar punto en los eje X e Y");
			System.out.println("5. Distancia eucl�dea entre 2 puntos.");
			System.out.println("6. Salir");
			System.out.print("Selecciona una opci�n: ");
			opcion = scanner.nextInt();
			
			switch(opcion)
			{
				case 1:
					System.out.print("\nIntroduce la coordenada X: ");
					x = scanner.nextDouble();
					System.out.print("Introduce la coordenada Y: ");
					y = scanner.nextDouble();
					punto.x = x;
					punto.y = y;
					break;				
				case 2:
					punto.muestra();
					break;		
				case 3:
					System.out.print("\nIntroduce el desplazamiento en el eje X: ");
					x = scanner.nextDouble();
					punto.desplaza(x);
					break;
				case 4:
					System.out.print("\nIntroduce el desplazamiento en el eje X: ");
					x = scanner.nextDouble();
					System.out.print("Introduce el desplazamiento en el eje Y: ");
					y = scanner.nextDouble();
					punto.desplaza(x,y);
					break;
				case 5:
					System.out.print("\nIntroduce la coordenada X del 2� punto: ");
					x = scanner.nextDouble();
					System.out.print("Introduce la coordenada Y del 2� punto: ");
					y = scanner.nextDouble();
					System.out.println("La distancia eucl�dea entre los 2 puntos es: "+punto.distanciaEuclidea(new Punto(x,y)));
					break;
			}
		}while(opcion<6);
		scanner.close();
	}
}
