package pasoFronterizo;

public class Persona {
	String nombre;
	String dni;
	
	Persona(String nombre, String dni)
	{
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public boolean esDNIValido(String dni) /* Comprueba el DNI si es correcto */
	{
		int caracteresValidos = 0;
		
		for(int i=0;i<dni.length();i++)
		{
			if(dni.length()>9)
				break;
		
			if(i<=dni.length()-1 && Character.isDigit(dni.charAt(i)))
				caracteresValidos++;

			if(i==dni.length()-1 && Character.isLetter(dni.charAt(i)))
				caracteresValidos++;
		}
		
		if(caracteresValidos==dni.length())
			return true;
		else
			return false;
	}
}
