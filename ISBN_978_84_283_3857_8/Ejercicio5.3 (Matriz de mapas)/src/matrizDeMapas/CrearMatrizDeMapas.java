package matrizDeMapas;

/* Ejercicio 5.3 p�gina 134
 * Crear una aplicaci�n que pregunte el n�mero de lugares del mapa (de 0 a n), cree una matriz de tipo mapa
 * y cargue los pasos que existe ENTRE LUGARES I J.
 * 
 *  Ejemplo:
 *  lugar0 -> lugar2 -> lugar1 -> lugar3
 *                         |
 *                         v
 *                      lugar 0
 *  
 *  La matriz del mapa ser�:
 *  
 *  i
 *  0 false false true  false
 *  1 true  false false true
 *  2 false true  false false
 *  3 false false false false
 *    j 0    1     2     3
 *     
 * La aplicaci�n debe solicitar dos lugares (i,j), mediante sus n�meros asignados, e indicar si existe
 * alg�n posible camino entre ellos.
 * 
 */

import java.util.Scanner;
public class CrearMatrizDeMapas {
	static public void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n,x1,x2,y1,y2;
		
		System.out.print("Introduce el tama�o del mapa: ");
		n = scanner.nextInt();
		boolean t[][] = crearMapa(n);
		
		do{
			System.out.print("Introduce la coordenada x del primer lugar: ");
			x1 = scanner.nextInt();
			System.out.print("Introduce la coordenada y del primer lugar: ");
			y1 = scanner.nextInt();
			System.out.print("Introduce la coordenada x del segundo lugar: ");
			x2 = scanner.nextInt();
			System.out.print("Introduce la coordenada y del segundo lugar: ");
			y2 = scanner.nextInt();
		}while(x1+1>n||y1+1>n||x2+1>n||y2+1>n);
		
		System.out.println();
		if(t[x1][y1]==true && t[x2][y2]==true)
			System.out.println("Hay un camino entre los 2 lugares.");
		else
			System.out.println("No hay un camino disponible.");
		
		System.out.println();
		revelarMapa(t);
		
		scanner.close();
	}
	
	static boolean[][] crearMapa (int tamano)
	{
		boolean t[][] = new boolean[tamano][tamano];
		for(int i=0;i<t.length;i++)
		{
			int randomCoord = (int)(Math.random()*t.length-1)+1;

			for (int j=0;j<t.length;j++)
			{
				if(j==randomCoord)
					t[j][i] = true;
			}
		}
		return t;
	}
	
	static boolean[][] revelarMapa (boolean t[][])
	{
		for(int i=0;i<t.length;i++)
		{
			for(int j=0;j<t.length;j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		return t;
	}
}
