package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {



	public static Connection getConexao(){

		ResultSet rs;
		Connection con = null; //interface que recebe conexoes de bancos de dados 
		String url = "jdbc:mysql://localhost:3306/matricula_faculdade";
		String user = "root";
		String senha = ""; 

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, senha);

			//System.out.print("Conexão 100% G-zuis");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("Conex�o 0% Satanaaaaaaaaaaaaaix -->"+e.getMessage());
		}
		return con;

	}//GetConnection

	
}
