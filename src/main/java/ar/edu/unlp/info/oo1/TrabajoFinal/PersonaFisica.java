package ar.edu.unlp.info.oo1.TrabajoFinal;

public class PersonaFisica extends Cliente{
	//variables instancia
	private int dni;
	
	//contructor
	public PersonaFisica(String unNombre,String unaDireccion, int unDni) {
		super(unNombre,unaDireccion);
		this.dni=unDni;
	}
	
	
}
