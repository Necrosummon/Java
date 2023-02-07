package calendario;
public class Calendario {
	int año, mes, dia;
	boolean esCorrecto = false;
	
	Calendario(int año, int mes, int dia)
	{	
		if(año<=0)
			System.out.println("El año es erróneo");
		else
			if (mes<1||mes>12)
				System.out.println("El mes es erróneo");
			else
				switch(mes)
				{
					case 2: // Febrero
						if(dia<1||dia>29)
							System.out.println("Día erróneo");
						else if(dia==29)
								if(año%100 == 0 && año%400 == 0) // Año bisiesto
									esCorrecto = true;
								else
									System.out.println("Febrero no es bisiesto en dicho año.");	
						else
							esCorrecto = true;
					break;
					case 4,6,9,11: // Abril, Junio, Septiembre, Noviembre
						if(dia<1||dia>30)
							System.out.println("El día es erróneo");
						else
							esCorrecto = true;
					break;
					default: // Resto de meses con 31 días
						if(dia<1||dia>31)
							System.out.println("El día es erróneo");
						else
							esCorrecto = true;
				}
		
		if(esCorrecto) {
			this.año = año;
			this.mes = mes;
			this.dia = dia;
		}
		else
		{
			System.out.println("No se pudo crear el calendario, introduce una fecha correcta.");
			esCorrecto = false;
		}
	}
	
	void incrementarAño (int cantidad)
	{
		if(cantidad>0)
			this.año += cantidad;
	}
	
	void incrementarMes (int cantidad)
	{
		if(cantidad>0&&cantidad<12)
			this.mes += cantidad;
		else
		{
			this.año += cantidad/12;
			this.mes += cantidad%12;
		}
		
		/* Comprobamos que el día introducido es compatible con el mes al que se va*/
		switch(this.mes)
		{
			case 2: // Febrero
				if(this.dia>29)
					if(this.año%100 == 0 && this.año%400 == 0) // Año bisiesto)
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
					if(this.año%100 == 0 && this.año%400 == 0) {
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
		if(this.año == otraFecha.año && this.mes == otraFecha.mes && this.dia == otraFecha.dia) {
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
		if(this.año>0||this.dia>0||this.dia<=31||this.mes>0||this.mes<=12) // Si es una fecha válida, la muestra
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
			System.out.print(this.año);
		}
		System.out.println();
	}
}
