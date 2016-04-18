package com.sample;

import javax.swing.table.AbstractTableModel;

class TablaResultados extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1724650209342968161L;

	private String[] columnNames = {"First Name", "Last Name", "Sport"};
	
	private Object[][] data = { 
			{"Kathy", "Smith", "Snowboarding"}, 
			{"John", "Doe", "Rowing"}, 
			{"Jane", "White", "Speed reading"}, 
			{"Joe", "Brown", "Pool"}};
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

}
