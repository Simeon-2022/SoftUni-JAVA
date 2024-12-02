package _04_Java_DB_Apps_Introduction_Exercise;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _04_Add_minion {
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

        String[] minionInput = scanner.nextLine().split(" ");
        String[] villainInput = scanner.nextLine().split(" ");

        String minionTown = minionInput[3];
        String minionName = minionInput[1];
        int minionAge = Integer.parseInt(minionInput[2]);
        String villainName = villainInput[1];

        if (addTown(minionTown, connection)) {
            System.out.println("Town " + minionTown + " was added to the database.");
        }

        addMinion(minionName, minionTown, minionAge, connection);

        if (addVillain(villainName, connection)) {
            System.out.println("Villain " + villainName + " was added to the database.");
        }

        if (addServant(minionName, villainName, connection)) {
            System.out.println("Successfully added " + minionName + " to be minion of " + villainName + ".");
        }
    }

    public static boolean addServant(String minionName, String villainName, Connection connection) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(
                """
                         insert into minions_db.minions_villains (minion_id, villain_id)\s
                         values (?, ?);
                        \s""");

        stmt.setInt(1, getMinionId(minionName, connection));
        stmt.setInt(2, getVillainId(villainName, connection));

        return stmt.executeUpdate() == 1;
    }

    public static void addMinion(String minionName, String minionTown, int minionAge, Connection connection) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(
                """
                           select name
                           from minions_db.minions where name = ?;
                        """
        );

        stmt.setString(1, minionName);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.isBeforeFirst()) {

            int town_id = getTownId(minionTown, connection);

            PreparedStatement insertMinion = connection.prepareStatement(
                    """
                             insert into minions_db.minions (name, age, town_id)\s
                             values (?, ?, ?);
                            \s"""
            );
            insertMinion.setString(1, minionName);
            insertMinion.setInt(2, minionAge);
            insertMinion.setInt(3, town_id);

            insertMinion.executeUpdate();

        }
    }


    public static int getTownId(String minionTown, Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                """
                           select id
                           from minions_db.towns where name = ?;
                        """
        );

        stmt.setString(1, minionTown);

        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();

        return resultSet.getInt("id");
    }

    public static int getMinionId(String minionName, Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                """
                           select id
                           from minions_db.minions where name = ?;
                        """
        );

        stmt.setString(1, minionName);

        ResultSet resultSet = stmt.executeQuery();
        resultSet.next();
        return resultSet.getInt("id");
    }

    public static boolean addTown(String minionTown, Connection connection) throws SQLException {

        PreparedStatement stmt = connection.prepareStatement(
                """
                           select name
                           from minions_db.towns where name = ?;
                        """
        );

        stmt.setString(1, minionTown);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.isBeforeFirst()) {

            PreparedStatement insertMinionTown = connection.prepareStatement(
                    """
                               insert into minions_db.towns (name) value (?);
                            """
            );

            insertMinionTown.setString(1, minionTown);
            return insertMinionTown.executeUpdate() == 1;

        }
        return false;
    }


    public static boolean addVillain(String villainName, Connection connection) throws SQLException {

        if (getVillainId(villainName, connection) < 1) {

            PreparedStatement insertVillainName = connection.prepareStatement(
                    """
                               insert into minions_db.villains (name, evilness_factor)
                            values (?, ?);
                            """
            );

            insertVillainName.setString(1, villainName);
            insertVillainName.setString(2, "evil");

            return insertVillainName.executeUpdate() == 1;
        }
        return false;
    }

    private static int getVillainId(String villainName, Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                """
                           select id
                           from minions_db.villains where name = ?;
                        """
        );

        stmt.setString(1, villainName);

        ResultSet resultSet = stmt.executeQuery();

        if (!resultSet.isBeforeFirst()) {
            return 0;
        }

        resultSet.next();
        return resultSet.getInt("id");
    }

}
