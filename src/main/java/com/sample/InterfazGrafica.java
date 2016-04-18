package com.sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class InterfazGrafica implements  ActionListener {
	// Definicion del frame
	private static JFrame frame;
	final DefaultComboBoxModel<Item> listaTamanios;
	
	private List<LpDimension> dimensiones;
	final Vector<Item> valoresDominio;
	
    DefaultComboBoxModel<Item> cantidades;
	final DefaultComboBoxModel<Item> operadores;
    List<LpPista> pistas;
    String ptsStr = "";
    LpPista pista;
    Integer numDominios, numValores;

    JPanel tamanioGUI, tamanioPanel, nomDomPanel, infoDomPanel, buttonPanel, confPuzzleGUI, resultadoGUI;
    JLabel tamanioLabel, valLabel;
    JButton crearButton, initButton, borrarButton, orButton, agregarButton, resolverButton, limpiarButton;
	JComboBox<Item> comboBox1, comboBoxOp, comboBoxCant, comboBox2;
	JTextArea textArea;
	
	private List<LpCelda> listaCeldas;
	
	private EjecutarReglas ejecutarReglas;
	
	public InterfazGrafica(){
		frame = new JFrame("[=] Configuracion del Puzzle! [=]");
		valoresDominio = new Vector<Item>();
		//Valores para la lista de seleccion del tamaño
		Vector<Item> vector = new Vector<Item>();
		Item tam1 = new Item("3x4", "3x4");
		Item tam2 = new Item("3x5", "3x5");
		vector.add(tam1);
		vector.add(tam2);
		listaTamanios = new DefaultComboBoxModel<Item>(vector);
		final String opLabels[] = {"", ">", "=", "<>"};
		Vector<Item> vector2 = new Vector<Item>();
	    for(int i=0; i<opLabels.length; i++){
	    	vector2.add(new Item(String.valueOf(i), opLabels[i]));
		}
		operadores = new DefaultComboBoxModel<Item>(vector2);
		pistas = new ArrayList<>();
		ejecutarReglas = new EjecutarReglas();
	}
	
    public JPanel selectTipo(){

        // JPanel general.
        tamanioGUI = new JPanel();
        tamanioGUI.setLayout(null);

        // Panel para los elementos de entrada
        tamanioPanel = crearPanel(0, 0, 250, 80);
        tamanioGUI.add(tamanioPanel);
        
        //creacion de lista de valores
        //titulo
        tamanioLabel = crearLabel("Tamaño: ", 10, 50, 80, 30, Color.black);
        tamanioPanel.add(tamanioLabel);
        //lista de valores
        comboBox1 = crearComboBox(listaTamanios, 100, 50, 100, 25);
        tamanioPanel.add(comboBox1);
        
        // Panel para los botones
        buttonPanel = crearPanel(10, 80, 260, 70);
        tamanioGUI.add(buttonPanel);

        initButton = crearBoton("Iniciar", 0, 40, 250, 30, true);
        buttonPanel.add(initButton);
        
        tamanioGUI.setOpaque(true);
        return tamanioGUI;
    }
    
    public JPanel cargarTablaResultados(){
    	// JPanel general.
        resultadoGUI = new JPanel();
        resultadoGUI.setLayout(null);

        // Panel para los elementos de entrada
        JPanel tablaPanel = crearPanel(0, 0, 780, 750);
        resultadoGUI.add(tablaPanel);
        
        //Tabla
        JTable table = new JTable(new TablaResultados());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setLocation(30,300);
        scrollPane.setSize(750, 250);
        tablaPanel.add(scrollPane);
        
        return  resultadoGUI;
    }

    public void actionPerformed(ActionEvent e) {
    	System.out.println("actionevent ...");
    	if(e.getSource() == initButton){
    		Vector<Item> item = new Vector<Item>();
    		Item itemSeleccionado = (Item) comboBox1.getSelectedItem();
    		numDominios = Integer.parseInt(itemSeleccionado.getDescription().split("x")[0]);
    		numValores = Integer.parseInt(itemSeleccionado.getDescription().split("x")[1]);
    		for(int i=0; i<numValores; i++){
    			if(i==0)
    				item.add(new Item(String.valueOf(i), ""));
    			else
    				item.add(new Item(String.valueOf(i), String.valueOf(i)));
    		}
    	    cantidades = new DefaultComboBoxModel<Item>(item);
    		frame.setContentPane(crearPanelDeConf(numDominios, numValores));
    		confPuzzleGUI.updateUI();
    	} 
//    	else if(e.getSource() == resolverButton){
//    		frame.setContentPane(cargarTablaResultados());
//    		resultadoGUI.updateUI();
//    	} 
    	else if(e.getSource() == limpiarButton){
            dimensiones = new ArrayList<>();
            crearButton.setEnabled(true);
        	comboBox1.setEnabled(false);
            comboBoxOp.setEnabled(false);
            comboBoxCant.setEnabled(false);
            comboBox2.setEnabled(false);
            borrarButton.setEnabled(false);
            orButton.setEnabled(false);
            agregarButton.setEnabled(false);
            resolverButton.setEnabled(false);
            
        } else if(e.getSource() == crearButton){
        	String valor = dimensiones.get(0).getNombre();
        	System.out.println(valor);
        	int i = 0;
        	List<LpDimension> dimsPrima = new ArrayList<>();
        	for(LpDimension dim : dimensiones){
        		LpDimension dimPrima = new LpDimension();
        		dim.getNombreInterfaz().setEditable(false);
        		dimPrima.setNombreInterfaz(dim.getNombreInterfaz());
        		dim.setNombre(dim.getNombreInterfaz().getText());
        		dimPrima.setNombre(dim.getNombre());
        		int j=0;
        		List<String> valsPrima = new ArrayList<>();
        		for(JFormattedTextField vxd : dim.getValoresInterfaz()){
        			vxd.setEditable(false);
        			if(i==0){
            			valoresDominio.addElement(new Item(String.valueOf(i)+String.valueOf(j), String.valueOf(j)));
            			valsPrima.add(String.valueOf(j));
            		}else{
            			valoresDominio.addElement(new Item(String.valueOf(i)+String.valueOf(j), vxd.getText()));
            			valsPrima.add(vxd.getText());
            		}
        			j++;
        		}
        		dimPrima.setValores(valsPrima);
        		dimsPrima.add(dimPrima);
        		i++;
        	}
        	dimensiones = dimsPrima;
        	crearButton.setEnabled(false);
        	comboBox1.setEnabled(true);
        	comboBox1.updateUI();
            comboBoxOp.setEnabled(true);
            comboBoxCant.setEnabled(true);
            comboBox2.setEnabled(true);
            comboBox2.updateUI();
            borrarButton.setEnabled(true);
            orButton.setEnabled(true);
            agregarButton.setEnabled(true);
            resolverButton.setEnabled(true);
        } else if(e.getSource() == agregarButton || e.getSource() == orButton  ){
        	Item itCmBx1 = (Item) comboBox1.getSelectedItem();
        	Item itCmBxOp = (Item) comboBoxOp.getSelectedItem();
        	Item itCmBxCant = (Item) comboBoxCant.getSelectedItem();
        	Item itCmBx2 = (Item) comboBox2.getSelectedItem();
        	
        	if(e.getSource() == orButton){
        		pista = new LpPista();
        		pista.setValor1(itCmBx1.getDescription());
        		pista.setValorOp1(itCmBxOp.getDescription());
        		pista.setValor2(itCmBx2.getDescription());
        		pista.setValorOp2("XOR");
        		ptsStr += itCmBx1.getDescription()+pista.getValorOp1()+itCmBx2.getDescription()+" XOR ";
        	} else if(e.getSource() == borrarButton){
//        		pista = new LpPista(itCmBx1.getDescription(),itCmBxOp.getDescription(),itCmBxCant.getDescription(),itCmBxCant+itCmBx2.getDescription());
//        		pista.setValorOp2("and");
//        		ptsStr += pista.getValor1()+pista.getValorOp1()+pista.getValor2()+" AND ";
        	} else{
        		if(pista != null){
            		pista.setValor3(itCmBx1.getDescription());
            		pista.setValorOp3(itCmBxOp.getDescription());
        			pista.setValor4(itCmBxCant+itCmBx2.getDescription());
        			ptsStr += itCmBx1.getDescription()+pista.getValorOp3()+itCmBx2.getDescription()+"\n";
        			pistas.add(pista);
        			pista = null;
        		}else{
        			pista = new LpPista(itCmBx1.getDescription(), itCmBxOp.getDescription(),itCmBxCant.getDescription(),itCmBx2.getDescription());
                	ptsStr += itCmBx1.getDescription()+pista.getValorOp1()+pista.getVeces1()+itCmBx2.getDescription()+"\n";
                	pistas.add(pista);
                	pista = null;
        		}
        	}
    		textArea.setText(ptsStr);
        	textArea.updateUI();
        	comboBox1.setSelectedItem(null);
        	comboBoxOp.setSelectedItem(null);
        	comboBoxCant.setSelectedItem("");
        	comboBox2.setSelectedItem(null);
        } else if(e.getSource() == borrarButton){
        	pistas.clear();
        	ptsStr="";
        	textArea.setText("");
        	textArea.updateUI();
        } else if(e.getSource() == resolverButton){
        	LpTablero lpTablero = ObjetosEjemplo.crearTablero2(dimensiones,numDominios,numValores);
    		ejecutarReglas.ejecutar(lpTablero, pistas);
    		ptsStr += "\n";
    		ptsStr += "------------------- RESULTADO ----------------";
    		ptsStr += "\n";
    		for(LpCelda c : ejecutarReglas.getCeldas()){
    			if(c.getEstado().equals(LpCelda.VERDADERO)){
    				ptsStr += c.getNombreDimensionValor() + " - " + c.getValorComparar() + " = " + c.getNombreDimensionVariable() + " - " + c.getValorVariable() + "\n"; 
    			}
    		}
    		textArea.setText(ptsStr);
        	textArea.updateUI();
        }
    }

	private JPanel crearPanelDeConf(Integer numDominios, Integer numValores) {
    	
    	//Configuracion dinamica de los dominios
    	Integer anchoPaneles = 800;
    	
    	// JPanel general.
        confPuzzleGUI = new JPanel();
        confPuzzleGUI.setLayout(null);
        
        // Panel que contiene el titulo de los dominios
        nomDomPanel = crearPanel(10, 30, anchoPaneles, 30);
        confPuzzleGUI.add(nomDomPanel);
        
        // Panel con los valores por dominio.
        infoDomPanel = crearPanel(5, 80, anchoPaneles, (30*numValores+10));
        confPuzzleGUI.add(infoDomPanel);
        
        Integer espEntreDom = Integer.divideUnsigned(anchoPaneles, numDominios);
        Integer espEntreVal = Integer.divideUnsigned(anchoPaneles, numDominios*2);
        
        dimensiones = new ArrayList<>(numDominios);
        
        for(int i=0; i<numDominios; i++){
        	JLabel titDominio = crearLabel("Dominio " + (i + 1), espEntreDom*i, 0, espEntreDom, 30, Color.red);
            nomDomPanel.add(titDominio);
            
            //Creacion del dominio
            LpDimension dim = new LpDimension();
            
            // Nombre del dominio
            JLabel nomLabel = crearLabel("Nombre: ", espEntreVal*(i*2), 5, espEntreVal, 10, Color.black);
            infoDomPanel.add(nomLabel);
            JFormattedTextField nombreDominio = crearInputText(espEntreVal*(i*2)+espEntreVal, 0, espEntreVal, 20);
            dim.setNombreInterfaz(nombreDominio);
            dim.setNombre(nombreDominio.getText());
            infoDomPanel.add(dim.getNombreInterfaz());
            
            for(int j=0; j<numValores; j++){
            	valLabel = crearLabel("d"+(i + 1)+"v"+(j)+":", espEntreVal*(i*2), 5*(j+1)+5, espEntreVal, 30*(j+1)+10, Color.black);
                infoDomPanel.add(valLabel);
                JFormattedTextField valorDominio = crearInputText(espEntreVal*(i*2)+espEntreVal, 20*(j+1), espEntreVal, 20);
                dim.getValoresInterfaz().add(j,valorDominio);
                dim.getValores().add(j,valorDominio.getText());
                infoDomPanel.add(dim.getValoresInterfaz().get(j));
            }
            dimensiones.add(dim);
        }

        // Panel para los botones de creacion del puzzle.
        buttonPanel = crearPanel(20, 220, 320, 35);
        confPuzzleGUI.add(buttonPanel);

        crearButton = crearBoton("Crear Puzzle", 0, 0, 150, 30, true);
        buttonPanel.add(crearButton);
        
        limpiarButton = crearBoton("Limpiar", 160, 0, 150, 30, true);
        buttonPanel.add(limpiarButton);
        
        confPuzzleGUI.setOpaque(true);
        confPuzzleGUI.setSize(anchoPaneles, 250);
        TitledBorder titulo = BorderFactory.createTitledBorder("Configuracion dominios puzzle");
        confPuzzleGUI.setBorder(titulo);
        
        //panel para la creacion de pistas
        JPanel pistasPnl = crearPanel(10, 280, 780, 220);
        TitledBorder tituloPistas = BorderFactory.createTitledBorder("Agregar pista");
        pistasPnl.setBorder(tituloPistas);
        
        //creacion de lista de valores
        comboBox1 = new JComboBox<Item>(valoresDominio);
        comboBox1.setLocation(10, 20);
        comboBox1.setSize(100, 25);
        comboBox1.setEnabled(false);
        comboBox1.setMaximumRowCount(5);
        pistasPnl.add(comboBox1);

        comboBoxOp = new JComboBox<Item>(operadores);
        comboBoxOp.setLocation(120, 20);
        comboBoxOp.setSize(100, 25);
        comboBoxOp.setEnabled(false);
        comboBoxOp.setMaximumRowCount(5);
        pistasPnl.add(comboBoxOp);
        
        comboBoxCant = new JComboBox<Item>(cantidades);
        comboBoxCant.setLocation(230, 20);
        comboBoxCant.setSize(100, 25);
        comboBoxCant.setEnabled(false);
        comboBoxCant.setMaximumRowCount(5);
        pistasPnl.add(comboBoxCant);
        
        comboBox2 = new JComboBox<Item>(valoresDominio);
        comboBox2.setLocation(340, 20);
        comboBox2.setSize(100, 25);
        comboBox2.setEnabled(false);
        comboBox2.setMaximumRowCount(5);
        pistasPnl.add(comboBox2);
        
        borrarButton = crearBoton("Borrar", 450, 20, 100, 25, false);
        pistasPnl.add(borrarButton);
        
        orButton = crearBoton("OR", 560, 20, 100, 25, false);
        pistasPnl.add(orButton);
        
        agregarButton = crearBoton("Agregar", 670, 20, 100, 25, false);
        pistasPnl.add(agregarButton);
        
        //Texto para listar pistas
        textArea = new JTextArea(7, 50);
        textArea.setLocation(15, 60);
        textArea.setSize(750, 150);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEtchedBorder());
        
        pistasPnl.add(textArea);
        
        confPuzzleGUI.add(pistasPnl);
        
        // Panel para el boton de resolver.
        JPanel resolverPanel = crearPanel(20, 510, 200, 35);
        confPuzzleGUI.add(resolverPanel);

        resolverButton = crearBoton("Resolver", 0, 0, 150, 30, false);
        resolverPanel.add(resolverButton);
        
        //panel para la tabla de resultados
        resolverPanel.add(cargarTablaResultados());
        
        confPuzzleGUI.add(resolverPanel);
        
        return confPuzzleGUI;
	}
    
	private static void createAndShowGUI() {
        InterfazGrafica demo = new InterfazGrafica();
        frame.setContentPane(demo.selectTipo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(870, 600);
        frame.setVisible(true);
    }
	
	private JPanel crearPanel(int posicionX, int posicionY, int tamanioX, int tamanioY){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setLocation(posicionX, posicionY);
		panel.setSize(tamanioX, tamanioY);
		return panel;
	}
	
	private JLabel crearLabel(String texto, int posicionX, int posicionY, int tamanioX, int tamanioY, Color colorLetra){
		JLabel label = new JLabel(texto);
		label.setLocation(posicionX, posicionY);
		label.setSize(tamanioX, tamanioY);
		label.setHorizontalAlignment(0);
		label.setForeground(colorLetra);
		return label;
	}
	
	private JComboBox<Item> crearComboBox(DefaultComboBoxModel<Item> valores, int posicionX, int posicionY, int tamanioX, int tamanioY){
		JComboBox<Item> comboBox = new JComboBox<Item>(valores);
        comboBox.setMaximumRowCount(5);
        comboBox.setLocation(posicionX, posicionY);
        comboBox.setSize(tamanioX, tamanioY);
        comboBox.setAlignmentX(0);
        return comboBox;
	}
	
	private JButton crearBoton(String label, int posicionX, int posicionY, int tamanioX, int tamanioY, boolean habilitado){
		JButton button = new JButton(label);
		button.setLocation(posicionX, posicionY);
		button.setSize(tamanioX, tamanioY);
		button.setEnabled(habilitado);
		button.addActionListener(this);
        return button;
	}
	
	private JFormattedTextField crearInputText(int posicionX, int posicionY, int tamanioX, int tamanioY){
		JFormattedTextField inputText = new JFormattedTextField();
		inputText.setLocation(posicionX, posicionY);
		inputText.setSize(tamanioX, tamanioY);
		inputText.setColumns(10);
        return inputText;
	}
	
	public static void main(String[] args) {
		createAndShowGUI();
	}
	
	public List<LpDimension> getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(List<LpDimension> dimensiones) {
		this.dimensiones = dimensiones;
	}
		
	public List<LpCelda> getListaCeldas() {
		return listaCeldas;
	}

	public void setListaCeldas(List<LpCelda> listaCeldas) {
		this.listaCeldas = listaCeldas;
	}
}
