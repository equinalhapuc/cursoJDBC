import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();
		
		Integer idx = 2;
		
		PreparedStatement stm = connection.prepareStatement("delete from produto where ID > ?");	
		stm.setInt(1, idx);
		stm.execute();
		
		int linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Linhas modificadas: " + linhasModificadas);
	}

}
