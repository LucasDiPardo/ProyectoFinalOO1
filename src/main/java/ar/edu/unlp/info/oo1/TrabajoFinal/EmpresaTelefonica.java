package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpresaTelefonica {
	private List<Persona> clientes;
	private List<String> numerosTelefonicos; //ver esto
	
	//constructor	
	public EmpresaTelefonica() {
		this.clientes= new ArrayList<Persona>();
		this.numerosTelefonicos= new ArrayList<String>();
	}
	
	
	//metodos
	
	public void agregarNumeroTelefonico(String unNumero) {
		this.numerosTelefonicos.add(unNumero);
	}
	
	public PersonaJuridica registrarPersonaJuridica(String nombre, String direccion, int cuit, String tipo) {
			String numero= this.asignarNumero();
			PersonaJuridica per1= new PersonaJuridica(nombre, direccion,numero, cuit, tipo);
			this.clientes.add(per1);
		
		return per1;
	}
	
	public PersonaFisica registrarPersonaFisica(String nombre, String direccion, int dni) {
			String numero= this.asignarNumero();
			PersonaFisica per1= new PersonaFisica(nombre, direccion,numero, dni);
			this.clientes.add(per1);
		
		return per1;
	}
	
	private String asignarNumero() {		
			String unNumero=numerosTelefonicos.get(0); 
			numerosTelefonicos.remove(unNumero); 
			
		return unNumero; 
	}

	public Persona buscarClienteEmisorPorNumero(String unNumero) { //esta publico por el test - busca por numero de emisor donde suponemos que es unico
		return this.clientes.stream()
				.filter(c -> c.getNumeroTelefonico().equals(unNumero))
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
	
	
	//getters
	public List<Persona> getClientes(){
		return  this.clientes;
	}
	
	
	public List<String> getNumerosTelefonicos(){
		return this.numerosTelefonicos;
	}
}
