import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection conn = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO pp = new ProdutoDAO(conn);
			pp.salvar(prod);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
