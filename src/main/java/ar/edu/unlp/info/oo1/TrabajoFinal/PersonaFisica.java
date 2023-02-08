package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;

public class PersonaFisica extends Persona{
	//variables instancia
	private int dni;
	
	//contructor
	public PersonaFisica(String unNombre,String unaDireccion, String unNumero, int unDni) {
		super(unNombre,unaDireccion,unNumero);
		this.dni=unDni;
	}
	
	//metodos
	public double getDescuento() {
		return 0.10;
	}
	
	public double montoLlamadasEnPeriodo(LocalDate unaFechaInicio, LocalDate unaFechaFin) {		
		return this.getLlamadasEnPeriodo(unaFechaInicio, unaFechaFin).stream()
				.mapToDouble(l -> l.calcularCosto(getDescuento()))
				.sum();
	}
}
