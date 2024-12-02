package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _06_Remove_Villain {
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
        int villain_id = Integer.parseInt(scanner.nextLine());

        PreparedStatement getVillainName = connection.prepareStatement("select name from minions_db.villains where id = ?");
        getVillainName.setInt(1, villain_id);
        ResultSet resultSet = getVillainName.executeQuery();

        String villain_name;

        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            villain_name = resultSet.getString("name");

            PreparedStatement releaseMinions = connection.prepareStatement("delete from minions_db.minions_villains where villain_id = ?");
            releaseMinions.setInt(1, villain_id);

            int minionsReleased = releaseMinions.executeUpdate();

            PreparedStatement deleteStmt = connection.prepareStatement("delete from minions_db.villains where id = ?");

            deleteStmt.setInt(1, villain_id);
            if (deleteStmt.executeUpdate() > 0) {
                System.out.println(villain_name + " was deleted");
            }

            if (minionsReleased > 0) {
                System.out.println(minionsReleased + " minions released");
            }
        } else {
            System.out.println("No such villain was found");
        }


    }
}
