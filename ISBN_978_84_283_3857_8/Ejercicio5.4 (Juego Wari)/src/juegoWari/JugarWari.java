package juegoWari;

/* Ejercicio 5.4 página 134
 * Implementar el juego de Wari para dos jugadores.
 * 
 * Mecánicas
 * 1º) Cada jugador tiene 6 agujeros y cada agujero empieza con 4 piedras
 * 2º) El jugador que empiece coge todas las semillas de un hoyo y las distribuye
 * 1 a 1 en los hoyos que se mueve hacia la derecha.
 * 	Ejemplo:
 * 	0 [4][4][4][4][4][4]
 *  1 [4][4][4][4][4][4]
 *     0  1  2  3  4  5
 *  Cogemos los 4 de X1 Y3 y quedaría así después
 *  
 * 	0 [4][4][4][4][5][5]
 *  1 [4][4][4][0][5][5]
 *     0  1  2  3  4  5
 *     
 *  4º) El jugador captura las piedras del jugador rival cuando el último movimiento cae en un hoyo
 *  con 2 o 3 semillas.
 *  
 *  [Reglas adicionales]
 *  1º) Se pueden capturar las piedras de un jugador en varios hoyos si al acabar el último movimiento
 *  los hoyos previos tienen 2 o 3 piedras.
 *   Ejemplo
 *   
 *   [2][3][2] -> Si acaba en el primer 2, el 3 y 2 son capturados también
 *   [2][4][2] -> En este caso, solo capturará el primer 2
 *   
 *   2º) Si un jugador juega con un hoyo que contiene 12 o más piedras, se reparten por todo el tablero SALTANDO el propio hoyo
 *   (deberá quedar vacío)
 *   
 *   3º) Si un jugador se queda sin piedras en su campo, el jugador contrario deberá realizar un movimiento obligatorio en el cual deje
 *   al menos una piedra en el campo rival. De no ser posible, el jugador de las piedras las capturará y finaliza la partida.
 *   
 *   4º) Si un jugador realizando un movimiento captura todas las piedras del campo contrario pero tiene todavía semillas en su campo, la 
 *   jugada quedará tal cual (sin realizar capturas). En el caso que sea el último hoyo del jugador que mueve, si podrá realizar la captura
 *   y esa piedras quedarán en su reserva.
 */

import java.util.Scanner;
public class JugarWari {
	static public void main(String[] args)
	{
		/* Agujeros y piedras iniciales
		 *    Jugador 1 ->	0 [4][4][4][4][4][4]
		 *    Jugador 2 ->  1 [4][4][4][4][4][4]
		 *                     0  1  2  3  4  5
		 *   
		 *  Al jugador 1 le pertenecen las casillas X0 Y0-5
		 *  Al jugador 2 le pertenencen las casillas X1 Y0-5
		 */
		int[][] tablero = new int[2][6];
		
		int piedrasJugador1 = 0, piedrasJugador2 = 0;
		int turnoJugador,ganador;
		int dadoJugador1,dadoJugador2;
		int hoyo;
		boolean movimientoLegal = false, hayGanador = false;
		Scanner scanner = new Scanner(System.in);
		
		// Llenamos el array
		for(int i=0;i<2;i++)
			for(int j=0;j<6;j++)
				tablero[i][j] = 4;
		
		// Determinamos por azar quien empieza
		do {
			dadoJugador1 = (int)(Math.random()*6)+1;
			dadoJugador2 = (int)(Math.random()*6)+1;
			
			if(dadoJugador1>dadoJugador2)
				turnoJugador = 1;
			else
				turnoJugador = 2;			
		}while(dadoJugador1==dadoJugador2);
		
		System.out.println("\n\n\n\n\n\n\n");
		do {
			if(piedrasJugador1>=25||piedrasJugador2>=25) // Determinamos si hay un ganador antes de volver a jugar
			{
				hayGanador = true;
				break;
			}
			for(int i=0;i<2;i++) // Mostramos la matriz de juego
			{
				System.out.print("Jugador "+(i+1)+" ---> ");
				for(int j=0;j<6;j++)
				{
					System.out.print("["+tablero[i][j]+"]");
				}
				System.out.println();
			}
			System.out.println("\t\t0  1  2  3  4  5"); // Indice Y del array, el X depende del jugador
			System.out.println("\n[Jugador 1]: "+piedrasJugador1+" piedras capturadas");
			System.out.println("[Jugador 2]: "+piedrasJugador2+" piedras capturadas");
			System.out.println("[------------------------------------]");
			System.out.println("TURNO DEL JUGADOR "+turnoJugador);
			do {
				System.out.print("Elige el agujero a jugar: ");
				hoyo = scanner.nextInt();
			}while(hoyo>5);
			System.out.println("\n\n\n\n\n\n\n");
			
			if(turnoJugador==1) // JUGADOR 1
			{
				int piedras = tablero[0][hoyo];
				int posicion = hoyo;
				int parteTablero = 0;
				int agujeroGuardado = -1; // Para chequear si hay 12 piedras o más.
				
				if(piedras==0)
				{
					System.out.println("¡SELECCIONA UN AGUJERO CON PIEDRAS!");
					continue;
				}
				
				for(int i=piedras;i>=0;i--)
				{
					int piedrasCampoEnemigo=0;
					for(int j=0;j<5;j++)
						piedrasCampoEnemigo += tablero[1][j];
					
					if((piedrasCampoEnemigo+piedras)-posicion < 1) { // Si no hay piedras en el campo enemigo, debes realizar un movimiento que si las deje
						System.out.print("Movimiento ilegal. Debes dejar una piedra en el campo enemigo.");
						
						for(int l=0;l<5;l++) // Comprueba en tu campo si tienes algún agujero que permita poner semillas en el campo rival
						{
							if (tablero[parteTablero][l]-posicion>1)
							{
								piedras  = tablero[parteTablero][l];
								hoyo = l;
								break;
							}
							else
							{
								piedrasJugador1 += tablero[parteTablero][l];
							}
						}
					}
					
					if(piedras >= 12)
						agujeroGuardado = i; 

					if(agujeroGuardado>-1)
						if(agujeroGuardado == i && piedras>0)
							posicion--;
					
					movimientoLegal = true;
						
					if(posicion==0&&parteTablero==0) // X0 Y0
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						parteTablero++;
					}
					
					else if (posicion>0&&posicion<=4 && parteTablero==0) // X0 Y1-4
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion--;
					}
					else if (posicion==5&&parteTablero==0) // X0 Y5
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion--;
					}
					else if (posicion==0 && parteTablero==1) // X1 Y0
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion++;
					}
					else if(posicion>0&&posicion<=4 && parteTablero==1) // X1 Y1-4
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion++;
					}
					else if(posicion==5 && parteTablero==1) // X1 Y5
					{
						tablero[parteTablero][posicion] += 1;
						parteTablero--;
						piedras--;
					}
				
					//System.out.println("Has quedado en la posición: "+posicion);
					if(i==0) // Agujero donde cae la última piedra
					{
						posicion--;
						if(parteTablero==1)// Comprobamos si estás en la parte del tablero rival
						{
							int piedrasCampoPropio = 0;
							
							for(int k=0;k<5;k++)
								piedrasCampoPropio += tablero[0][k];
							
							if(piedrasCampoPropio>0) // No puedes capturar todas las piedras si hay piedras en tu campo
								if(tablero[parteTablero][0]>=1 && tablero[parteTablero][0]<=2
										&& tablero[parteTablero][1]>=1 && tablero[parteTablero][1]<=2
										&& tablero[parteTablero][2]>=1 && tablero[parteTablero][2]<=2
										&& tablero[parteTablero][3]>=1 && tablero[parteTablero][3]<=2
										&& tablero[parteTablero][4]>=1 && tablero[parteTablero][4]<=2)
								break;
							
							if(tablero[parteTablero][posicion] == 2||tablero[parteTablero][posicion] == 3) // Si el agujero tiene 2 o 3 piedras
							{
								System.out.println("El jugador 1 ha conseguido "+tablero[parteTablero][posicion]+" piedras");
								piedrasJugador1 += tablero[parteTablero][posicion];
								tablero[parteTablero][posicion] = 0;
								
								for(int ultHoyo=posicion-1;ultHoyo>=0;ultHoyo--) // Comprobamos que los agujeros anteriores tengan 2 o 3 piedras para capturarlas
								{
									if(tablero[parteTablero][ultHoyo] == 2||tablero[parteTablero][ultHoyo] == 3) {
										System.out.println("El jugador 1 ha conseguido "+tablero[parteTablero][ultHoyo]+" piedras");
										piedrasJugador1 += tablero[parteTablero][ultHoyo];
										tablero[parteTablero][ultHoyo] = 0;
									}
									else {
										break;
									}
								}
							}
						}
					}
				}
				
				if(movimientoLegal)
				{
					parteTablero = 0;
					tablero[0][hoyo] = 0;
					
					turnoJugador = 2;
				}
				movimientoLegal = false;
				if(piedrasJugador1>=25)
					hayGanador = true;
				// MOVIMIENTO DE PIEDRAS HECHO, FALTA COMPROBAR LAS CAPTURAS
			}
			else // JUGADOR 2
			{
				int piedras = tablero[1][hoyo];
				int posicion = hoyo;
				int parteTablero = 1;
				int agujeroGuardado = -1;
				
				if(piedras==0)
				{
					System.out.println("¡SELECCIONA UN AGUJERO CON PIEDRAS!");
					continue;
				}
				
				for(int i=piedras;i>=0;i--)
				{
					int piedrasCampoEnemigo=0;
					for(int j=0;j<5;j++)
						piedrasCampoEnemigo += tablero[0][j];
					
					if((piedrasCampoEnemigo+piedras)-posicion < 1) { // Si no hay piedras en el campo enemigo, debes realizar un movimiento que si las deje
						System.out.print("Movimiento ilegal. Debes dejar una piedra en el campo enemigo.");
						
						for(int l=0;l<5;l++)
						{
							if (tablero[parteTablero][l]-posicion>1)
							{
								piedras  = tablero[parteTablero][l];
								hoyo = l;
								break;
							}
							else
							{
								piedrasJugador2 += tablero[parteTablero][l];
							}
						}
					}
					
					if(piedras >= 12)
						agujeroGuardado = i; 

					if(agujeroGuardado>-1)
						if(agujeroGuardado == i && piedras>0)
							posicion--;
					
					movimientoLegal = true;
					
					if(posicion==0&&parteTablero==1) // X1 Y0
					{
						tablero[parteTablero][posicion] += 1; 
						piedras--;
						posicion++;
					}
					else if (posicion>0&&posicion<=4&&parteTablero==1) // X1 Y1-Y4
					{
						tablero[parteTablero][posicion] += 1; 
						piedras--;
						posicion++;
					}
					else if (posicion==5 && parteTablero==1) // X1 Y5
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						parteTablero--;
					}
					else if (posicion==5&&parteTablero==0) // X0 Y5
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion--; // Ahora nos movemos hacia la derecha
					}
					else if (posicion<=4&&posicion>0&&parteTablero==0) // X0 Y1-Y4
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						posicion--; // Ahora nos movemos hacia la derecha
					}
					else if (posicion==0&&parteTablero==0) // X0 Y0
					{
						tablero[parteTablero][posicion] += 1;
						piedras--;
						parteTablero++;
					}
					
					if(i==0) // Agujero donde cae la última piedra
					{
						if(parteTablero==0)// Comprobamos si estás en la parte del tablero rival
						{
							int piedrasCampoPropio = 0;
							
							for(int k=0;k<5;k++)
								piedrasCampoPropio += tablero[1][k];
							
							if(piedrasCampoPropio>0) // No puedes capturar todas las piedras si hay piedras en tu campo
								if(tablero[parteTablero][0]>=1 && tablero[parteTablero][0]<=2
										&& tablero[parteTablero][1]>=1 && tablero[parteTablero][1]<=2
										&& tablero[parteTablero][2]>=1 && tablero[parteTablero][2]<=2
										&& tablero[parteTablero][3]>=1 && tablero[parteTablero][3]<=2
										&& tablero[parteTablero][4]>=1 && tablero[parteTablero][4]<=2)
								break;
							
							if(tablero[parteTablero][posicion] == 2||tablero[parteTablero][posicion] == 3) // Si el agujero tiene 2 o 3 piedras
							{
								System.out.println("El jugador 2 ha conseguido "+tablero[parteTablero][posicion]+" piedras");
								piedrasJugador2 += tablero[parteTablero][posicion];
								tablero[parteTablero][posicion] = 0;
								
								for(int ultHoyo=posicion-1;ultHoyo>=0;ultHoyo--) // Comprobamos que los agujeros anteriores tengan 2 o 3 piedras para capturarlas
								{
									if(tablero[parteTablero][ultHoyo] == 2||tablero[parteTablero][ultHoyo] == 3) {
										System.out.println("El jugador 2 ha conseguido "+tablero[parteTablero][ultHoyo]+" piedras");
										piedrasJugador2 += tablero[parteTablero][ultHoyo];
										tablero[parteTablero][ultHoyo] = 0;
									}
									else {
										break;
									}
								}
							}
						}
					}
				}
				
				if(movimientoLegal)
				{
					tablero[1][hoyo] = 0;
					
					turnoJugador = 1;
				}
				movimientoLegal = false;
				if(piedrasJugador2>=25)
					hayGanador = true;
			}
			
		}while(!hayGanador);
		
		if(piedrasJugador1>=25)
			ganador = 1;
		else
			ganador = 2;
		System.out.println("\n\n¡Ha ganado el jugador "+ganador+"!");
		System.out.println("[Jugador 1]: "+piedrasJugador1+" piedras capturadas");
		System.out.println("[Jugador 2]: "+piedrasJugador2+" piedras capturadas");
		hayGanador = false;
		scanner.close();
	}
}
