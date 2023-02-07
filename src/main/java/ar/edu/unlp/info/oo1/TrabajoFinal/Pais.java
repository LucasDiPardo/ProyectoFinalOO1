package ar.edu.unlp.info.oo1.TrabajoFinal;

public class Pais {
	private String nombrePais;
	private double precioDiurno;
	private double precioNocturno;
	
	
	//constructor
	public Pais(String unNombre, double unPDiurno, double unPNocturno) {
		this.nombrePais=unNombre;
		this.precioDiurno=unPDiurno;
		this.precioNocturno=unPNocturno;		
	}
	
	
	//getter
	public double getPrecioDiurno() {
		return this.precioDiurno;
	}
	
	public double getPrecioNocturno() {
		return this.precioNocturno;
	}
	
}
