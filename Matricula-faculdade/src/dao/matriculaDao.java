package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Matricula;
import model.Aluno;
import model.Bolsas;
import model.Conexao;
import model.Cursos;

public class matriculaDao {

	Connection con = Conexao.getConexao();
	;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	String sql = "";

	public void salvar(Matricula a) {
		con = Conexao.getConexao();
		sql = "insert into matricula(codigo, codAluno, codCurso, codBolsa, valor_desc) values (?, ?, ?, ?,?);";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, a.getCodigo()); 
			ps.setInt(2, a.getAluno().getCodigo());
			ps.setInt(3, a.getCurso().getCodigo());
			ps.setInt(4, a.getBolsa().getCodigo());
			ps.setDouble(5, a.getValor_desc());

			ps.execute();

			JOptionPane.showMessageDialog(null, "Matricula Realizado com sucesso!");

		} catch (Exception e) {
			System.err.println("Erro ao cadastrar Carro!/n" + e.getMessage());
		}
	}




	public java.util.List<Matricula> pesquisar(int id) {
		con = Conexao.getConexao();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Matricula> lista = new ArrayList<>();


		try {

			String  sql = "SELECT * FROM matricula as mat INNER JOIN aluno AS aluno ON aluno.codigo=mat.codAluno \r\n" + 
					"        INNER JOIN curso AS curso ON curso.codigo=mat.codCurso\r\n" + 
					"        INNER JOIN bolsa AS bolsa ON bolsa.codigo=mat.codBolsa where mat.codigo=?";

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);

			rs=pstm.executeQuery();
			while(rs.next()){

				Aluno aluno = new Aluno();
				Cursos curso = new Cursos();
				Bolsas bolsa= new Bolsas();
				Matricula matricula = new Matricula();

				aluno.setCodigo(rs.getInt("codAluno"));
				aluno.setNome(rs.getString("aluno.nome"));
				matricula.setAluno(aluno);

				curso.setCodigo((rs.getInt("codCurso")));
				curso.setNome(rs.getString("curso.nome"));
				matricula.setCurso(curso);

				bolsa.setCodigo((rs.getInt("codBolsa")));
				bolsa.setDescricao(rs.getString("bolsa.descricao"));
				matricula.setBolsa(bolsa);

				matricula.setValor_desc(rs.getDouble("valor_desc"));
				matricula.setCodigo((rs.getInt("codigo")));

				lista.add(matricula);

			}


		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;

	}



	public void alterar(Matricula a) {
		con = Conexao.getConexao();
		String sql = "UPDATE matricula SET codAluno=?,codCurso=?,codBolsa=?,valor_desc=? WHERE codigo=?";

		try {

			ps = con.prepareStatement(sql);

			
			ps.setInt(1, a.getAluno().getCodigo());
			ps.setInt(2, a.getCurso().getCodigo());
			ps.setInt(3, a.getBolsa().getCodigo());
			ps.setDouble(4, a.getValor_desc());
			
			ps.setInt(5, a.getCodigo()); 

			ps.execute();
			JOptionPane.showMessageDialog(null, "Matricula Atualizado coms sucesso");
			System.out.println("Matricula Atualizado coms sucesso");
		} catch (Exception e) {
			System.err.println("Erro ao atualizar Matricula");
		}

	}

	public void excluir(Matricula c) {
		con = Conexao.getConexao();
		String sql = "DELETE FROM matricula WHERE codigo=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getCodigo());
			ps.execute();
			// System.out.println("Removido com sucesso!");
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
		} catch (Exception e) {
			System.err.println("Impossivel remover o aluno");
			JOptionPane.showMessageDialog(null, "IMPOSSSIVEL REMOVER ALUNO");
		}

	}

	public double calculaBolsa(double valorCurso,double valorBolsa) {

		double valorAPagar=(valorCurso*valorBolsa)/100;

		return valorAPagar;
	}

	/* Criação da tabela matricula n banco
	 * 
	 * CREATE TABLE matricula(
    	    codigo int NOT null PRIMARY KEY AUTO_INCREMENT,
    	    codAluno int not null,
    	    codCurso int not null,
    	    codBolsa int not null,
    	    valor_desc double not null,

    	    FOREIGN KEY (codAluno) REFERENCES aluno(codigo),
    	    FOREIGN KEY (codCurso) REFERENCES curso(codigo),
    	    FOREIGN KEY (codBolsa) REFERENCES bolsa(codigo));*/
}
