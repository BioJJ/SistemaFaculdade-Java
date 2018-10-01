package view;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class Telas {
	
	public JPanel painel_fundo;
	public JFrame janela= new JFrame();
	
	public abstract void criarTela();
	
	
	public void fundo_imagem(String titulo, Icon img) {
		
		
		janela.setTitle(titulo);
		janela.setSize(370, 350);
		janela.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		janela.setLocation(500,100);
		
		 //Colocando o fundo na tela principal
      // Icon IMG_BV = new ImageIcon("src\\fundo_aulo.jpg");

	    //Icon IMG_BV = new ImageIcon(img);
		
       painel_fundo = new JPanel();
       JLabel x = new JLabel(img);
       painel_fundo.add(x);
       painel_fundo.setSize(370, 350);
       painel_fundo.setLocation(0, -10);
       painel_fundo.setVisible(true);
       
       
      
	}
	
}
