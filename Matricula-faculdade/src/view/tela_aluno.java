package view;

import dao.alunoDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Aluno;

public class tela_aluno extends Telas  implements ActionListener{

	Aluno aluno= new Aluno();
	alunoDao aluDao= new alunoDao();

	//Imagem de fundo
	Icon IMG = new ImageIcon("src\\fundo_aulo.jpg");
	// definindo o titulo
	String titulo= "Cadastro de ALuno";

	//painel principal
	JPanel painel= new JPanel();
	//font
	Font font_lb = new Font("arial", Font.BOLD, 16);
	//label
	JLabel lb_codigo= new JLabel("Codigo"); 
	JLabel lb_nome= new JLabel("Nome");
	JLabel lb_idade = new JLabel("Idade");
	JLabel lb_sexo= new JLabel("Sexo");
	JLabel lb_cpf= new JLabel("CPF");

	//caixa de texto
	JTextField txt_cod =  new JTextField();
	JTextField txt_nome =  new JTextField();
	JTextField txt_idade = new JTextField();
	JTextField txt_sexo = new JTextField();
	JTextField txt_cpf = new JTextField();

	//botoes
	JButton bt_salvar = new JButton("Salvar");
	JButton bt_cancelar =  new JButton("Cancelar");


	public void criarTela() {

		//Chamando o metodo fundo_imagem
		fundo_imagem(titulo, IMG);

		painel.setLayout(null);


		lb_codigo.setBounds(10, 10, 300, 30);
		txt_cod.setBounds(10, 40, 80, 30);

		lb_nome.setBounds(10, 70, 300, 30);
		txt_nome.setBounds(10, 100, 300, 30);

		lb_cpf.setBounds(10, 130, 300, 30);
		txt_cpf.setBounds(10, 160, 300, 30);

		lb_idade.setBounds(10, 190, 60, 30);
		txt_idade.setBounds(10, 220, 60, 30);

		lb_sexo.setBounds(100, 190, 100, 30);
		txt_sexo.setBounds(100, 220, 100, 30);

		//cores e fontes
		lb_codigo.setFont(font_lb);
		lb_codigo.setForeground(Color.RED);

		lb_nome.setFont(font_lb);
		lb_nome.setForeground(Color.RED);

		lb_cpf.setFont(font_lb);
		lb_cpf.setForeground(Color.RED);

		lb_idade.setFont(font_lb);
		lb_idade.setForeground(Color.RED);

		lb_sexo.setFont(font_lb);
		lb_sexo.setForeground(Color.RED);


		bt_salvar.setBounds(10, 270, 80, 30);
		bt_salvar.addActionListener(this);
		bt_cancelar.setBounds(100, 270, 100, 30);
		bt_cancelar.addActionListener(this);

		painel.add(lb_codigo);
		painel.add(txt_cod);
		painel.add(lb_nome);
		painel.add(txt_nome);
		painel.add(lb_sexo);
		painel.add(txt_sexo);
		painel.add(lb_idade);
		painel.add(txt_idade);
		painel.add(lb_cpf);
		painel.add(txt_cpf);
		painel.add(bt_salvar);
		painel.add(bt_cancelar);


		//adicionando o fundo no painel
		painel.add(painel_fundo);
		janela.getContentPane().add(painel);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tela_aluno tela_cad_curso=new tela_aluno();
		tela_cad_curso.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==bt_salvar){
			salvar();
		}

		if(e.getSource()==bt_cancelar){
			janela.setVisible(false);
		}

	}

	public void salvar() {

		aluno.setCodigo(Integer.parseInt(txt_cod.getText()));
		aluno.setNome(txt_nome.getText());
		aluno.setCpf(txt_cpf.getText());
		aluno.setIdade(Integer.parseInt(txt_idade.getText()));
		aluno.setSexo((txt_sexo.getText()));


		aluDao.salvar(aluno);

		txt_cod.setText("");
		txt_nome.setText("");
		txt_idade.setText("");
		txt_sexo.setText("");
		txt_cpf.setText("");
	}



}
