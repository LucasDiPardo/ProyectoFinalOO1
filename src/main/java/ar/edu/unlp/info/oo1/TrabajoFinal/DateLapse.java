package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	
	public DateLapse(LocalDate unaFrom, LocalDate unaTo) {
		this.from=unaFrom;
		this.to=unaTo;
	}
	
	//getters
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	//metodos
	
	public boolean includesDate(LocalDateTime fechaYHoraLlamada) {
		return mayorQueFrom(fechaYHoraLlamada.toLocalDate())&&(menorQueTo(fechaYHoraLlamada.toLocalDate()));
	}
	
	private boolean mayorQueFrom(LocalDate unaFecha) {
		return this.from.isBefore(unaFecha);
	}
	
	private boolean menorQueTo(LocalDate unaFecha) {
		return this.to.isAfter(unaFecha);
	}
	
	
	public int sizeInDays() {
		return (int) this.from.until(this.to, ChronoUnit.DAYS);
	}
	
}
