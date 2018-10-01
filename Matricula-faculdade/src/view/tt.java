package view;

	
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.sql.ResultSet;

	import javax.swing.BorderFactory;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTabbedPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import javax.swing.SwingUtilities;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.table.TableModel;

	public class tt  extends JFrame {

	    ResultSet rst = null;
	    public JPanel Painel_principal, jpDia5;

	  
	    public JTabbedPane jtb;

	    public tt() {

	        super("Controle financeiro");

	        setPreferredSize(new Dimension(400, 350));
	        criaTela();
	        setResizable(false);
	        pack();
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    }

	    public void criaTela() {

	        // CRIANDO JPANEL PRINCIPAL E SETANDO PROPRIEDADES
	        Painel_principal = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        Painel_principal.setPreferredSize(new Dimension(340, 315));
	        Painel_principal.setBorder(BorderFactory.createTitledBorder("Resumo mensal"));
	        getContentPane().add(Painel_principal, BorderLayout.CENTER);

	        // CRIANDO PAINEL COM ABAS
	        jtb = new JTabbedPane();
	        jtb.setPreferredSize(new Dimension(340, 315));
	        Painel_principal.add(jtb);

	        jpDia5 = new JPanel();
	        jpDia5.setPreferredSize(new Dimension(100, 170));
	        jtb.add("Dia 5", jpDia5);
   

	    

	        DefaultTableModel dtm = new DefaultTableModel(new Object[][] {}, new String[] { "Título", "cu", "Valor" });
	        dtm.addRow(new Object[] {});
	        dtm.addRow(new Object[] {});
	
	        jpDia5.add(getTablePane(dtm)); 
	    
	    } 

	    public JScrollPane getTablePane(TableModel model) {

	        JTable table = new JTable(model);
	        table.getColumnModel().getColumn(0).setPreferredWidth(100);
	        table.getColumnModel().getColumn(1).setPreferredWidth(50);
	        table.getColumnModel().getColumn(2).setPreferredWidth(50);
	        JScrollPane jp = new JScrollPane(table);
	        jp.setPreferredSize(new Dimension(295, 100));
	        return jp;
	    } 

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new tt().setVisible(true));
	    }
	
}
