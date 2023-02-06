package ar.edu.unlp.info.oo1.TrabajoFinal;

public class PersonaJuridica extends Cliente{
	//variables instancia
	private int cuit;
	private String tipoPJ;
	
	//constructor
	public PersonaJuridica(String unNombre,String unaDireccion, int unCuit, String unTipo) {
		super(unNombre,unaDireccion);
		this.cuit=unCuit;
		this.tipoPJ=unTipo;
	}
}
