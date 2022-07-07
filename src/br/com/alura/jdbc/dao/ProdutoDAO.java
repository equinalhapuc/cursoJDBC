package br.com.alura.jdbc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {
	
	private Connection conn;

	public ProdutoDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void salvar(Produto produto) {
		String sql = "INSERT INTO produto (NOME, DESCRICAO) VALUES (?, ?)";
		
		try (PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			
			stm.execute();
			
			try(ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					int id = rst.getInt(1);
					produto.setId(id);
					System.out.println(produto);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
