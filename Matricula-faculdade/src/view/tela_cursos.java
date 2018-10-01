package view;

import dao.cursoDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Cursos;

public class tela_cursos extends Telas  implements ActionListener {

	Cursos c= new Cursos();
	cursoDao cDao= new cursoDao();
	//imagem de fundo
	Icon IMG = new ImageIcon("src\\fundo_curso.jpg");
	//Titulo da janela 
	String titulo= "Cadastro de Cursos";
	//painel principal
	JPanel painel= new JPanel();
	
	//font 
	Font font_lb = new Font("arial", Font.BOLD, 16);
	//label
	JLabel lb_codigo= new JLabel("Codigo");
	JLabel lb_nome= new JLabel("Nome");
	JLabel lb_valor = new JLabel("Valor");
	JLabel lb_turno= new JLabel("Turno");

	//caixa de texto
	JTextField txt_cod =  new JTextField();
	JTextField txt_nome =  new JTextField();
	JTextField txt_valor = new JTextField();
	JTextField txt_turno = new JTextField();

	//botoes
	JButton bt_salvar = new JButton("Salvar");
	JButton bt_cancelar =  new JButton("Cancelar");

	public void criarTela() {

        fundo_imagem(titulo, IMG);

		painel.setLayout(null);

		lb_codigo.setBounds(10, 10, 300, 30);
		txt_cod.setBounds(10, 40, 300, 30);

		lb_codigo.setBounds(10, 10, 100, 30);
		lb_codigo.setFont(font_lb);
		lb_codigo.setForeground(Color.RED);
		txt_cod.setBounds(10, 40, 300, 30);


		lb_nome.setBounds(10, 70, 300, 30);
		lb_nome.setFont(font_lb);
		lb_nome.setForeground(Color.RED);
		txt_nome.setBounds(10, 100, 300, 30);

		lb_valor.setBounds(10, 130, 100, 30);
		lb_valor.setFont(font_lb);
		lb_valor.setForeground(Color.RED);
		txt_valor.setBounds(10, 160, 100, 30);

		lb_turno.setBounds(150, 130, 100, 30);
		lb_turno.setFont(font_lb);
		lb_turno.setForeground(Color.RED);
		txt_turno.setBounds(150, 160, 100, 30);

		bt_salvar.setBounds(10, 220, 100, 30);
		bt_cancelar.setBounds(230, 220, 100, 30);


		bt_salvar.setBounds(10, 260, 80, 30);
		bt_salvar.addActionListener(this);
		bt_cancelar.setBounds(100, 260, 100, 30);
		bt_cancelar.addActionListener(this);

		painel.add(lb_codigo);
		painel.add(txt_cod);
		painel.add(lb_nome);
		painel.add(txt_nome);
		painel.add(lb_turno);
		painel.add(txt_turno);
		painel.add(lb_valor);
		painel.add(txt_valor);
		painel.add(bt_salvar);
		painel.add(bt_cancelar);
		//adicionando o fundo no painel
        painel.add(painel_fundo);
		janela.getContentPane().add(painel);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tela_cursos tela_cad_curso=new tela_cursos();
		tela_cad_curso.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==bt_salvar){
			salvar();
		}if(e.getSource()==bt_cancelar){
			janela.setVisible(false);
		}

	}

	public void salvar() {

		c.setCodigo(Integer.parseInt(txt_cod.getText()));
		c.setNome(txt_nome.getText());
		c.setTurno(txt_turno.getText());
		c.setValor(Double.parseDouble(txt_valor.getText()));

		cDao.salvar(c);

		txt_cod.setText("");
		txt_nome.setText("");
		txt_turno.setText("");
		txt_valor.setText("");
	}

}
