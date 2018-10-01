package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Bolsas;
import model.Conexao;

public class BolsaDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    public void salvar(Bolsas c) {
        con = Conexao.getConexao();
        sql = "insert into bolsa(codigo, descricao, valor) values (?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.setString(2, c.getDescricao());
            ps.setDouble(3, c.getValor());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao cadastrar BOlsa!/n" + e.getMessage());
        }
    }

    public Bolsas pesquisar(int codigo) {
        con = Conexao.getConexao();
        sql = "select *from bolsa where codigo=?";
        Bolsas bolsa = new Bolsas();

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();
            if (rs.next()) {
            	bolsa.setCodigo(rs.getInt("codigo"));
            	bolsa.setDescricao(rs.getString("descricao"));
            	bolsa.setValor(rs.getDouble("valor"));
            }

        } catch (Exception e) {
            System.err.println("Erro ao pesquisar bolsa!/n" + e.getMessage());
        }

        return bolsa;

    }

    public void alterar(Bolsas c) {
        con = Conexao.getConexao();
        String sql = "UPDATE bolsa SET descricao=?,valor=? WHERE codigo=?";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, c.getDescricao());
            ps.setDouble(2, c.getValor());
            ps.setInt(3, c.getCodigo());

            ps.execute();

            System.out.println("Bolsa Atualizado coms sucesso");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar Bolsa");
        }

    }

    public void excluir(Bolsas c) {
        con = Conexao.getConexao();
        String sql = "DELETE FROM bolsa WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCodigo());
            ps.execute();
            System.out.println("Removido com sucesso!");
        } catch (Exception e) {
            System.err.println("Impossivel remover o bolsa");
            JOptionPane.showMessageDialog(null, "IMPORSIVEL REMOVER ALUNO");
        }

    }
}
