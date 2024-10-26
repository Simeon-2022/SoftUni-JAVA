package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _05_Change_Town_Names_Casing {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String host = "localhost";
        String port = "3306";
        String database = "minions_db";
        String user = "root";
        String pass = "MySQLRootPass@01";

        String url = String.format("jdbc:mysql://%s:%s/%s", host, port, database);

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);

        Connection connection = DriverManager.getConnection(url, props);

        PreparedStatement updateStmt = connection.prepareStatement("update minions_db.towns set name = upper(name) where country = ?;");

        String input = scanner.nextLine();
        updateStmt.setString(1,input);

        int rowsAffected = updateStmt.executeUpdate();
        if (rowsAffected == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.println(rowsAffected + " town names were affected.");
            PreparedStatement selectStmt = connection.prepareStatement("select name from minions_db.towns where country = ?");
            selectStmt.setString(1,input);

            List<String> townsToUpper = new ArrayList<>();
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                townsToUpper.add(resultSet.getString("name"));
            }

            System.out.printf("[%s]",String.join (",",townsToUpper));

        }

    }
}
