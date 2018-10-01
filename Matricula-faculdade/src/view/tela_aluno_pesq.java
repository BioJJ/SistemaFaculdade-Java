package view;

import dao.alunoDao;
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

import model.Aluno;

public class tela_aluno_pesq extends Telas implements ActionListener, Metodos {

    Aluno aluno = new Aluno();
    alunoDao aluDao = new alunoDao();
  //Imagem de fundo
    Icon IMG = new ImageIcon("src\\fundo_aulo.jpg");
    
 // definindo o titulo
    String titulo= "Pesquisa de ALuno";
    
   // Painel principal
    JPanel painel = new JPanel();
	//font
	Font font_lb = new Font("arial", Font.BOLD, 16);
	

    //label
    JLabel lb_codigo = new JLabel("Codigo");
    JLabel lb_nome = new JLabel("Nome");
    JLabel lb_idade = new JLabel("idade");
    JLabel lb_sexo = new JLabel("Sexo");
    JLabel lb_cpf = new JLabel("CPF");
    
    

    //caixa de texto
    JTextField txt_cod = new JTextField();
    JTextField txt_nome = new JTextField();
    JTextField txt_idade = new JTextField();
    JTextField txt_sexo = new JTextField();
    JTextField txt_cpf = new JTextField();
    JTextField txt_pesq = new JTextField();

    //botoes
    JButton bt_salvar = new JButton("Alterar");
    JButton bt_cancelar = new JButton("Cancelar");
    JButton bt_pesq = new JButton("Pesquisar");
    JButton bt_excluir = new JButton("Excluir");

    public void criarTela() {
    	
    	//chamando metodo
        fundo_imagem(titulo, IMG);
        
        painel.setLayout(null);
       
        //Cores e fontes
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
        
        lb_codigo.setBounds(10, 10, 80, 30);
        txt_pesq.setBounds(10, 40, 80, 30);
        
        lb_nome.setBounds(10, 70, 300, 30);
		txt_nome.setBounds(10, 100, 300, 30);

		lb_cpf.setBounds(10, 130, 300, 30);
		txt_cpf.setBounds(10, 160, 300, 30);

		lb_idade.setBounds(10, 190, 60, 30);
		txt_idade.setBounds(10, 220, 60, 30);

		lb_sexo.setBounds(100, 190, 100, 30);
		txt_sexo.setBounds(100, 220, 100, 30);

        bt_pesq.setBounds(200, 40, 100, 30);
        bt_pesq.addActionListener(this);
        
        bt_salvar.setBounds(10, 270, 80, 30);
        bt_salvar.addActionListener(this);
        
        
        bt_excluir.addActionListener(this);
        bt_excluir.setBounds(100, 270, 100, 30);
        
        bt_cancelar.setBounds(210, 270, 100, 30);
        bt_cancelar.addActionListener(this);
   

        painel.add(txt_pesq);
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
        painel.add(bt_excluir);
        painel.add(bt_pesq);
        
        //adicionando o fundo no painel
        painel.add(painel_fundo);
        janela.getContentPane().add(painel);
        janela.setVisible(true);

    }

    
    @Override
	public void pesquisar() {

        Aluno al = aluDao.pesquisar(Integer.parseInt(txt_pesq.getText()));

        txt_nome.setText(al.getNome());
        txt_cpf.setText(al.getCpf());
        txt_sexo.setText(al.getSexo());
        txt_idade.setText(String.valueOf(al.getIdade()));

    }

    @Override
	public void excluir() {

        //Aluno ec = aluDao.pesquisar(Integer.parseInt(txt_pesq.getText()));
        
        aluno.setCodigo(Integer.parseInt(txt_pesq.getText()));
        aluDao.excluir(aluno);

        txt_pesq.setText("");
        txt_nome.setText("");
        txt_idade.setText("");
        txt_cpf.setText("");
        txt_sexo.setText("");

    }

    @Override
	public void alterar() {

        aluno.setNome(txt_nome.getText());
        aluno.setCpf(txt_cpf.getText());
        aluno.setIdade(Integer.parseInt(txt_idade.getText()));
        aluno.setSexo((txt_sexo.getText()));

        aluno.setCodigo(Integer.parseInt(txt_pesq.getText()));

        aluDao.alterar(aluno);

        txt_pesq.setText("");
        txt_nome.setText("");
        txt_idade.setText("");
        txt_cpf.setText("");
        txt_sexo.setText("");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        tela_aluno_pesq tela_pesq_curso = new tela_aluno_pesq();
        tela_pesq_curso.criarTela();
        //tela_pesq_curso.fundo();
        

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
