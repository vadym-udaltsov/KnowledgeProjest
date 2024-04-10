package sql.spec;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class SQLSpecification {

    private static final String SQL_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String SQL_USERNAME = "vadymudaltsov";
    private static final String SQL_PASSWORD = "!!ITvadyMUdaltsovIT!!";

    private static Connection connection;
    private static Statement statement;

    public String getSQLBase() {
        return "Aspect is working";
    }

    @SneakyThrows
    public static Statement getConnection() {
        if (connection == null) {
            connection = DriverManager.getConnection(SQL_URL, SQL_USERNAME, SQL_PASSWORD);
        }
        if (!connection.isClosed()) {
            System.out.println("Connection to SQL DataBase is successful");
        }
        if (statement == null) {
            statement = connection.createStatement();
        }
        return statement;
    }

    @SneakyThrows
    public static void closeConnection() {
        if (connection != null) {
            connection.close();
            System.out.println("Connection to SQL DataBase is closed");
        } else {
            System.out.println("Connection to SQL DataBase is already closed");
        }
    }
}
