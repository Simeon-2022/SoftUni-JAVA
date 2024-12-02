package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _07_Print_All_Minion_Names {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT name from minions_db.minions;");

        ResultSet resultSet = stmt.executeQuery();

        List<String> minions = new ArrayList<>();
        while (resultSet.next()) {

            minions.add(resultSet.getString("name"));
        }

        while (!minions.isEmpty()) {
            System.out.println(minions.getFirst());
            System.out.println(minions.getLast());
            minions.removeFirst();
            minions.removeLast();
        }



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
