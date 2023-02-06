package ar.edu.unlp.info.oo1.TrabajoFinal;

public abstract class Cliente {
	//variables intancia
	private String nombre;
	private String direccion;
	
	//constructor
	
	public Cliente(String unNombre,String unaDireccion) {
		this.nombre=unNombre;
		this.direccion=unaDireccion;
	}

	
}
