package com.sample;

public class LpCelda {
	
	public static final String SIN_EVALUAR = "SinEvaluar";
	public static final String VERDADERO = "Verdadero";
	public static final String FALSO = "Falso";
	
	private String estado;	
	private String nombreDimensionValor,valorComparar,nombreDimensionVariable,valorVariable;
	

	public LpCelda(String nombreDimensionValor, String valorComparar,  String nombreDimensionVariable,
			String valorVariable) {
		super();
		this.estado=SIN_EVALUAR;
		this.nombreDimensionValor = nombreDimensionValor;
		this.valorComparar = valorComparar;
		this.nombreDimensionVariable = nombreDimensionVariable;
		this.valorVariable = valorVariable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValorComparar() {
		return valorComparar;
	}

	public void setValorComparar(String valorComparar) {
		this.valorComparar = valorComparar;
	}

	public String getNombreDimensionValor() {
		return nombreDimensionValor;
	}

	public void setNombreDimensionValor(String nombreDimensionValor) {
		this.nombreDimensionValor = nombreDimensionValor;
	}

	public String getNombreDimensionVariable() {
		return nombreDimensionVariable;
	}

	public void setNombreDimensionVariable(String nombreDimensionVariable) {
		this.nombreDimensionVariable = nombreDimensionVariable;
	}

	public String getValorVariable() {
		return valorVariable;
	}

	public void setValorVariable(String valorVariable) {
		this.valorVariable = valorVariable;
	}

	
	@Override
	public String toString() {
		return "LpCelda [estado=" + estado + ", nombreDimensionValor="
				+ nombreDimensionValor +", valorComparar=" + valorComparar +  ", nombreDimensionVariable=" + nombreDimensionVariable + ", valorVariable="
				+ valorVariable + "]";
	}

	public boolean esMayor(LpCelda celda) {
		return getValorEntero()>celda.getValorEntero();
	}

	public boolean esMenor(LpCelda celda) {
		return getValorEntero()<celda.getValorEntero();
	}

	public int getValorEntero() {
		try {
			return Integer.parseInt(valorComparar.trim());			
		} catch (Exception e) {
			return Integer.MAX_VALUE;
		}
	}

	public boolean isEvaluada() {
		
		return !estado.equals(LpCelda.SIN_EVALUAR);
	}

	public String enFormato(){
		return "["+valorComparar+","+valorVariable+"] => "+estado;
	}
	

}
