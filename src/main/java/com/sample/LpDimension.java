package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFormattedTextField;

public class LpDimension {
	
	private JFormattedTextField nombreInterfaz;
	private List<JFormattedTextField> valoresInterfaz = new ArrayList<>();
	private String nombre;
	private List<String> valores;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getValores() {
		return valores;
	}

	public void setValores(List<String> valores) {
		this.valores = valores;
		Collections.sort(this.valores);
	}

	public LpDimension() {
		super();
		valores = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "LpDimension [nombre=" + nombre + ", valores=" + valores + "]";
	}
	
	public String primerElemento(){
		return this.valores.get(0);
	}

	public String ultimoElemento(){
		return this.valores.get(this.valores.size()-1);
	}
	
	public int numeroDeElementos(){
		return this.valores.size();
	}
	public void addValores(String string) {
		if(this.valores == null)
			this.valores = new ArrayList<>();
		this.valores.add(string);
		Collections.sort(this.valores);
	}
	public List<JFormattedTextField> getValoresInterfaz() {
		return valoresInterfaz;
	}
	public void setValoresInterfaz(List<JFormattedTextField> valoresInterfaz) {
		this.valoresInterfaz = valoresInterfaz;
	}
	public JFormattedTextField getNombreInterfaz() {
		return nombreInterfaz;
	}
	public void setNombreInterfaz(JFormattedTextField nombreInterfaz) {
		this.nombreInterfaz = nombreInterfaz;
	}
}
