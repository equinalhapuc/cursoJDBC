import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory cf = new ConnectionFactory();
		Connection connection = cf.recuperarConexao();

		connection.setAutoCommit(false);

		try (PreparedStatement stm = connection.prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS)) {

			adicionarVariavel("Mouse", "Mouse sem fio", stm);
			adicionarVariavel("SmarTV", "45 polegadas", stm);

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			System.out.println("Rollback executado");
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}

	}

}
