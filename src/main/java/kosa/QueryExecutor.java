package kosa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JF194405 on 23.06.2017.
 */
public class QueryExecutor {
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/login_server";
    private final static String DBUSER = "root";
    private final static String DBPASS = "admin";
    private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection connection;
    private Statement statement;

    public void doInsertQuery(String query) {
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

    public boolean isPresent(String query) {
        boolean isOrNo = true;
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            isOrNo = statement.executeQuery(query).first();
            statement.close();
            connection.close();
        } catch(InstantiationException | IllegalAccessException |ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isOrNo;
    }

    public List<String> doSelectQuery(String query, String columnName) {
        List<String> results = new ArrayList<>();
        try {
            Class.forName(DBDRIVER).newInstance();
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                results.add(resultSet.getString(columnName));
            }
            statement.close();
            connection.close();
        } catch(InstantiationException | IllegalAccessException |ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
