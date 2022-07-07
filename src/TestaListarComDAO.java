import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListarComDAO {

	public static void main(String[] args) throws SQLException {
		List<Produto> produtos;
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.recuperarConexao();
		ProdutoDAO produtoDAO = new ProdutoDAO(conn);
		produtos = produtoDAO.listar();
		
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

}
