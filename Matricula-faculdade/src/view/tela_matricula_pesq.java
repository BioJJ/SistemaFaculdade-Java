package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.BolsaDao;
import dao.alunoDao;
import dao.cursoDao;
import dao.matriculaDao;
import model.Aluno;
import model.Bolsas;
import model.Cursos;
import model.Matricula;

public class tela_matricula_pesq extends Telas implements ActionListener, Metodos, KeyListener {
	//

	Aluno aluno = new Aluno();
	alunoDao aluDao = new alunoDao();

	Bolsas bolsa = new Bolsas();
	BolsaDao bolsaDao = new BolsaDao();

	Cursos curso = new Cursos();
	cursoDao cDao = new cursoDao();


	JPanel painel = new JPanel();

	Matricula matricula = new Matricula();
	matriculaDao matDao = new matriculaDao();

	//imagem de fundo
	Icon IMG = new ImageIcon("src\\matricula_fundo.jpg");

	//titulo da janela
	String titulo="Realizar Matricula";


	//font
	Font font_lb = new Font("arial", Font.BOLD, 13);

	//label matricula
	JLabel lb_codigo = new JLabel("Codigo");
	JLabel valor_desc = new JLabel("Valor do Desconto");

	//label pesquisar aluno
	JLabel pesq_aluno = new JLabel("Pesquisar Aluno");
	JLabel codigo_aluno = new JLabel("Codigo Aluno");
	JLabel nome_aluno = new JLabel("Nome Aluno");

	//label pesquisar curso
	JLabel pesq_curso = new JLabel("Pesquisar Curso"); 
	JLabel codigo_curso = new JLabel("Codigo Curso");
	JLabel nome_curso = new JLabel("Nome Curso");
	//label pesquisar bolsa
	JLabel pesq_bolsa = new JLabel("Pequisar Bolsa");
	JLabel codigo_bolsa = new JLabel("Codigo Bolsa");
	JLabel nome_bolsa = new JLabel("Nome Bolsa");

	//caixa de texto
	JTextField txt_pesq = new JTextField();
	JTextField txt_valor_desc = new JTextField();

	JTextField txt_pesq_aluno = new JTextField();
	JTextField txt_codigo_aluno = new JTextField();
	JTextField txt_nome_aluno = new JTextField();

	JTextField txt_pesq_curso = new JTextField();
	JTextField txt_codigo_curso = new JTextField();
	JTextField txt_nome_curso = new JTextField();

	JTextField txt_pesq_bolsa = new JTextField();
	JTextField txt_codigo_bolsa = new JTextField();
	JTextField txt_nome_bolsa = new JTextField();

	//botoes
	JButton bt_salvar = new JButton("Alterar");
	JButton bt_cancelar = new JButton("Cancelar");
	JButton bt_pesq = new JButton("Pesquisar");
	JButton bt_excluir = new JButton("Excluir");

	public tela_matricula_pesq() {

		super();
		fundo_imagem(titulo, IMG);
		janela.setSize(600, 600);
		painel_fundo.setSize(600, 600);
		janela.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		janela.setLocation(300, 100);
	}

	public void criarTela() {

		painel.setLayout(null);

		//cores e fontes
		lb_codigo.setFont(font_lb);
		lb_codigo.setForeground(Color.BLUE);
		pesq_aluno.setFont(font_lb);
		pesq_aluno.setForeground(Color.BLUE);
		codigo_aluno.setFont(font_lb);
		codigo_aluno.setForeground(Color.BLUE);
		nome_aluno.setFont(font_lb);
		nome_aluno.setForeground(Color.BLUE);
		pesq_curso.setFont(font_lb);
		pesq_curso.setForeground(Color.BLUE);
		codigo_curso.setFont(font_lb);
		codigo_curso.setForeground(Color.BLUE);
		nome_curso.setFont(font_lb);
		nome_curso.setForeground(Color.BLUE);
		pesq_bolsa.setFont(font_lb);
		pesq_bolsa.setForeground(Color.BLUE);
		codigo_bolsa.setFont(font_lb);
		codigo_bolsa.setForeground(Color.BLUE);
		nome_bolsa.setFont(font_lb);
		nome_bolsa.setForeground(Color.BLUE);
		valor_desc.setFont(font_lb);
		valor_desc.setForeground(Color.BLUE);


		lb_codigo.setBounds(10, 10, 300, 30);
		txt_pesq.setBounds(10, 40, 100, 30);
		bt_pesq.setBounds(270, 40, 100, 30);
		bt_pesq.addActionListener(this);

		pesq_aluno.setBounds(10, 70, 300, 30);
		txt_pesq_aluno.setBounds(10, 100, 100, 30);

		codigo_aluno.setBounds(120, 70, 100, 30);
		txt_codigo_aluno.setBounds(120, 100, 100, 30);
		txt_codigo_aluno.setEditable(false);
		nome_aluno.setBounds(230, 70, 300, 30);
		txt_nome_aluno.setBounds(230, 100, 300, 30);
		txt_nome_aluno.setEditable(false);

		pesq_curso.setBounds(10, 170, 300, 30);
		txt_pesq_curso.setBounds(10, 200, 100, 30);
		codigo_curso.setBounds(120, 170, 100, 30);
		txt_codigo_curso.setBounds(120, 200, 100, 30);
		txt_codigo_curso.setEditable(false);
		nome_curso.setBounds(230, 170, 300, 30);
		txt_nome_curso.setBounds(230, 200, 300, 30);
		txt_nome_curso.setEditable(false);

		pesq_bolsa.setBounds(10, 270, 300, 30);
		txt_pesq_bolsa.setBounds(10, 300, 100, 30);

		codigo_bolsa.setBounds(120, 270, 100, 30);
		txt_codigo_bolsa.setBounds(120, 300, 100, 30);
		txt_codigo_bolsa.setEditable(false);
		nome_bolsa.setBounds(230, 270, 300, 30);
		txt_nome_bolsa.setBounds(230, 300, 300, 30);
		txt_nome_bolsa.setEditable(false);

		valor_desc.setBounds(10, 370, 300, 30);
		txt_valor_desc.setBounds(10, 400, 200, 30);
		txt_valor_desc.setEditable(false);

		bt_salvar.setBounds(10, 470, 80, 30);
		bt_salvar.addActionListener(this);
		bt_salvar.setEnabled(false);
		bt_excluir.setBounds(100, 470, 100, 30);
		bt_excluir.addActionListener(this);
		bt_excluir.setEnabled(false);
		bt_cancelar.setBounds(210, 470, 100, 30);
		bt_cancelar.addActionListener(this);

		txt_pesq_aluno.addKeyListener(this);
		txt_pesq_bolsa.addKeyListener(this);
		txt_pesq_curso.addKeyListener(this);

		painel.add(lb_codigo);
		painel.add(txt_pesq);
		painel.add(pesq_aluno);
		painel.add(txt_pesq_aluno);
		painel.add(nome_aluno);
		painel.add(txt_nome_aluno);
		painel.add(codigo_aluno);
		painel.add(txt_codigo_aluno);

		painel.add(nome_curso);
		painel.add(txt_nome_curso);
		painel.add(codigo_curso);
		painel.add(txt_codigo_curso);

		painel.add(nome_bolsa);
		painel.add(txt_nome_bolsa);
		painel.add(codigo_bolsa);
		painel.add(txt_codigo_bolsa);

		painel.add(pesq_bolsa);
		painel.add(txt_pesq_bolsa);
		painel.add(pesq_curso);
		painel.add(txt_pesq_curso);
		painel.add(valor_desc);
		painel.add(txt_valor_desc);

		painel.add(bt_salvar);
		painel.add(bt_cancelar);
		painel.add(bt_excluir);
		painel.add(bt_pesq);

		painel.add(painel_fundo);
		janela.getContentPane().add(painel);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tela_matricula_pesq tela_cad_curso = new tela_matricula_pesq();
		tela_cad_curso.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == bt_pesq) {
			pesquisar();
		}

		if (e.getSource() == bt_cancelar) {
			janela.setVisible(false);
		}

	}

	private void Pesquisar_Aluno() {

		Aluno al = aluDao.pesquisar(Integer.parseInt(txt_pesq_aluno.getText()));

		txt_nome_aluno.setText(al.getNome());
		txt_codigo_aluno.setText(String.valueOf(al.getCodigo()));

	}

	private void Pesquisar_Curso() {

		Cursos cc = cDao.pesquisar(Integer.parseInt(txt_pesq_curso.getText()));

		txt_nome_curso.setText(cc.getNome());
		txt_codigo_curso.setText(String.valueOf(cc.getCodigo()));

	}

	private void Pesquisar_Bolsa() {

		Bolsas bb = bolsaDao.pesquisar(Integer.parseInt(txt_pesq_bolsa.getText()));

		txt_nome_bolsa.setText(bb.getDescricao());
		txt_codigo_bolsa.setText(String.valueOf(bb.getCodigo()));

	}

	public void alterar() {

		matricula.setCodigo(Integer.parseInt(txt_pesq.getText()));

		aluno.setCodigo(Integer.parseInt(txt_codigo_aluno.getText()));

		matricula.setAluno(aluno);

		curso.setCodigo(Integer.parseInt(txt_codigo_curso.getText()));
		matricula.setCurso(curso);

		bolsa.setCodigo(Integer.parseInt(txt_codigo_bolsa.getText()));
		matricula.setBolsa(bolsa);

		matricula.setValor_desc(Double.parseDouble(txt_valor_desc.getText()));

		matDao.alterar(matricula);

		txt_pesq.setText("");
		txt_pesq_aluno.setText("");
		txt_pesq_curso.setText("");
		txt_pesq_bolsa.setText("");
		txt_valor_desc.setText("");
		txt_nome_aluno.setText("");
		txt_codigo_aluno.setText("");
		txt_nome_curso.setText("");
		txt_codigo_aluno.setText("");
		txt_nome_bolsa.setText("");
		txt_codigo_bolsa.setText("");
	}

	@Override
	public void pesquisar() {


		for(Matricula mat : matDao.pesquisar(Integer.valueOf(txt_pesq.getText()))) {
			txt_codigo_aluno.setText(String.valueOf(mat.getAluno().getCodigo()));
			txt_nome_aluno.setText(mat.getAluno().getNome());
			txt_valor_desc.setText(String.valueOf(mat.getValor_desc()));

			txt_nome_aluno.setText(mat.getAluno().getNome());
			txt_codigo_curso.setText(String.valueOf(mat.getCurso().getCodigo()));
			txt_nome_curso.setText(mat.getCurso().getNome());
			txt_codigo_bolsa.setText(String.valueOf(mat.getBolsa().getCodigo()));
			txt_nome_bolsa.setText(mat.getBolsa().getDescricao());



		}

	}

	private void Calcular_Desconto() {
		// TODO Auto-generated method stub
		aluno.setCodigo(Integer.parseInt(txt_codigo_aluno.getText()));
		curso.setCodigo(Integer.parseInt(txt_codigo_curso.getText()));
		Cursos cursopesq = cDao.pesquisar(Integer.parseInt(txt_codigo_curso.getText()));
		Bolsas bolsapesq = bolsaDao.pesquisar(Integer.parseInt(txt_codigo_bolsa.getText()));

		double valor_curso = cursopesq.getValor();
		double valor_bolsa = bolsapesq.getValor();

		double valor_descontado = matDao.calculaBolsa(valor_curso, valor_bolsa);

		txt_valor_desc.setText(String.valueOf(valor_descontado));

	}



	@Override
	public void excluir() {
		// TODO Auto-generated method stub

		matricula.setCodigo(Integer.parseInt(txt_pesq.getText()));
		matDao.excluir(matricula);

		txt_pesq.setText("");
		txt_pesq_aluno.setText("");
		txt_pesq_curso.setText("");
		txt_pesq_bolsa.setText("");
		txt_valor_desc.setText("");
		txt_nome_aluno.setText("");
		txt_codigo_aluno.setText("");
		txt_nome_curso.setText("");
		txt_codigo_aluno.setText("");
		txt_nome_bolsa.setText("");
		txt_codigo_bolsa.setText("");

	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == e.VK_ENTER && e.getSource() == txt_pesq_aluno) {

			if (txt_pesq_aluno.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "txt_pesq_aluno");
				txt_pesq_aluno.setFocusable(true);
			} else {
				Pesquisar_Aluno();
			}

		}
		if (e.getKeyCode() == e.VK_ENTER && e.getSource() == txt_pesq_bolsa) {

			if (txt_pesq_bolsa.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				txt_pesq_bolsa.setFocusable(true);

			} else {
				Pesquisar_Bolsa();

				if (txt_pesq_curso.getText().equals("")) {

				} else {
					Calcular_Desconto();
				}

			}

		}
		if (e.getKeyCode() == e.VK_ENTER && e.getSource() == txt_pesq_curso) {
			if (txt_pesq_curso.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				txt_pesq_curso.setFocusable(true);

			} else {
				Pesquisar_Curso();
				if (txt_pesq_bolsa.getText().equals(" ")) {

				} else {
					Calcular_Desconto();
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
