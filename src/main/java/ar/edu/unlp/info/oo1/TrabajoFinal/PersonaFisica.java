package ar.edu.unlp.info.oo1.TrabajoFinal;

public class PersonaFisica extends Persona{
	//variables instancia
	private int dni;
	
	//contructor
	public PersonaFisica(String unNombre,String unaDireccion, int unNumero, int unDni) {
		super(unNombre,unaDireccion,unNumero);
		this.dni=unDni;
	}
	
	//metodos
	public double getDescuento() {
		return 0.10;
	}
}
