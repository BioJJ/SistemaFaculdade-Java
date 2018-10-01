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

public class tela_curso_pesq extends Telas implements ActionListener, Metodos {

    Cursos c = new Cursos();
    cursoDao cDao = new cursoDao();
    //imagem de fundo 
    Icon IMG = new ImageIcon("src\\fundo_curso.jpg");
    //titulo da janela
    String titulo= "Pesquisa de Curso";
    //Painel principal
    JPanel painel = new JPanel();
    
    //font
    Font font_lb = new Font("arial", Font.BOLD, 16);
    //label
    JLabel lb_pesq = new JLabel("Pesquisa");
    JLabel lb_nome = new JLabel("Nome");
    JLabel lb_valor = new JLabel("Valor");
    JLabel lb_turno = new JLabel("Turno");

    //caixa de texto
    JTextField txt_pesq = new JTextField();
    JTextField txt_nome = new JTextField();
    JTextField txt_valor = new JTextField();
    JTextField txt_turno = new JTextField();

    //botoes
    JButton bt_pesq = new JButton("Pesquisar");
    JButton bt_salvar = new JButton("Alterar");
    JButton bt_excluir = new JButton("Excluir");
    JButton bt_cancelar = new JButton("Cancelar");

    public void criarTela() {
    	
        fundo_imagem(titulo, IMG);

        painel.setLayout(null);

        lb_pesq.setBounds(10, 10, 100, 30);
        lb_pesq.setFont(font_lb);
        lb_pesq.setForeground(Color.RED);
        txt_pesq.setBounds(10, 40, 200, 30);
        bt_pesq.setBounds(230, 40, 100, 30);

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
		bt_excluir.setBounds(120, 220, 100, 30);
		bt_cancelar.setBounds(230, 220, 100, 30);

        painel.add(lb_pesq);
        painel.add(txt_pesq);
        painel.add(lb_nome);
        painel.add(txt_nome);
        painel.add(lb_turno);
        painel.add(txt_turno);
        painel.add(lb_valor);
        painel.add(txt_valor);
        painel.add(bt_salvar);
        painel.add(bt_pesq);
        painel.add(bt_cancelar);
        painel.add(bt_excluir);

        bt_pesq.addActionListener(this);
        bt_salvar.addActionListener(this);
        bt_excluir.addActionListener(this);
        bt_cancelar.addActionListener(this);
		//adicionando o fundo no painel
        painel.add(painel_fundo);
        janela.getContentPane().add(painel);
        janela.setVisible(true);

    }

    @Override
	public void pesquisar() {

        Cursos cc = cDao.pesquisar(Integer.parseInt(txt_pesq.getText()));

        cDao.pesquisar(Integer.parseInt(txt_pesq.getText()));
        txt_nome.setText(cc.getNome());
        txt_turno.setText(cc.getTurno());
        txt_valor.setText(String.valueOf(cc.getValor()));

    }

    @Override
	public void excluir() {
        //Cursos cc = cDao.pesquisar(Integer.parseInt(txt_pesq.getText()));
        
        c.setCodigo(Integer.parseInt(txt_pesq.getText()));
        cDao.excluir(c);

        txt_pesq.setText("");
        txt_nome.setText("");
        txt_turno.setText("");
        txt_valor.setText("");

    }

    @Override
	public void alterar() {
        //Cursos a = new Cursos();

        c.setCodigo(Integer.parseInt(txt_pesq.getText()));
        c.setNome(txt_nome.getText());
        c.setTurno(txt_turno.getText());
        c.setValor(Double.parseDouble(txt_valor.getText()));

        cDao.alterar(c);

        txt_pesq.setText("");
        txt_nome.setText("");
        txt_turno.setText("");
        txt_valor.setText("");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        tela_curso_pesq tela_pesq_curso = new tela_curso_pesq();
        tela_pesq_curso.criarTela();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == bt_pesq) {
            pesquisar();
        }

        if (e.getSource() == bt_salvar) {
            alterar();
        }

        if (e.getSource() == bt_excluir) {
            excluir();
        }
        if (e.getSource() == bt_cancelar) {
            janela.setVisible(false);
        }
    }

}
