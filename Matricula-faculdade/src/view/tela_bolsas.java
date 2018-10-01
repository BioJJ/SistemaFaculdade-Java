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

public class tela_bolsas extends Telas implements ActionListener {

	Bolsas b= new Bolsas();
	BolsaDao bolsaDao= new BolsaDao();
	//imagem de fundo
	Icon IMG = new ImageIcon("src\\fundo_bolsa.jpg");
	//Titulo da janela
	String titulo= "Cadastro de BOLSA";
	//painel principal
	JPanel painel= new JPanel();
	//font
	Font font_lb = new Font("arial", Font.BOLD, 16);
	//label
	JLabel lb_codigo= new JLabel("Codigo");
	JLabel lb_nome= new JLabel("Descrição");
	JLabel lb_valor = new JLabel("Valor");

	//caixa de texto
	JTextField txt_cod =  new JTextField();
	JTextField txt_descricao =  new JTextField();
	JTextField txt_valor = new JTextField();

	//botoes
	JButton bt_salvar = new JButton("Salvar");
	JButton bt_cancelar =  new JButton("Cancelar");

	public void criarTela() {
		
		//metodo herdado
        fundo_imagem(titulo, IMG);

		painel.setLayout(null);

		lb_codigo.setBounds(10, 10, 300, 30);
		txt_cod.setBounds(10, 40, 300, 30);

		lb_codigo.setBounds(10, 10, 300, 30);
		lb_codigo.setFont(font_lb);
		lb_codigo.setForeground(Color.RED);
		txt_cod.setBounds(10, 40, 300, 30);
		


		lb_nome.setBounds(10, 70, 300, 30);
		lb_nome.setFont(font_lb);
		lb_nome.setForeground(Color.RED);
		txt_descricao.setBounds(10, 100, 300, 30);

		lb_valor.setBounds(10, 130, 100, 30);
		lb_valor.setFont(font_lb);
		lb_valor.setForeground(Color.RED);
		txt_valor.setBounds(10, 160, 100, 30);

		bt_salvar.setBounds(10, 220, 100, 30);
		bt_salvar.addActionListener(this);
		bt_cancelar.setBounds(120, 220, 100, 30);
		bt_cancelar.addActionListener(this);

		painel.add(lb_codigo);
		painel.add(txt_cod);
		painel.add(lb_nome);
		painel.add(txt_descricao);
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

		tela_bolsas tela_cad_curso=new tela_bolsas();
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

		b.setCodigo(Integer.parseInt(txt_cod.getText()));
		b.setDescricao(txt_descricao.getText());
		b.setValor(Double.parseDouble(txt_valor.getText()));

		bolsaDao.salvar(b);

		txt_cod.setText("");
		txt_descricao.setText("");
		txt_valor.setText("");
	}

}
