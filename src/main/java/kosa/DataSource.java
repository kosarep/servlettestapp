package kosa;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JF194405 on 23.06.2017.
 */
public class DataSource {
    //private HashMap<String,String> userSource;
    private QueryExecutor queryExecutor;

    public DataSource() {
        //userSource = new HashMap<String, String>();
        queryExecutor = new QueryExecutor();
    }
    /*
    public void register(String name, String password) {
        userSource.put(name, password);
    }
*/
    public boolean userExists(User user) {
        //String passwordFromSource = userSource.get(user.getName());
        List<String> passwordFromSource = queryExecutor.doSelectQuery("SELECT * FROM login_server.users WHERE name = '" + user.getName() + "';", "password");
        if (passwordFromSource.size() != 0) {
            return user.getPassword().equals(passwordFromSource.get(0));
        } else {
            return false;
        }
    }
/*
    private void generateTestData() {
        userSource.put("admin", "test");
        userSource.put("user", "passUser");
    }
*/
    public boolean nameExists(User user) {
        //return userSource.containsKey(user.getName());
        return queryExecutor.isPresent("SELECT name FROM login_server.users WHERE name = '" + user.getName() + "';");
    }

    public void createUser(User user) {
        //userSource.put(user.getName(), user.getPassword());
        queryExecutor.doInsertQuery("INSERT INTO login_server.users VALUES (NULL, '" + user.getName() + "', '" + user.getPassword() + "');");
    }
}
