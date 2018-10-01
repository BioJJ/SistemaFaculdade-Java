package model;


import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

public class Modelo_tabela extends AbstractTableModel {
	
	private ArrayList<?> linhas = null;
	private String[] colunas=null;
	
	public Modelo_tabela( ArrayList<?> lin, String[] col) {
		// TODO Auto-generated constructor stub
		setLinhas(lin);
		setColunas(col);
		
	}
	
	public ArrayList<?> getLinhas() {
		return linhas;
	}
	
	public void setLinhas(ArrayList<?> dados) {
		linhas = dados;
	}
	
	public String[] getColunas() {
		return colunas;
	}
	
	public void setColunas(String[] nomes) {
		colunas = nomes;
	}
	
	

	public String getColumnName(int numcol) {
		
		return colunas[numcol]; //retorna o nome das colunas
	} 


	public int getColumnCount() {//qtd coluna
		
		return colunas.length; //retorna as colunas
	}

	
	public int getRowCount() { //qtd linha
	
		return linhas.size(); //retorna o numero de linhas
	}


	public Object getValueAt(int numLinha, int numColuna) { //pegar valor
		// TODO Auto-generated method stub
		
		Object[] linha = (Object[]) getLinhas().get(numLinha);
		
		return linha[numColuna];
		
		
	}
	
	
	
	

}
