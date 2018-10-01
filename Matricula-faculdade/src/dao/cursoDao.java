package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Cursos;
import model.Conexao;

public class cursoDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Cursos c) {
        con = Conexao.getConexao();
        sql = "insert into curso(codigo, nome, turno, valor) values (?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getNome());
            ps.setString(3, c.getTurno());
            ps.setDouble(4, c.getValor());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar Carro!/n" + e.getMessage());
        }
    }

    public Cursos pesquisar(int codigo) {
        con = Conexao.getConexao();
        sql = "select *from curso where codigo=?";
        Cursos curso = new Cursos();

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();
            if (rs.next()) {
            	curso.setCodigo(rs.getInt("codigo"));
                curso.setNome(rs.getString("nome"));
                curso.setTurno(rs.getString("turno"));
                curso.setValor(rs.getDouble("valor"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao pesquisar curso!/n" + e.getMessage());
        }

        return curso;

    }

    public void alterar(Cursos c) {
        con = Conexao.getConexao();
        String sql = "UPDATE curso SET nome=?,turno=?,valor=? WHERE codigo=?";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getTurno());
            ps.setDouble(3, c.getValor());
            ps.setInt(4, c.getCodigo());

            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Curso Atualizado coms sucesso");
            //System.out.println("Curso Atualizado coms sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno");
        }

    }

    public void excluir(Cursos c) {
    	
        con = Conexao.getConexao();
        String sql = "DELETE FROM curso WHERE codigo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
           // System.out.println("Removido com sucesso!");
        } catch (Exception e) {
            System.err.println("Impossivel remover o aluno");
            JOptionPane.showMessageDialog(null, "IMPORSIVEL REMOVER ALUNO");
        }

    }
}
