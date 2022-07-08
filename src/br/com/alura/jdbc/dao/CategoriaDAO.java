package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT ID, NOME FROM categoria";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return categorias;
	}
	
	public List<Categoria> listarComProdutos() {
		List<Categoria> categorias = new ArrayList<>();
		
		String sql = "SELECT c.id, c.nome, p.id, p.nome, p.descricao FROM categoria c INNER JOIN "
				+ "produto p ON p.categoria_id = c.id";
		Categoria ultima = null;
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					if(ultima == null || ultima.getNome() != rst.getString(2)) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						categorias.add(categoria);
						ultima = categoria;
					}
					Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
					ultima.adicionaProduto(produto);
				}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return categorias;
	}
	
}
