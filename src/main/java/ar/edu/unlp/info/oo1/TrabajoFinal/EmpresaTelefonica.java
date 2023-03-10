package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpresaTelefonica {
	private List<Persona> clientes;
	private List<NumeroTelefonico> numerosTelefonicos;
	
	//constructor	
	public EmpresaTelefonica() {
		this.clientes= new ArrayList<Persona>();
		this.numerosTelefonicos= new ArrayList<NumeroTelefonico>();
	}
	
	
	//metodos
	
	public void agregarNumeroTelefonico(String unNumero) {
		this.numerosTelefonicos.add(new NumeroTelefonico(unNumero));
	}
	
	public PersonaFisica registrarPersonaFisica(String nombre, String direccion, int dni) {
		String numero= this.asignarNumero();
		PersonaFisica per1= new PersonaFisica(nombre, direccion,numero, dni);
		this.clientes.add(per1);
		
		return per1;
	}
	
	public PersonaJuridica registrarPersonaJuridica(String nombre, String direccion, int cuit, String tipo) {
			String numero= this.asignarNumero();
			PersonaJuridica per1= new PersonaJuridica(nombre, direccion,numero, cuit, tipo);
			this.clientes.add(per1);
		
		return per1;
	}	
	
	private String asignarNumero() {
		
			NumeroTelefonico unNumero= numerosTelefonicos.stream()
					.filter(n -> n.estaDisponible())
					.findFirst()
					.orElse(null);
			
			unNumero.ocuparNumero();
			
		return unNumero.getNumero();
	}

	public Persona buscarClienteEmisorPorNumero(String unNumero) {
		return this.clientes.stream()
				.filter(c -> c.getNumeroTelefonico()==(unNumero))
				.findFirst()
				.orElse(null);
	}
	
	
	public LlamadaLocal registrarLlamadaLocal( LocalDateTime unaFechaYHora, int duracion, String  unRemitente, String  unReceptor) {
			Persona persona =  this.buscarClienteEmisorPorNumero(unRemitente);
			LlamadaLocal llamadaLocal = persona.registrarLlamadaLocal(unaFechaYHora,duracion,unRemitente,unReceptor);
		return llamadaLocal;
	}
	
	
	public LlamadaInterurbana registrarLlamadaInterurbana(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor, int unaDistanciaKms) {
			Persona persona= this.buscarClienteEmisorPorNumero(unRemitente);
			LlamadaInterurbana llamadainterurbana = persona.registrarLlamadaInterurbana(unaFechaYHora, unaDuracion, unRemitente, unReceptor, unaDistanciaKms);
		return llamadainterurbana;
	}
	
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor, Pais unOrigen, Pais unDestino) {
			Persona persona = this.buscarClienteEmisorPorNumero(unRemitente);
			LlamadaInternacional llamadaInternacional = persona.registrarLlamadaInternacional(unaFechaYHora, unaDuracion, unRemitente, unReceptor, unOrigen, unDestino);
		return llamadaInternacional;
	}
	
	
	public Factura facturarCliente(String unNumero, LocalDate inicioPeriodo, LocalDate finPeriodo) {
		Persona cliente= this.buscarClienteEmisorPorNumero(unNumero);
		
		return new Factura(cliente,inicioPeriodo,finPeriodo);
	}
	
	//getters
	public List<Persona> getClientes(){
		return  this.clientes;
	}
	
	
	public List<NumeroTelefonico> getNumerosTelefonicos(){
		return this.numerosTelefonicos;
	}
}
