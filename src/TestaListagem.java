import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("Select ID, NOME, DESCRICAO from produto");
		stm.execute();

		ResultSet rst = stm.getResultSet();

		System.out.println("ID\tNOME\t\tDESCRICAO");
		while (rst.next()) {
			Integer id = rst.getInt(1);
			String nome = rst.getString(2);
			String descricao = rst.getString(3);

			System.out.println(id + "\t" + nome + "\t" + descricao);
		}

		connection.close();

	}

}
