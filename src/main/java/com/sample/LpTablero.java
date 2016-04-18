package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LpTablero {
	
	private int dimension;
	private int valores;
	private List<LpDimension> lstDimension;
	private boolean termine;
	
	public LpTablero (Integer a, Integer b){
		this.dimension= a; 
		this.valores=b;
		this.termine = false;
	}
	public static String leer(String celda) {
		String fila = "";
			try {
		        System.out.println( "Indique "+celda );
		    	@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
		    	fila = scanner.nextLine();  			    		
			} catch (Exception e) {
				System.err.println("El valor ingresado no es numerico");								
			}
		return fila;
	}
	
	public int getDimension() { return dimension;	}
	public void setDimension(int dimension) {	this.dimension = dimension;	}

	public int getValores() {
		return valores;
	}
	public void setValores(int valores) {
		this.valores = valores;
	}

	public List<LpDimension> getDimensiones() {	return lstDimension;	}
	public void setDimensiones(List<LpDimension> dimensiones) {	lstDimension = dimensiones;	}

	public LpDimension getDimension0() { return lstDimension.get(0);	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}


	public void addDimension(LpDimension dimension0) {
		if(this.lstDimension == null)
			this.lstDimension = new ArrayList<>();
		this.lstDimension.add(dimension0);
	}
	
	

}
