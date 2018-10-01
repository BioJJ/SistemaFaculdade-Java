package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import model.Modelo_tabela; 
import model.Conexao;


public class Tela_curso_cadastrados extends Telas{

	//painel principal
	JPanel painel= new JPanel();

	//imagem de fundo
	Icon IMG = new ImageIcon("src\\menu_principal.jpg");

	public JPanel  painel_tabela;
	public JTabbedPane painelAbas;

	//titulo da janela 
	String titulo= "Cursos Cadastrados";

	//tabela de dados
	JTable tabela = new JTable();


	public Tela_curso_cadastrados() {

		super();
		fundo_imagem(titulo, IMG);
		janela.setPreferredSize(new Dimension(500, 200));
		janela.setResizable(false);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		painel_fundo.setSize(500, 200);
		
	}

	public void  criarTela() {
		String Sql="select *from curso order by codigo";
		Connection con = Conexao.getConexao();
		ResultSet rs = null;

		ArrayList dados =  new ArrayList();
		String[] colunas = new String[]{"codigo", "nome", "valor"};

		try {

			Statement stm = con.createStatement();
			rs = stm.executeQuery(Sql);

			rs.first();

			do {
				dados.add(new Object[] {rs.getInt("codigo"), rs.getString("nome"),rs.getDouble("valor")});

			}while(rs.next());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao preencher o arrayls"+e1.getMessage());
		}

		//painel.setPreferredSize(new Dimension(500, 200));

		// CRIANDO PAINEL COM ABAS
		painelAbas = new JTabbedPane();
		painelAbas.setPreferredSize(new Dimension(450, 150)); 
		painel.add(painelAbas);



		painel_tabela = new JPanel();
		//painel_tabela.setPreferredSize(new Dimension(500, 200));
		painelAbas.add("Cursos Cadastrados", painel_tabela);

		//obj modelo da tabela
		Modelo_tabela modelo = new Modelo_tabela(dados, colunas);//modelo

		painel_tabela.add(getTablePane(modelo)); 

		//adicionando o fundo no painel
		//painel.add(painel_fundo);
		janela.getContentPane().add(painel, BorderLayout.CENTER);
		janela.setVisible(true);

	}

	public JScrollPane getTablePane(TableModel aluTabela) {


		tabela.setModel(aluTabela);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setResizable(false);

		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane jp = new JScrollPane(tabela);
		jp.setPreferredSize(new Dimension(440, 120));
		return jp;
	} 



	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Tela_curso_cadastrados tela=new Tela_curso_cadastrados();
		//tela.criarTela();
		tela.criarTela();

	}

}
