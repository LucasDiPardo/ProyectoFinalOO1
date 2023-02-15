package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;

public class PersonaJuridica extends Persona{
	//variables instancia
	private int cuit;
	private String tipoPJ;
	
	//constructor
	public PersonaJuridica(String unNombre,String unaDireccion,String unNumeroTel, int unCuit, String unTipo) {
		super(unNombre,unaDireccion,unNumeroTel);
		this.cuit=unCuit;
		this.tipoPJ=unTipo;
	}
	
	//metodos
	public double getDescuento() {
		return 0;
	}

}
