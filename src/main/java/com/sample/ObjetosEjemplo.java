package com.sample;

import java.util.ArrayList;
import java.util.List;

public class ObjetosEjemplo {


	static LpTablero crearTablero(int numValores) {
		LpTablero lpTablero = new LpTablero(3, 4);
		lpTablero.addDimension(crearDimension("meses",numValores,""));
		lpTablero.addDimension(crearDimension("probes",numValores,"A"));
		lpTablero.addDimension(crearDimension("destino",numValores,"B"));
		return lpTablero;
	}
	
	static LpTablero crearTablero2(List<LpDimension> dimensiones,Integer numDim, Integer numVal) {
		LpTablero lpTablero = new LpTablero(numDim, numVal);
		for(LpDimension d : dimensiones){
			lpTablero.addDimension(d);
		}
		return lpTablero;
	}

	private static LpDimension crearDimension(String nombre,int numValores, String prefijo) {
		LpDimension dimension0 = new LpDimension();
		dimension0.setNombre(nombre);
		for (int i = 0; i < numValores; i++) {
			dimension0.addValores(prefijo+i);
		}
		return dimension0;
	}

	static List<LpPista> ejemplo1() {
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("A1","=",null,"0"));
		pistas.add(new LpPista("1","=","B3","XOR","1","=","A1"));
		pistas.add(new LpPista("B3",">",null,"B0"));
		pistas.add(new LpPista("A2",">",null,"B2"));
		pistas.add(new LpPista("A2","=","B3","XOR","A3","=","B3"));
		return pistas;
	}

	static List<LpPista> ejemplo2() {
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("A3","=",null,"2"));		
		pistas.add(new LpPista("B1",">",null,"A1"));
		pistas.add(new LpPista("B3",">",null,"A0"));
		pistas.add(new LpPista("A3","=",null,"B0"));
		pistas.add(new LpPista("1","<>",null,"A1"));
		return pistas;
	}

	static List<LpPista> ejemplo3() { //47542192704b66babdf11ae9099252b1
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("3","=",null,"B2"));		
		pistas.add(new LpPista("B1",">",null,"B3"));
		pistas.add(new LpPista("A1",">","1","B0"));
		pistas.add(new LpPista("A0",">","1","A1"));
		pistas.add(new LpPista("B3",">",null,"A3"));
		return pistas;
	}

	static List<LpPista> ejemplo4() { //http://www.logic-puzzles.org/game.php?u2=3f12d5114149f27f574ea1ee076b036e
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("A3","<>",null,"B3"));		
		pistas.add(new LpPista("2","=",null,"B2"));
		pistas.add(new LpPista("B3",">","1","A0"));
		pistas.add(new LpPista("B1",">","1","A2"));
		pistas.add(new LpPista("0","=","B0","XOR","0","=","A2"));
		return pistas;
	}

	static List<LpPista> ejemplo5() { //http://www.logic-puzzles.org/game.php?u2=da010860f04a0ed02d18d7fe18bf0614
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("2","=","B2","XOR","2","=","A1"));
		pistas.add(new LpPista("0","=",null,"B3"));		
		pistas.add(new LpPista("A2","=","B0","XOR","A2","=","1"));
		pistas.add(new LpPista("A0","=",null,"3"));
		pistas.add(new LpPista("B2",">","2","A1"));
		return pistas;
	}

	static List<LpPista> ejemplo7() { //http://www.logic-puzzles.org/game.php?u2=da010860f04a0ed02d18d7fe18bf0614
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("B1",">",null,"A3"));
		pistas.add(new LpPista("3","=","A3","XOR","3","=","B3"));
		pistas.add(new LpPista("1","=","A3","XOR","1","=","B3"));
		pistas.add(new LpPista("A2",">","1","B1"));
		pistas.add(new LpPista("B2",">","2","A1"));
		return pistas;
	}

	static List<LpPista> ejemplo8() { 
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("3","<>","A3","<>","B3","<>","A2","<>","A1"));
		return pistas;
	}
	
	static List<LpPista> ejemplo9() { //http://www.logic-puzzles.org/game.php?u2=da010860f04a0ed02d18d7fe18bf0614
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("A1","=",null,"0"));
		pistas.add(new LpPista("1","<>","B3","<>","A3","<>","B4"));
		pistas.add(new LpPista("A0","<>",null,"B3"));
		pistas.add(new LpPista("A3",">","2","A2"));
		pistas.add(new LpPista("A2","=",null,"B4"));
		pistas.add(new LpPista("0","=","A3","XOR","0","=","B2"));
		pistas.add(new LpPista("A3","=","B3","XOR","A3","=","B0"));
		return pistas;
	}

	static List<LpPista> ejemplo10() { //http://www.logic-puzzles.org/game.php?u2=57ff2a2ecfb7e3fec13da77b0e6c0434
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("B1",">","1","A0"));
		pistas.add(new LpPista("A3","=",null,"B0"));
		pistas.add(new LpPista("2","=","B3","AND","A2","=","B0","XOR",
				               "2","=","B0","AND","A2","=","B3"));
				return pistas;
	}

	static List<LpPista> ejemplo11() { //http://www.logic-puzzles.org/game.php?u2=57ff2a2ecfb7e3fec13da77b0e6c0434
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("A2",">","1","A3"));
		pistas.add(new LpPista("B2","=","A3","AND","B3","=","0","XOR",
	               			   "B2","=","0","AND","B3","=","A3"));
		pistas.add(new LpPista("A2","=",null,"B1"));
		pistas.add(new LpPista("A0","=","B2","AND","A2","=","2","XOR",
    			   			   "A0","=","2","AND","A2","=","B2"));
				return pistas;
	}

	static LpTablero crearTableroEjemplo6(int numValores) {
		
		LpTablero lpTablero = new LpTablero(3, numValores);

		LpDimension dimension0 = new LpDimension();
		dimension0.setNombre("manatees");
		dimension0.addValores("1");
		dimension0.addValores("2");
		dimension0.addValores("3");
		dimension0.addValores("4");
		lpTablero.addDimension(dimension0);

		dimension0 = new LpDimension();
		dimension0.setNombre("boats");
		dimension0.addValores("Ethel Street");			
		dimension0.addValores("Gray Avenue");			
		dimension0.addValores("Harkin Drive");			
		dimension0.addValores("Ivy Street");			
		lpTablero.addDimension(dimension0);
		
		dimension0 = new LpDimension();
		dimension0.setNombre("captains");
		dimension0.addValores("Ed Erickson");			
		dimension0.addValores("Gail Garrett");			
		dimension0.addValores("Hal Hamilton");			
		dimension0.addValores("Irma Ingram");			
		lpTablero.addDimension(dimension0);
		
		return lpTablero;
	}

	
	static List<LpPista> ejemplo6() { //http://www.logic-puzzles.org/game.php?u2=da010860f04a0ed02d18d7fe18bf0614
		List<LpPista> pistas = new ArrayList<>();
		pistas.add(new LpPista("Gail Garrett","=",null,"Harkin Drive"));
		pistas.add(new LpPista("Ethel Street","=","2","XOR","Ethel Street","=","Ed Erickson"));		
		pistas.add(new LpPista("Ethel Street","=",null,"Irma Ingram"));
		pistas.add(new LpPista("Gray Avenue",">","1","Hal Hamilton"));
		return pistas;
	}

}
