import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.recuperarConexao();
		List<Categoria> listaDeCategorias = null;
		
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
			listaDeCategorias = categoriaDAO.listar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Categoria categoria : listaDeCategorias) {
			System.out.println(categoria);
			for (Produto produto : categoria.getProdutos()) {
				System.out.println(produto);
			}
		}

	}

}
