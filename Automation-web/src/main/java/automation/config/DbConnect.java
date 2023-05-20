package automation.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnect {

    public static Connection connection(String databaseName){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver version: " + org.postgresql.Driver.getVersion());
            c = DriverManager
                    .getConnection("jdbc:postgresql://digibank-dev.pgsql.ap-southeast-5.rds.aliyuncs.com:5432/"+databaseName,
            "admindev", "Psql_DB-DIgiB4nk_");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }



}
