package SistemaMedico.Persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class FabricaConexao
{
    public static Connection pegaConexao() throws ErroDao {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/java?useSSL=false", "root", "aluno");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ErroDao(e);
        }
    }
}
