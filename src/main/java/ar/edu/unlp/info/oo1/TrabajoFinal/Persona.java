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
	public abstract double montoLlamadasEnPeriodo(LocalDate unaFechaInicio, LocalDate unaFechaFin);

	
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
	
	/*
	//revisar este metodo si al final se usa y se replica a local e internacional
	public LlamadaInterurbana registrarLlamadaInterurbanaConTarifa(LocalDateTime unaFechaYHora,int unaDuracion, String unRemitente, String unReceptor, int unaDistanciaKms, double unPrecioPorMinuto) {
		LlamadaInterurbana llamadaInt = new LlamadaInterurbana (unaFechaYHora, unaDuracion,unRemitente, unReceptor, unaDistanciaKms,unPrecioPorMinuto);
		this.registroLlamadas.add(llamadaInt);
	
	return llamadaInt;
}
	*/

	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime unaFechaYHora,int unaDuracion, String unRemitente, String unReceptor, Pais unOrigen, Pais unDestino) {
			LlamadaInternacional llamadaInter = new LlamadaInternacional(unaFechaYHora, unaDuracion, unRemitente, unReceptor, unOrigen, unDestino);
			this.registroLlamadas.add(llamadaInter);
		
		return llamadaInter;
	}	
	
	
	
		
	protected List<Llamada> getLlamadasEnPeriodo(LocalDate fInicio, LocalDate fFin){
		return this.registroLlamadas.stream()
				.filter(llamada -> llamada.seEncuentraEnPeriodo(fInicio,fFin))
				.collect((Collectors.toList()));
	}
	
	public Factura facturarLlamada(LocalDate fechaInicio, LocalDate fechaFin) {
		
			double montoTotal= this.getLlamadasEnPeriodo(fechaInicio, fechaFin).stream()
					.mapToDouble(l -> l.calcularCosto(this.getDescuento()))
					.sum();

		
		return new Factura(this, LocalDate.now(), fechaInicio, fechaFin, montoTotal);
	}
	
	//getters
	
	public List<Llamada> getLlamadas(){
		return this.registroLlamadas;
	}
	public String getNombre() {
		return this.nombre;
	}
	
}
