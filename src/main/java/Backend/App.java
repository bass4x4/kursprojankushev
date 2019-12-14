package Backend;

import java.sql.*;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.*;
public class App {
    public static void main(String[] args) {
//        String connectionUrl = "jdbc:sqlserver://192.168.56.1:1337;database=ankushev_kp;integratedSecurity=true";
//        SQLServerDriver driver = new SQLServerDriver();
        SQLServerDataSource serverDataSource = new SQLServerDataSource();
        serverDataSource.setServerName("192.168.56.1");
        serverDataSource.setPortNumber(1337);
        serverDataSource.setDatabaseName("ankushev_kp");
        serverDataSource.setIntegratedSecurity(true);
        try {
            Connection connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            //language=TSQL
            String s = "INSERT  into game (game_id, season, type, away_team_id, home_team_id, away_goals, home_goals)\n" +
                    "values" +
                    "(2, 1, 'P', 1, 2, 1, 3);";
            statement.executeUpdate(s);
            System.out.println("ok");
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Properties properties = new Properties();
/*
        try {
            driver.connect(connectionUrl, properties);
            System.out.println("ok");
        } catch (SQLServerException e) {
            e.printStackTrace();
        }
*/
    }
}
