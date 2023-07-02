package renan.carvalho.agendertransfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IntegracaoDbJava {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/agendertransferdb/";
        String username = "root";
        String password = "Renan160398%";

        return DriverManager.getConnection(url, username, password);
    }



}
