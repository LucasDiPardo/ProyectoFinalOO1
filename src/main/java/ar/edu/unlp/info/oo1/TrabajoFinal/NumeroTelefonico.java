package ar.edu.unlp.info.oo1.TrabajoFinal;

public class NumeroTelefonico {
	private String numero;
	private boolean disponible;
	
	
	//constructor
	public NumeroTelefonico(String unNumero) {
		this.numero=unNumero;
		this.disponible=true;
	}
	
	//metodos
	public String getNumero() {
		return this.numero;
	}
	
	public boolean estaDisponible() {
		return this.disponible;
	}
	public void ocuparNumero() {
		this.disponible=false;
	}
}	
