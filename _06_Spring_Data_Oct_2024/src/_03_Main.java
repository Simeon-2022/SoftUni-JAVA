
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _03_Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = "root";//sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = "MySQLRootPass@01";//sc.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

        System.out.println("Enter salary: ");
        String salary = sc.nextLine();
        stmt.setDouble(1, Double.parseDouble(salary));
        ResultSet rs = stmt.executeQuery();

        int index = 0;
        while (rs.next()) {
            System.out.printf("%d %s%n",
                    ++index,
                    rs.getString( "first_name") + " " + rs.getString("last_name"));
        }
        connection.close();
    }
}