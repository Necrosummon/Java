package preprocesador;
/* Ejercicio 6.2 página 167
 * El preprocesador de C elimina los comentarios /* ...... ^/ del código fuente antes de compilar
 *
 * Diseña un programa que lea por teclado una sentencia en C, y elimine los comentarios.
 * 
 * Ejemplo:
 */
 // if (a==3) /* igual a tres */ a++; /* incrementamos a */
 /* 
 * Debería devolver
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
			 * Especificamos que si el carácter actual es '*' y el previo es '/' 
			 * es /* (inicio de comentario), y todo lo que venga a continuación será comentario.
			 */
			if(sentencia.charAt(i)=='*')
				if(i>0) // Evitamos índices que no existen, tipo -1.
					if(sentencia.charAt(i-1)=='/')
						comentario = true; 
			
			/*
			 * Especificamos que si el carácter actual es '/' y el previo es '*' 
			 * es +/ (fin de comentario), y todo lo que venga a continuación será código.
			 */
			if(sentencia.charAt(i)=='/')
				if(i>0)
					if(sentencia.charAt(i-1)=='*')
						comentario = false;
			
			/*
			 * Si no es comentario, pasamos a chequear el caracter, si es diferente a '/' o  '*'
			 * Se meterá en el string preprocesado
			 */
			if(!comentario)
				if(sentencia.charAt(i)!='/'&&sentencia.charAt(i)!='*')
					sentenciaPreprocesada += sentencia.charAt(i);
		}
		
		System.out.println(sentenciaPreprocesada);
		scanner.close();
	}
}
