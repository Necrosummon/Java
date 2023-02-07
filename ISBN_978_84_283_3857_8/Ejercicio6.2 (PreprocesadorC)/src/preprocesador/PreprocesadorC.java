package preprocesador;
/* Ejercicio 6.2 p�gina 167
 * El preprocesador de C elimina los comentarios /* ...... ^/ del c�digo fuente antes de compilar
 *
 * Dise�a un programa que lea por teclado una sentencia en C, y elimine los comentarios.
 * 
 * Ejemplo:
 */
 // if (a==3) /* igual a tres */ a++; /* incrementamos a */
 /* 
 * Deber�a devolver
 * 
 * if (a==3) a++;
 */

import java.util.Scanner;
public class PreprocesadorC {
	static public void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String sentencia, sentenciaPreprocesada="";
		boolean comentario = false;
		
		System.out.print("Introduce una sentencia en C:" );
		sentencia = scanner.nextLine();
		
		for(int i=0;i<sentencia.length();i++)
		{		
			/*
			 * Especificamos que si el car�cter actual es '*' y el previo es '/' 
			 * es /* (inicio de comentario), y todo lo que venga a continuaci�n ser� comentario.
			 */
			if(sentencia.charAt(i)=='*')
				if(i>0) // Evitamos �ndices que no existen, tipo -1.
					if(sentencia.charAt(i-1)=='/')
						comentario = true; 
			
			/*
			 * Especificamos que si el car�cter actual es '/' y el previo es '*' 
			 * es +/ (fin de comentario), y todo lo que venga a continuaci�n ser� c�digo.
			 */
			if(sentencia.charAt(i)=='/')
				if(i>0)
					if(sentencia.charAt(i-1)=='*')
						comentario = false;
			
			/*
			 * Si no es comentario, pasamos a chequear el caracter, si es diferente a '/' o  '*'
			 * Se meter� en el string preprocesado
			 */
			if(!comentario)
				if(sentencia.charAt(i)!='/'&&sentencia.charAt(i)!='*')
					sentenciaPreprocesada += sentencia.charAt(i);
		}
		
		System.out.println(sentenciaPreprocesada);
		scanner.close();
	}
}
