import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.modelo.Categoria;

public class TesteCategoriaDao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.recuperarConexao();
		
		CategoriaDAO cd = new CategoriaDAO(conn);
		
		List<Categoria> categorias = null;
		categorias = cd.listarComProdutos();
		System.out.println(categorias);

	}

}
