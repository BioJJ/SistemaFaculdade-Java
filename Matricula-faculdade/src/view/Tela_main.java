package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Tela_main extends Telas implements ActionListener {

	//JFrame janela = new JFrame("FAMETRO");
	JPanel painel = new JPanel();
	//JPanel painel_imagem;

	Font font_lb = new Font("arial", Font.BOLD, 25);
	Font font_itens = new Font("old school", Font.BOLD, 14);

	// Cria barra do Menu
	JMenuBar barraMenu = new JMenuBar();

	// Cria menu 
	JMenu menu_matricula = new JMenu("Matricula");
	JMenu menu_aluno = new JMenu("Aluno");
	JMenu menu_curso = new JMenu("Curso"); 
	JMenu menu_bolsa = new JMenu("Bolsas   ");

	// Cria item da matricula
	JMenuItem realiza_matricula = new JMenuItem("Realizar matricula");
	JMenuItem pesquisar_matricula = new JMenuItem("Pesquisar Matriculados");
	JMenuItem lista_matricula = new JMenuItem("Listar");

	// Cria item do menu aluno
	JMenuItem cadastrar_aluno = new JMenuItem("Cadastrar");
	JMenuItem pesquisar_aluno = new JMenuItem("Pesquisar");
	JMenuItem lista_aluno = new JMenuItem("Listar");

	//criar item do menu curso
	JMenuItem cadastrar_curso = new JMenuItem("Cadastrar");
	JMenuItem pesquisar_curso = new JMenuItem("Pesquisar");
	JMenuItem lista_curso = new JMenuItem("Listar");

	//criar item do menu bolsas
	JMenuItem cadastrar_bolsas = new JMenuItem("Cadastrar");
	JMenuItem pesquisar_bolsas = new JMenuItem("Pesquisar");
	JMenuItem lista_bolsa = new JMenuItem("Listar");

	//label pra imagem
	JLabel img = new JLabel("");
	//setando o caminho da imagem
	ImageIcon icon = new ImageIcon("src\\\\cemetro.png");

	// definindo o titulo
	String titulo= "Sistema Fametro";

	//Colocando o fundo na tela principal
	Icon IMG = new ImageIcon("src\\menu_principal.jpg");

	public Tela_main() {

		//Chamando o metodo fundo_imagem
		fundo_imagem(titulo, IMG);

		//dados da tela
		janela.setSize(400, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);

		painel_fundo.setSize(400, 400);

	}

	public void criarTela() {

		//colocando a imagem na label
		img.setIcon(icon);
		//definindo o tamanho da label
		img.setBounds(50, 70, 289, 92);
		//definindo o tamanho da imagem 
		icon.setImage(icon.getImage().getScaledInstance(img.getWidth(), img.getHeight(), 1));


		painel.setLayout(null);

		//posicionando a barra de menu
		barraMenu.setBounds(0, 0, 400, 60);
		//adicionando a barra de menu no painel
		painel.add(barraMenu);
		//adicional a logo
		painel.add(img);


		// Adiciona menu a barra
		barraMenu.add(menu_matricula);
		barraMenu.add(menu_aluno);
		barraMenu.add(menu_curso);
		barraMenu.add(menu_bolsa);

		menu_matricula.setFont(font_lb);
		menu_matricula.setForeground(Color.RED);

		menu_aluno.setFont(font_lb);
		menu_aluno.setForeground(Color.RED);

		menu_bolsa.setFont(font_lb);
		menu_bolsa.setForeground(Color.RED);

		menu_curso.setFont(font_lb);
		menu_curso.setForeground(Color.RED);

		// Adiciona item ao Menu de matricula
		menu_matricula.add(realiza_matricula);
		menu_matricula.add(pesquisar_matricula);
		menu_matricula.add(lista_matricula);

		realiza_matricula.setFont(font_itens);
		pesquisar_matricula.setFont(font_itens);
		lista_matricula.setFont(font_itens);

		realiza_matricula.setForeground(Color.BLUE);
		pesquisar_matricula.setForeground(Color.BLUE);
		lista_matricula.setForeground(Color.BLUE);

		// Adiciona item ao Menu aluno
		menu_aluno.add(cadastrar_aluno);
		menu_aluno.add(pesquisar_aluno);   
		menu_aluno.add(lista_aluno);

		cadastrar_aluno.setFont(font_itens);
		pesquisar_aluno.setFont(font_itens);
		lista_aluno.setFont(font_itens);

		cadastrar_aluno.setForeground(Color.BLUE);
		pesquisar_aluno.setForeground(Color.BLUE);
		lista_aluno.setForeground(Color.BLUE);

		// Adiciona item ao Menu curso
		menu_curso.add(cadastrar_curso);
		menu_curso.add(pesquisar_curso);
		menu_curso.add(lista_curso);

		cadastrar_curso.setFont(font_itens);
		pesquisar_curso.setFont(font_itens);
		lista_curso.setFont(font_itens);

		cadastrar_curso.setForeground(Color.BLUE);
		pesquisar_curso.setForeground(Color.BLUE);
		lista_curso.setForeground(Color.BLUE);

		// Adiciona item ao Menu bolsa
		menu_bolsa.add(cadastrar_bolsas);
		menu_bolsa.add(pesquisar_bolsas);
		menu_bolsa.add(lista_bolsa);

		cadastrar_bolsas.setFont(font_itens);
		pesquisar_bolsas.setFont(font_itens);
		lista_bolsa.setFont(font_itens);

		cadastrar_bolsas.setForeground(Color.BLUE);
		pesquisar_bolsas.setForeground(Color.BLUE);
		lista_bolsa.setForeground(Color.BLUE);

		// Cria evento do item matricula
		realiza_matricula.addActionListener(this);
		pesquisar_matricula.addActionListener(this);
		lista_matricula.addActionListener(this);

		// Cria evento do item aluno
		cadastrar_aluno.addActionListener(this);
		pesquisar_aluno.addActionListener(this);
		lista_aluno.addActionListener(this);


		// Cria evento do item curso
		cadastrar_curso.addActionListener(this);
		pesquisar_curso.addActionListener(this);
		lista_curso.addActionListener(this);

		// Cria evento do item bolsa
		cadastrar_bolsas.addActionListener(this);
		pesquisar_bolsas.addActionListener(this);
		lista_bolsa.addActionListener(this);

		painel.add(painel_fundo);
		janela.getContentPane().add(painel);

		janela.setVisible(true);

	}// void criar tela


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tela_main tela = new Tela_main();

		tela.criarTela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cadastrar_curso) {

			tela_cursos tela_cad_curso = new tela_cursos();
			tela_cad_curso.criarTela();

		} else if (e.getSource() == pesquisar_curso) {

			tela_curso_pesq tela_pesq_curso = new tela_curso_pesq();
			tela_pesq_curso.criarTela();

		} //tela aluno
		else if (e.getSource() == cadastrar_aluno) {

			tela_aluno telaalu = new tela_aluno();
			telaalu.criarTela();

		} else if (e.getSource() == pesquisar_aluno) {

			tela_aluno_pesq tela_pesq_aluno = new tela_aluno_pesq();
			tela_pesq_aluno.criarTela();

		}
		else if (e.getSource() == lista_aluno) {

			Tela_aluno_cadastrados tela = new Tela_aluno_cadastrados();
			// tela.criarTela();
			tela.criarTela(/*"select *from aluno order by codigo"*/);

		} else if (e.getSource() == lista_matricula) {

			Tela_matricula_cadastrados tela = new Tela_matricula_cadastrados();
			// tela.criarTela();
			tela.criarTela(/*"select *from aluno order by codigo"*/);

		}
		//tela Bolsa
		else if (e.getSource() == cadastrar_bolsas) {

			tela_bolsas telaBolsa = new tela_bolsas();
			telaBolsa.criarTela();

		} else if (e.getSource() == pesquisar_bolsas) {

			tela_bolsa_pesq telaBolsa = new tela_bolsa_pesq();
			telaBolsa.criarTela();
		} else if (e.getSource() == lista_bolsa) {

			Tela_Bolsa_cadastrados tela = new Tela_Bolsa_cadastrados();
			// tela.criarTela();
			tela.criarTela(/*"select *from aluno order by codigo"*/);

		}else if (e.getSource() == lista_curso) {

			Tela_curso_cadastrados tela = new Tela_curso_cadastrados();
			// tela.criarTela();
			tela.criarTela(/*"select *from aluno order by codigo"*/);

		}

		else if (e.getSource() == realiza_matricula) {

			tela_matricula tela_m = new tela_matricula();
			tela_m.criarTela();
		}
		else if (e.getSource() == pesquisar_matricula) {

			tela_matricula_pesq tela_p_m = new tela_matricula_pesq();
			tela_p_m.criarTela();
		}

	}

}
