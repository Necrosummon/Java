package calendario;
public class Calendario {
	int a�o, mes, dia;
	boolean esCorrecto = false;
	
	Calendario(int a�o, int mes, int dia)
	{	
		if(a�o<=0)
			System.out.println("El a�o es err�neo");
		else
			if (mes<1||mes>12)
				System.out.println("El mes es err�neo");
			else
				switch(mes)
				{
					case 2: // Febrero
						if(dia<1||dia>29)
							System.out.println("D�a err�neo");
						else if(dia==29)
								if(a�o%100 == 0 && a�o%400 == 0) // A�o bisiesto
									esCorrecto = true;
								else
									System.out.println("Febrero no es bisiesto en dicho a�o.");	
						else
							esCorrecto = true;
					break;
					case 4,6,9,11: // Abril, Junio, Septiembre, Noviembre
						if(dia<1||dia>30)
							System.out.println("El d�a es err�neo");
						else
							esCorrecto = true;
					break;
					default: // Resto de meses con 31 d�as
						if(dia<1||dia>31)
							System.out.println("El d�a es err�neo");
						else
							esCorrecto = true;
				}
		
		if(esCorrecto) {
			this.a�o = a�o;
			this.mes = mes;
			this.dia = dia;
		}
		else
		{
			System.out.println("No se pudo crear el calendario, introduce una fecha correcta.");
			esCorrecto = false;
		}
	}
	
	void incrementarA�o (int cantidad)
	{
		if(cantidad>0)
			this.a�o += cantidad;
	}
	
	void incrementarMes (int cantidad)
	{
		if(cantidad>0&&cantidad<12)
			this.mes += cantidad;
		else
		{
			this.a�o += cantidad/12;
			this.mes += cantidad%12;
		}
		
		/* Comprobamos que el d�a introducido es compatible con el mes al que se va*/
		switch(this.mes)
		{
			case 2: // Febrero
				if(this.dia>29)
					if(this.a�o%100 == 0 && this.a�o%400 == 0) // A�o bisiesto)
						this.dia = 29;
					else
						this.dia = 28;
			break;
			case 4,6,9,11: // Abril, Junio, Septiembre, Noviembre
				if(this.dia>30)
					this.dia = 30;
			break;
			
		}
	}
	
	void incrementarDia (int cantidad)
	{
		do {
			switch(this.mes)
			{
				case 2: // Febrero
					if(this.a�o%100 == 0 && this.a�o%400 == 0) {
						if(this.dia==29) {
							this.dia=0;
							this.mes++;
						}
					}else {
						if(this.dia==28) {
							this.dia=0;
							this.mes++;
						}
					}
					break;
				case 4,6,9,11: // Abril,Junio,Septiembre y Noviembre
					if(this.dia==30){
						this.dia=0;
						this.mes++;
					}
					break;
				default:
					if(this.dia==31){
						this.dia=0;
						this.mes++;
					}
					break;
			}
			this.dia++;
			cantidad--;
		}while(cantidad>0);
	}
	
	boolean iguales (Calendario otraFecha)
	{
		if(this.a�o == otraFecha.a�o && this.mes == otraFecha.mes && this.dia == otraFecha.dia) {
			System.out.println("\nLas fechas coinciden");
			return true;
		}
		else {
			System.out.println("\nLas fechas no coinciden");
			return false;
		}
	}
	
	void mostrar ()
	{
		System.out.println();
		if(this.a�o>0||this.dia>0||this.dia<=31||this.mes>0||this.mes<=12) // Si es una fecha v�lida, la muestra
		{
			System.out.print("Fecha del calendario: ");
			if(this.dia < 10)
				System.out.print("0"+this.dia);
			else
				System.out.print(this.dia);
			
			System.out.print("/");
			
			if(this.mes < 10)
				System.out.print("0"+this.mes);
			else
				System.out.print(this.mes);
			
			System.out.print("/");
			System.out.print(this.a�o);
		}
		System.out.println();
	}
}
