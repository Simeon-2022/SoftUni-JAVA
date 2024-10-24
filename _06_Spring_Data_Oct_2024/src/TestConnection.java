
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String host = "localhost";
        String port = "3306";
        String database = "diablo";
        String user = "root";
        String pass = "MySQLRootPass@01";

        String url = String.format("jdbc:mysql://%s:%s/%s", host,port,database);

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password",pass);

        Connection connection = DriverManager.getConnection(url, props);

        String query =  "SELECT user_name,concat(first_name,' ',last_name) as full_name, count(game_id) as games_count " +
                "FROM users u join users_games ug on u.id = ug.user_id " +
                "where user_name = ? " +
                "group by user_name, full_name;";

        PreparedStatement stmt = connection.prepareStatement(query);

        System.out.println("Player name:");
        String playerName = scanner.nextLine();
        stmt.setString(1,playerName);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            System.out.println("No such user exists");
            return;
        }

        while (resultSet.next()) {
            System.out.printf(  "User: %s%n" +
                            "%s has played %d games",
                    resultSet.getString ("user_name"),
                    resultSet.getString ("full_name"),
                    resultSet.getInt ("games_count"));
        }
    }
}

