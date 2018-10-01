package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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


public class Tela_aluno_cadastrados extends Telas {


	JPanel painel= new JPanel();
	Icon IMG = new ImageIcon("src\\fundo_aulo.jpg");

	public JPanel  painel_tabela;
	public JTabbedPane painel_de_abas;

	String titulo= "ALuno Cadastrados";
	
	//Tabela de dados
	JTable tabela = new JTable();

	//Construtor
	public Tela_aluno_cadastrados() {

		//Metodo de imagem;
		fundo_imagem(titulo, IMG);
		//Caracteristicas da tela
		janela.setPreferredSize(new Dimension(600, 250));
		janela.setResizable(false);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}

	public void  criarTela() {
		String Sql="select *from aluno order by codigo";
		Connection con = Conexao.getConexao();
		
		ResultSet rs = null;

		ArrayList dados =  new ArrayList();
		String[] colunas = new String[]{"codigo", "nome", "cpf", "idade", "sexo"};
			
		try {
			
			Statement stm = con.createStatement();
			 rs = stm.executeQuery(Sql);

			rs.first();

			do {
				dados.add(new Object[] {rs.getInt("codigo"), rs.getString("nome"),rs.getString("cpf"), rs.getInt("idade"), rs.getString("sexo")});

			}while(rs.next());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao preencher o arrayls"+e1.getMessage());
		}
		
		
		
		//painel.setPreferredSize(new Dimension(400, 200));
		
		// CRIANDO PAINEL COM ABAS
		painel_de_abas = new JTabbedPane();
		painel_de_abas.setPreferredSize(new Dimension(500, 200)); 
		
		
		painel.add(painel_de_abas);

		painel_tabela = new JPanel();
		//painel_tabela.setPreferredSize(new Dimension(30, 30));
		painel_de_abas.add("Alunos Cadastrados", painel_tabela);
		

		//Criando o objeto do modelo da tabela
		 Modelo_tabela aluTabela = new Modelo_tabela(dados, colunas);//modelo
	
		//adicionando a tabela com o modelo no painel tabela
		painel_tabela.add(getTablePane(aluTabela)); 

		//adicionando o fundo no painel
		//painel.add(painel_fundo);
		janela.getContentPane().add(painel, BorderLayout.CENTER);
		janela.setVisible(true);

	}
	
	public JScrollPane getTablePane(TableModel aluTabela) {

	
		tabela.setModel(aluTabela);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane jp = new JScrollPane(tabela);
		jp.setPreferredSize(new Dimension(450, 150));
		return jp;
	} 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Tela_aluno_cadastrados tela=new Tela_aluno_cadastrados();
		
		tela.criarTela();




	}

}
