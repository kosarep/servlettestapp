package kosa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by JF194405 on 23.06.2017.
 */
public class QueryExecutor {
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/login_server";
    private final static String DBUSER = "root";
    private final static String DBPASS = "admin";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";

    private Connection connection;
    private Statement statement;

    public void doQuery(String query) {
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch(InstantiationException | IllegalAccessException |ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
