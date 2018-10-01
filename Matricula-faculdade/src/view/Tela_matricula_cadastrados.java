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


public class Tela_matricula_cadastrados extends Telas {

//painel principal
	JPanel painel= new JPanel();
	
	//imagem de fundo
	Icon IMG = new ImageIcon("src\\fundo_aulo.jpg");

	public JPanel  painel_tabela;
	public JTabbedPane jtb;
//titulo da janela
	String titulo= "Matriculas Cadastrados";
//tabela de dados
	JTable tabela = new JTable();

	public Tela_matricula_cadastrados() {

		super();
		fundo_imagem(titulo, IMG);
		//preencherTabela("select *from aluno order by codigo");
		janela.setPreferredSize(new Dimension(600, 250));
		janela.setResizable(true);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}

	public void  criarTela() {
		String Sql="SELECT * FROM matricula as mat INNER JOIN aluno AS aluno ON aluno.codigo=mat.codAluno \r\n" + 
         		"        INNER JOIN curso AS curso ON curso.codigo=mat.codCurso\r\n" + 
         		"        INNER JOIN bolsa AS bolsa ON bolsa.codigo=mat.codBolsa";
		Connection con = Conexao.getConexao();
		
		ResultSet rs = null;

		ArrayList dados =  new ArrayList();
		String[] colunas = new String[]{"codigo", "Codigo do aluno", "Nome do aluno", "Codigo do curso", "Nome do Curso", "Codigo da BOlsa", "Nome da bolsa", "Valor do desconto"};
			
		try {
			
			Statement stm = con.createStatement();
			 rs = stm.executeQuery(Sql);

			rs.first();

			do {
				dados.add(new Object[] {rs.getInt("codigo"), rs.getInt("codAluno"),rs.getString("aluno.nome"), rs.getInt("codCurso"), rs.getString("curso.nome"), rs.getInt("codBolsa"), rs.getString("bolsa.descricao"), rs.getDouble("valor_desc")});

			}while(rs.next());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "erro ao preencher o arrayls"+e1.getMessage());
		}
		
		//painel.setPreferredSize(new Dimension(600, 300));
		
		// CRIANDO PAINEL COM ABAS
		jtb = new JTabbedPane();
		jtb.setPreferredSize(new Dimension(500, 200)); 
		painel.add(jtb);

		painel_tabela = new JPanel();
		//painel_tabela.setPreferredSize(new Dimension(600, 300));
		jtb.add("Matriculas Realizadas", painel_tabela);

		//obejto modelo da tabela
		 Modelo_tabela modelo = new Modelo_tabela(dados, colunas);//modelo
	
		painel_tabela.add(getTablePane(modelo)); 

		//adicionando o fundo no painel
		//painel_tabela.add(painel_fundo);
		janela.getContentPane().add(painel, BorderLayout.CENTER);
		janela.setVisible(true);

	}
	
	public JScrollPane getTablePane(TableModel modelo) {

	
		tabela.setModel(modelo);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabela.getColumnModel().getColumn(0).setResizable(false);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(1).setResizable(false);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setResizable(false);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setResizable(false);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(4).setResizable(false);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setResizable(false);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(6).setResizable(false);
		tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(7).setResizable(false);
		tabela.getTableHeader().setReorderingAllowed(false);
		tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane jp = new JScrollPane(tabela);
		jp.setPreferredSize(new Dimension(490, 170));
		return jp;
	} 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Tela_matricula_cadastrados tela=new Tela_matricula_cadastrados();
		tela.criarTela();




	}

}
