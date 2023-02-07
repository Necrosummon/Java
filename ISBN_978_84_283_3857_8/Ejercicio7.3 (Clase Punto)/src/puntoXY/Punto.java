package puntoXY;

public class Punto {
	double x,y;
	
	Punto(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	void desplaza(double dx)
	{
		this.x += dx;
	}
	
	void desplaza(double dx, double dy)
	{
		this.x += dx;
		this.y += dy;
	}
	
	double distanciaEuclidea (Punto otro)
	{
		return Math.sqrt(Math.pow(this.x-otro.x, 2) + Math.pow(this.y-otro.y, 2));
	}
	
	void muestra()
	{
		System.out.println("\nEje X: "+this.x+" Eje Y:"+this.y);
	}
}
