package juegoAhorcado;

/* Ejercicio 6.1 página 167
 * Realizar el juego del ahorcado.
 * 
 * a) El jugador A teclea una palabra, sin que el jugador B la vea.
 * b) Ahora se le muestra tantos guiones como letras tenga la palabra secreta. Por ejemplo
 * para "hola" será "----".
 * c) El jugador B intentará acertar, letra a letra, la palabra secreta.
 * d) Cada acierto muestra la letra en su lugar y las letras no acertadas seguirán ocultas como
 * guiones. Siguiendo con el ejemplo anterior y suponiendo que se ha introducido: la'o', la 'j' y
 * la 'a', se mostrará -o-a.
 * e) Cada letra no acertada restará un intento. Supondremos que el jugador B solo tiene 7 intentos.
 * f) La partida terminará cuando se acierten todas las letras que forman parte de la palabra secreta
 * (ganando el jugador B) o cuando se agoten todos los intentos (ganando el jugador A)
 * 
 */
import java.util.Scanner;
public class JugarAhorcado {
	static public void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String palabra;
		char palabraLetras[], palabraOculta[];
		String letra;
		int intentos = 7, letrasRestantes = 0;
		boolean finJuego = false, contieneLetra = false;
		
		System.out.print("Introduce una palabra: ");
		palabra = scanner.nextLine();
		
		palabraLetras = new char[palabra.length()];
		palabraOculta = new char[palabra.length()];
		
		for(int i=0;i<palabra.length();i++)
		{
			palabraLetras[i] = palabra.charAt(i);
			palabraOculta[i] = '-';
		}
		
		letrasRestantes = palabra.length();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		
		do {			
			System.out.print("\n[");
			for(int i=0;i<palabra.length();i++)
				System.out.print(palabraOculta[i]);
			System.out.print("]");
			System.out.print("\n\nIntroduce una letra: ");
			letra = scanner.nextLine();
			
			if(letra.length()>1)
				continue;
			
			for(int i=0;i<palabra.length();i++)
			{
				if(letra.charAt(0)==palabraLetras[i])
				{
					palabraOculta[i] = palabraLetras[i];
					contieneLetra = true;
					letrasRestantes--;
				}
			}
			
			if(!contieneLetra)
			{
				intentos--;
				if(intentos>0)
					System.out.println("\nTe quedan "+intentos+" intentos");
				else
					System.out.println("\nTe has quedado sin intentos.");
			}
			
			contieneLetra = false;
			
			if(letrasRestantes==0||intentos==0)
				finJuego = true;
			
		}while(!finJuego);
		
		if(letrasRestantes==0)
		{
			System.out.println("\n\n¡Ha ganado el jugador B!");
			System.out.print("La palabra era: [");
			for(int i=0;i<palabra.length();i++)
				System.out.print(palabraOculta[i]);
			System.out.print("]");
		}
		else
		{
			System.out.println("\n\n¡Ha ganado el jugador A!");
			System.out.println("La palabra era "+palabra);
		}
		
		scanner.close();
	}
}
