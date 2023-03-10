package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Persona {
	//variables intancia
	private String nombre;
	private String direccion;
	private List<Llamada> registroLlamadas;
	private String numeroTelefonico;
	//constructor
	
	public Persona(String unNombre,String unaDireccion,String unNumeroTelefonico) {
		this.nombre=unNombre;
		this.direccion=unaDireccion;
		this.registroLlamadas= new ArrayList<Llamada>();
		this.numeroTelefonico=unNumeroTelefonico;
	}
	
	//metodos
	
	public abstract double getDescuento();

	
	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor) {
			LlamadaLocal llamadaLoc = new LlamadaLocal(unaFechaYHora, unaDuracion, unRemitente, unReceptor);
			this.registroLlamadas.add(llamadaLoc);
			
		return llamadaLoc;
	}
	

	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime unaFechaYHora,int unaDuracion, String unRemitente, String unReceptor, int unaDistanciaKms) {
			LlamadaInterurbana llamadaInt = new LlamadaInterurbana (unaFechaYHora, unaDuracion,unRemitente, unReceptor, unaDistanciaKms);
			this.registroLlamadas.add(llamadaInt);
		
		return llamadaInt;
	}
	

	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime unaFechaYHora,int unaDuracion, String unRemitente, String unReceptor, Pais unOrigen, Pais unDestino) {
			LlamadaInternacional llamadaInter = new LlamadaInternacional(unaFechaYHora, unaDuracion, unRemitente, unReceptor, unOrigen, unDestino);
			this.registroLlamadas.add(llamadaInter);
		
		return llamadaInter;
	}	
	
	
	public double montoLlamadasEnPeriodo(LocalDate unaFechaInicio, LocalDate unaFechaFin) {		
		return this.getLlamadasEnPeriodo(unaFechaInicio, unaFechaFin).stream()
				.mapToDouble(l -> l.calcularCosto(this.getDescuento()))
				.sum();
	}
	
	public List<Llamada> getLlamadasEnPeriodo(LocalDate fInicio, LocalDate fFin){
		return this.registroLlamadas.stream()
				.filter(llamada -> llamada.seEncuentraEnPeriodo(fInicio,fFin))
				.collect((Collectors.toList()));
	}
	
	//getters
	
	public List<Llamada> getLlamadas(){
		return this.registroLlamadas;
	}
	public String getNombre() {
		return this.nombre;
	}
	
}
