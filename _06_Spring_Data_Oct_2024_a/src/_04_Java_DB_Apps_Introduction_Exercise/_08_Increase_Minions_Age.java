package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class _08_Increase_Minions_Age {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = getConnection();


        int[] ids = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < ids.length; i++) {
            updateDB(connection,ids[i]);
        }

        PreparedStatement select = connection.prepareStatement("select name, age from minions_db.minions");
        ResultSet resultSet = select.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %s%n",resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    public static void updateDB(Connection connection, int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "update minions_db.minions " +
                        "set age = age + 1 name = lower(name)" +
                        "where id = ?;"
        );

        stmt.setInt(1,id);
        stmt.executeUpdate();
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
