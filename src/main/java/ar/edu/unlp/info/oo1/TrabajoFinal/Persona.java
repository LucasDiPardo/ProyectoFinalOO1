package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Persona {
	//variables intancia
	private String nombre;
	private String direccion;
	private List<Llamada> registroLlamadas;
	private int numeroTelefonico;
	//constructor
	
	public Persona(String unNombre,String unaDireccion,int unNumeroTelefonico) {
		this.nombre=unNombre;
		this.direccion=unaDireccion;
		this.registroLlamadas= new ArrayList<Llamada>();
		this.numeroTelefonico=unNumeroTelefonico;
	}
	
	//metodos
	
	public abstract double getDescuento();
	
	
	
	public void registrarLlamadaLocal(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor) {
		LlamadaLocal llamadaLoc = new LlamadaLocal(unaFecha,unaHoraComienzo, unaDuracion, unRemitente, unReceptor);
		
		this.registroLlamadas.add(llamadaLoc);
	}
	

	public void registrarLlamadaInterurbana(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor, int unaDistanciaKms) {
		LlamadaInterurbana llamadaInt = new LlamadaInterurbana (unaFecha,unaHoraComienzo, unaDuracion,unRemitente, unReceptor, unaDistanciaKms);
	
		this.registroLlamadas.add(llamadaInt);
	}
	

	public void registrarLlamadaInternacional(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor, Pais unOrigen, Pais unDestino) {
		LlamadaInternacional llamadaInter = new LlamadaInternacional(unaFecha, unaHoraComienzo, unaDuracion, unRemitente, unReceptor, unOrigen, unDestino);
		
		this.registroLlamadas.add(llamadaInter);
	}
	
	public Factura facturar() {		
		return null; //hacer
	}
	
		
	private List<Llamada> getLlamadasEnPeriodo(LocalDate fInicio, LocalDate fFin){
		return this.registroLlamadas.stream()
				.filter(llamada -> llamada.seEncuentraEnPeriodo(fInicio,fFin))
				.collect((Collectors.toList()));
	}
	
}
