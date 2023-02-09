package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	//variables instancia
	private Pais paisOrigen;
	private Pais paisDestino;
	
	//constructor
	public LlamadaInternacional(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor, Pais unOrigen, Pais unDestino) {
		super(unaFechaYHora,unaDuracion, unRemitente,unReceptor);
		this.paisOrigen=unOrigen;
		this.paisDestino=unDestino;
		setPrecioPorMinuto(getPrecioPorMinutoSegunPaisYHorario());
	}
	public LlamadaInternacional(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor, Pais unOrigen, Pais unDestino, double unPrecioPorMinuto) {
		super(unaFechaYHora,unaDuracion, unRemitente,unReceptor);
		this.paisOrigen=unOrigen;
		this.paisDestino=unDestino;
		setPrecioPorMinuto(unPrecioPorMinuto);
	}
	
	//metodos
	public double calcularCosto(double unDescuento) { //depende que persona llame se pasa por parametro 0 o 10
		
		double totalSinDescuento=this.getDuracion()*getPrecioPorMinuto();
		
		return totalSinDescuento - descuento(totalSinDescuento,unDescuento);
		
	}
	
	private double getPrecioPorMinutoSegunPaisYHorario() {
		
		double precioPorMinuto=0;
		
		if (esDiurno()) {		
			precioPorMinuto= this.paisDestino.getPrecioDiurno();
		}else {
			precioPorMinuto =this.paisDestino.getPrecioNocturno();
		}
		
		return precioPorMinuto;
	}
}
