package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _09_Increase_Age_Stored_Procedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection();

        PreparedStatement procedure = connection.prepareStatement(
                "call usp_get_older(?);"
        );

        int id = Integer.parseInt(scanner.nextLine());
        procedure.setInt(1,id);

        procedure.executeUpdate();

        PreparedStatement select = connection.prepareStatement("select name, age from minions_db.minions where id = ?;");
        select.setInt(1,id);
        ResultSet resultSet = select.executeQuery();

        resultSet.next();
        System.out.printf("%s %d",resultSet.getString("name"), resultSet.getInt("age"));
    }

    public static Connection getConnection() throws SQLException {
        String host = "localhost";
        String port = "3306";
        String database = "minions_db";
        String user = "root";
        String pass = "MySQLRootPass@01";

        String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);

        return DriverManager.getConnection(url, props);
    }
}
