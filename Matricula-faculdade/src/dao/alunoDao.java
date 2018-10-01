package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Conexao;

public class alunoDao {

    Connection con = Conexao.getConexao();
    ;
	PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";  

    public void salvar(Aluno a) {
        con = Conexao.getConexao();
        sql = "insert into aluno(codigo, nome, cpf, idade, sexo) values (?, ?, ?, ?,?);";

        try {
            ps = con.prepareStatement(sql); 
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getNome());
            ps.setString(3, a.getCpf());
            ps.setInt(4, a.getIdade());
            ps.setString(5, a.getSexo());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar Carro!/n" + e.getMessage());
        }
    }

    public Aluno pesquisar(int codigo) {
        con = Conexao.getConexao();
        sql = "select *from aluno where codigo=?";
        Aluno alu = new Aluno();

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();
            if (rs.next()) {
            	alu.setCodigo(rs.getInt("codigo"));
                alu.setNome(rs.getString("nome"));
                alu.setCpf(rs.getString("cpf"));
                alu.setIdade(rs.getInt("idade"));
                alu.setSexo(rs.getString("sexo"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao pesquisar curso!/n" + e.getMessage());
        }

        return alu;

    }

    public void alterar(Aluno a) {
        con = Conexao.getConexao();
        String sql = "UPDATE aluno SET nome=?,cpf=?,idade=?,sexo=? WHERE codigo=?";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setString(2, a.getCpf());
            ps.setInt(3, a.getIdade());
            ps.setString(4, a.getSexo());
            ps.setInt(5, a.getCodigo());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Aluno Atualizado coms sucesso");
            System.out.println("Aluno Atualizado coms sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno");
        }

    }

    public void excluir(Aluno c) {
        con = Conexao.getConexao();
        String sql = "DELETE FROM aluno WHERE codigo=?";

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
}
