package view;

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

import dao.BolsaDao;
import model.Bolsas;

public class tela_bolsa_pesq extends Telas implements ActionListener, Metodos {

	Bolsas b= new Bolsas();
	BolsaDao bolsaDao= new BolsaDao();


	//Imagem de fundo
	Icon IMG = new ImageIcon("src\\fundo_bolsa.jpg");
	//Tituo da janela
	String titulo= "Pesquisa de Bolsa";
	//painel principal
	JPanel painel= new JPanel();
	//font
	Font font_lb = new Font("arial", Font.BOLD, 16);
	//label
	JLabel lb_pesq= new JLabel("Pesquisa");
	JLabel lb_codigo= new JLabel("Codigo");
	JLabel lb_nome= new JLabel("Descrição");
	JLabel lb_valor = new JLabel("Valor");

	//caixa de texto
	JTextField txt_pesq =  new JTextField();
	JTextField txt_cod =  new JTextField();
	JTextField txt_descricao =  new JTextField();
	JTextField txt_valor = new JTextField();

	//botoes
	JButton bt_pesq = new JButton("Pesquisar");
	JButton bt_alterar = new JButton("Alterar");
	JButton bt_excluir = new JButton("Excluir");
	JButton bt_cancelar =  new JButton("Cancelar");

	public void criarTela() {

		//Metodo herdado
		fundo_imagem(titulo, IMG);

		painel.setLayout(null);

		lb_pesq.setBounds(10, 10, 300, 30);
		lb_pesq.setFont(font_lb);
		lb_pesq.setForeground(Color.RED);
		txt_pesq.setBounds(10, 40, 80, 30);
		bt_pesq.setBounds(230, 40, 100, 30);


		lb_nome.setBounds(10, 70, 300, 30);
		lb_nome.setFont(font_lb);
		lb_nome.setForeground(Color.RED);
		txt_descricao.setBounds(10, 100, 300, 30);

		lb_valor.setBounds(10, 130, 100, 30);
		lb_valor.setFont(font_lb);
		lb_valor.setForeground(Color.RED);
		txt_valor.setBounds(10, 160, 100, 30);

		bt_alterar.setBounds(10, 220, 100, 30);
		bt_excluir.setBounds(120, 220, 100, 30);
		bt_cancelar.setBounds(230, 220, 100, 30);



		painel.add(lb_pesq);
		painel.add(txt_pesq);
		painel.add(lb_nome);
		painel.add(txt_descricao);
		painel.add(lb_valor);
		painel.add(txt_valor);
		painel.add(bt_alterar);
		painel.add(bt_pesq);
		painel.add(bt_cancelar);
		painel.add(bt_excluir);

		bt_pesq.addActionListener(this);
		bt_alterar.addActionListener(this);
		bt_excluir.addActionListener(this);
		bt_cancelar.addActionListener(this);

		//adicionando o fundo no painel
		painel.add(painel_fundo);
		janela.getContentPane().add(painel);
		janela.setVisible(true);

	}

	@Override
	public void pesquisar(){

		Bolsas cc = bolsaDao.pesquisar(Integer.parseInt(txt_pesq.getText()));

		bolsaDao.pesquisar(Integer.parseInt(txt_pesq.getText()));
		txt_descricao.setText(cc.getDescricao());
		txt_valor.setText(String.valueOf(cc.getValor()));

	}

	@Override
	public void excluir(){

		Bolsas ec = bolsaDao.pesquisar(Integer.parseInt(txt_pesq.getText()));

		bolsaDao.excluir(ec);


	}


	@Override
	public void alterar() {
		Bolsas a = new Bolsas();
		a.setCodigo(Integer.parseInt(txt_pesq.getText()));
		a.setDescricao(txt_descricao.getText());
		a.setValor(Double.parseDouble(txt_valor.getText()));

		bolsaDao.alterar(a);

		txt_pesq.setText("");
		txt_descricao.setText("");
		txt_valor.setText("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		tela_bolsa_pesq tela_cad_curso=new tela_bolsa_pesq();
		tela_cad_curso.criarTela();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==bt_alterar){
			alterar();

		}if(e.getSource()==bt_cancelar){
			janela.setVisible(false);
		}
		if(e.getSource()==bt_excluir){
			excluir();

		}

		if(e.getSource()==bt_pesq){
			pesquisar();

		}

	}





}
