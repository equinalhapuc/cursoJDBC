import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource ds;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDS = new ComboPooledDataSource();
		comboPooledDS.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDS.setUser("root");
		comboPooledDS.setPassword("root");
		comboPooledDS.setMaxPoolSize(15);

		this.ds = comboPooledDS;
	}

	public Connection recuperarConexao() throws SQLException {
		return this.ds.getConnection();
	}
}
