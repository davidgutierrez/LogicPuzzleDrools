package com.sample;

public class LpPista {
	
	private static boolean estado = true;
	
	private String veces1,veces2,veces3;
	private String valor1,valor2,valor3,valor4,valor5,valor6,valor7,valor8;
	private String valorOp1,valorOp2,valorOp3,valorOp4,valorOp5,valorOp6,valorOp7;
	
	public LpPista(String valorIzq, String valorOperador, String veces1, String valorDer) {
		super();
		this.valor1 = valorIzq;
		this.valorOp1= valorOperador;
		this.veces1 = veces1;
		this.valor2 = valorDer;
	}

	public LpPista( String valor1,  String valorOp1, String veces1, 
					String valor2, 	String valorOp2, String veces2,
					String valor3,  String valorOp3, String veces3, String valor4) {
		super();
		this.valor1 = valor1;
		this.valorOp1 = valorOp1;
		this.veces1 = veces1;
		this.valor2 = valor2;
		this.valorOp2 = valorOp2;
		this.veces2 = veces2;
		this.valor3 = valor3;
		this.valorOp3 = valorOp3;
		this.veces3 = veces3;
		this.valor4 = valor4;
	}

	public LpPista(String valor1, String valorOp1, String valor2, 
			String valorOp2, 
			String valor3, String valorOp3,	String valor4) {
		super();
		this.valor1 = valor1;
		this.valorOp1 = valorOp1;
		this.valor2 = valor2;
		this.valorOp2 = valorOp2;
		this.valor3 = valor3;
		this.valorOp3 = valorOp3;
		this.valor4 = valor4;
	}

	public LpPista(String valor1, String valorOp1, String valor2, String valorOp2,
			       String valor3, String valorOp3, String valor4, String valorOp4,	String valor5) {
		super();
		this.valor1 = valor1;
		this.valorOp1 = valorOp1;
		this.valor2 = valor2;
		this.valorOp2 = valorOp2;
		this.valor3 = valor3;
		this.valorOp3 = valorOp3;
		this.valor4 = valor4;
		this.valorOp4 = valorOp4;
		this.valor5 = valor5;
	}
	public LpPista(String valor1, String valorOp1, String valor2, String valorOp2,
		           String valor3, String valorOp3, String valor4, String valorOp4,
		           String valor5, String valorOp5, String valor6, String valorOp6,
		           String valor7, String valorOp7, String valor8) {
		super();
		this.valor1 = valor1;
		this.valorOp1 = valorOp1;
		this.valor2 = valor2;
		this.valorOp2 = valorOp2;
		this.valor3 = valor3;
		this.valorOp3 = valorOp3;
		this.valor4 = valor4;
		this.valorOp4 = valorOp4;
		this.valor5 = valor5;
		this.valorOp5 = valorOp5;
		this.valor6 = valor6;
		this.valorOp6 = valorOp6;
		this.valor7 = valor7;
		this.valorOp7 = valorOp7;
		this.valor8 = valor8;
	}

	public LpPista() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isEstado() {return estado;}
	public static void setEstado(boolean estado) {		LpPista.estado = estado;	}

	public String getVeces1() {		return veces1;	}
	public void setVeces1(String veces1) {		this.veces1 = veces1;	}

	public String getVeces2() {		return veces2;	}
	public void setVeces2(String veces2) {		this.veces2 = veces2;	}

	public String getVeces3() {		return veces3;	}
	public void setVeces3(String veces3) {		this.veces3 = veces3;	}

	public String getValor1() {return valor1;	}
	public void setValor1(String valor1) {	this.valor1 = valor1;	}

	public String getValor2() {	return valor2;	}
	public void setValor2(String valor2) {	this.valor2 = valor2;	}

	public String getValor3() {	return valor3;	}
	public void setValor3(String valor3) {	this.valor3 = valor3;	}

	public String getValor4() {	return valor4;	}
	public void setValor4(String valor4) {	this.valor4 = valor4;	}

	public String getValorOp1() {	return valorOp1;	}
	public void setValorOp1(String valorOp1) {	this.valorOp1 = valorOp1;	}

	public String getValorOp2() {	return valorOp2;	}
	public void setValorOp2(String valorOp2) {	this.valorOp2 = valorOp2;	}

	public String getValorOp3() {	return valorOp3;	}
	public void setValorOp3(String valorOp3) {	this.valorOp3 = valorOp3;	}

	public String getValor5() {		return valor5;	}
	public void setValor5(String valor5) {	this.valor5 = valor5;	}

	public String getValorOp4() {	return valorOp4;	}
	public void setValorOp4(String valorOp4) {	this.valorOp4 = valorOp4;	}

	
	public String getValor6() {
		return valor6;
	}

	public void setValor6(String valor6) {
		this.valor6 = valor6;
	}

	public String getValor7() {
		return valor7;
	}

	public void setValor7(String valor7) {
		this.valor7 = valor7;
	}

	public String getValor8() {
		return valor8;
	}

	public void setValor8(String valor8) {
		this.valor8 = valor8;
	}

	public String getValorOp5() {
		return valorOp5;
	}

	public void setValorOp5(String valorOp5) {
		this.valorOp5 = valorOp5;
	}

	public String getValorOp6() {
		return valorOp6;
	}

	public void setValorOp6(String valorOp6) {
		this.valorOp6 = valorOp6;
	}

	public String getValorOp7() {
		return valorOp7;
	}

	public void setValorOp7(String valorOp7) {
		this.valorOp7 = valorOp7;
	}

	@Override
	public String toString() {
		return "LpPista [valor1=" + valor1 + ", valor2=" + valor2 + ", valor3=" + valor3 + ", valor4=" + valor4
				+ ", valorOp1=" + valorOp1 + ", valorOp2=" + valorOp2 + ", valorOp3=" + valorOp3 + "]";
	}
	public String enFormato(){
		return "["+valor1+" "+valorOp1+
				(veces1!=null?" "+veces1:"")+
				" "+valor2+
				(valorOp2!=null?" "+valorOp2:"")+
				(valor3!=null?" "+valor3:"")+
				(valorOp3!=null?" "+valorOp3:"")+
				(valor4!=null?" "+valor4:"")+
				(valorOp4!=null?" "+valorOp4:"")+
				(valor5!=null?" "+valor5:"")+
				(valorOp5!=null?" "+valorOp5:"")+
				(valor6!=null?" "+valor6:"")+
				(valorOp6!=null?" "+valorOp6:"")+
				(valor7!=null?" "+valor7:"")+
				(valorOp7!=null?" "+valorOp7:"")+
				(valor8!=null?" "+valor8:"")+
				"]";
	}
	
	public int getVeces1Entero() {
		try {
			return Integer.parseInt(veces1.trim());			
		} catch (Exception e) {
			return 0;
		}
	}

}
