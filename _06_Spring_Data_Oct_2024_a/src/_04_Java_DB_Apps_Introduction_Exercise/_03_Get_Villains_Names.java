package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.*;

public class _03_Get_Villains_Names {
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
        PreparedStatement stmt = connection.prepareStatement(
                """
                        select v.name as 'villain_name', m.name as 'minion_name', age as 'minion_age'
                        from villains as v
                                 inner join minions_villains as mv on v.id = mv.villain_id
                                 inner join minions as m on m.id = mv.minion_id
                        where villain_id = ?
                        group by villain_id, v.name, m.name, age;""");


        String villain_id = scanner.nextLine();
        stmt.setString(1,villain_id);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            System.out.println("No villain with ID " + villain_id + " exists in the database.");
        }

        LinkedHashMap<String, List<String>> villainsAndMinions = new LinkedHashMap<>();
        
        int counter = 0;
        while (resultSet.next()) {

            String villainName = resultSet.getString("villain_name");
            
            List<String> minions = new ArrayList<>();
            villainsAndMinions.putIfAbsent(villainName, minions);
            
            String minionAndAge = String.format("%d. %s %s"
                    , ++counter
                    , resultSet.getString("minion_name")
                    , resultSet.getString("minion_age"));

            villainsAndMinions.get(villainName).add(minionAndAge);

        }

        villainsAndMinions.forEach((k,v) -> System.out.printf("Villain: %s%n%s",k, String.join(System.lineSeparator(),v)));
    }
}
