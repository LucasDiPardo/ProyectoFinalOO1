package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpresaTelefonica {
	private List<Persona> clientes;
	private List<Integer> numerosTelefonicos; //ver esto
	
	//constructor	
	public EmpresaTelefonica() {
		this.clientes= new ArrayList<Persona>();
		this.numerosTelefonicos= new ArrayList<Integer>();
	}
	
	
	//metodos
	
	public void agregarNumeroTelefonico(int unNumero) {
		this.numerosTelefonicos.add(unNumero);
	}
	
	/*
	public void agregarCliente(Persona unCliente) {
		this.clientes.add(unCliente);
	}*/
	
	public void registrarPersonaJuridica(String nombre, String direccion, int cuit, String tipo) {
		int numero= this.asignarNumero();
		PersonaJuridica per1= new PersonaJuridica(nombre, direccion,numero, cuit, tipo);
		this.clientes.add(per1);
	}
	
	public void registrarPersonaFisica(String nombre, String direccion, int dni) {
		int numero= this.asignarNumero();
		PersonaFisica per1= new PersonaFisica(nombre, direccion,numero, dni);
		this.clientes.add(per1);
	}
	
	private int asignarNumero() {
		
		int unNumero=numerosTelefonicos.get(0); //recupero el primer numero y me lo guardo
		numerosTelefonicos.remove(0); //lo elimino de la lista
	
		return unNumero; //retorno
	}
	
	//getters
	public List<Persona> getClientes(){
		return  this.clientes;
	}
	public List<Integer> getNumerosTelefonicos(){
		return this.numerosTelefonicos;
	}
}
