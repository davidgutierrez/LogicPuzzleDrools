package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class EjecutarReglas {

	private static KieSession kSession = null;
	private List<LpCelda> celdas;
	
	public EjecutarReglas(){
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		kSession = kContainer.newKieSession("ksession-rules");
		celdas = new ArrayList<>();
	}

	public static void main(String[] args) {

		LpTablero lpTablero = ObjetosEjemplo.crearTablero(4);
		List<LpPista> pistas  = 
				//		ObjetosEjemplo.ejemplo1();
				ObjetosEjemplo.ejemplo11();
		EjecutarReglas ejecutarReglas = new EjecutarReglas();
		ejecutarReglas.ejecutar(lpTablero, pistas);

	}


	public void ejecutar(LpTablero lpTablero, List<LpPista> pistas) {
		try {
			// load up the knowledge base
//			KieServices ks = KieServices.Factory.get();
//			KieContainer kContainer = ks.getKieClasspathContainer();
//			kSession = kContainer.newKieSession("ksession-rules");
			// go !
			inicializar(lpTablero, pistas);
			kSession.fireAllRules();
			//			imprimirSession();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void inicializar(LpTablero lpTablero, List<LpPista> pistas) {

		List<LpDimension> dimensiones = lpTablero.getDimensiones();
		kSession.insert(dimensiones.get(0));
		for (int i=0; i<dimensiones.size(); i++){
			LpDimension dimensionValor = dimensiones.get(i);
			String nombreDimensionValor = dimensionValor.getNombre();
			for (String valorComparar : dimensionValor.getValores()) {
				for (int j=i+1; j<dimensiones.size(); j++){			
					LpDimension dimensionVariable = dimensiones.get(j);
					String nombreDimensionVariable = dimensionVariable.getNombre();
					for (String valorVariable : dimensionVariable.getValores()) {
						LpCelda celda = new LpCelda(nombreDimensionValor,valorComparar,nombreDimensionVariable,valorVariable);
						kSession.insert(celda);
						celdas.add(celda);
					}
				}
			}
		}
		//Insertar las pistas
		for (LpPista lpPista : pistas) {
			kSession.insert(lpPista);	
		}
		//Insertar # dimensiones y valores
		kSession.insert(lpTablero);
	}

	public static void imprimirSession() {
		for (Object object : kSession.getObjects()) {
			if(object.getClass().equals(LpCelda.class)){
				LpCelda celda = (LpCelda)object;
				if(celda.isEvaluada())
					System.out.println(celda);
			}
		}
	}

	public List<LpCelda> getCeldas() {
		return celdas;
	}

	public void setCeldas(List<LpCelda> celdas) {
		this.celdas = celdas;
	}

}
