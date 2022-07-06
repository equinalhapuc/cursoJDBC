import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) {
		
		Produto prod = new Produto("Cômoda", "Cômoda Vertical");

		try (Connection conn = new ConnectionFactory().recuperarConexao()) {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
			
			try (PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				stm.setString(1, prod.getNome());
				stm.setString(2, prod.getDescricao());
				
				stm.execute();
				
				try(ResultSet rst = stm.getGeneratedKeys()) {
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
