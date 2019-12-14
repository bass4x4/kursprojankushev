package Backend;

import java.sql.*;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.*;
public class App {
    public static void main(String[] args) {
//        String connectionUrl = "jdbc:sqlserver://192.168.56.1:1337;database=ankushev_kp;integratedSecurity=true";
//        SQLServerDriver driver = new SQLServerDriver();
        DBQueries.fillGameTeamsStats();
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
