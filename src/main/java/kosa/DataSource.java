package kosa;

import java.util.HashMap;

/**
 * Created by JF194405 on 23.06.2017.
 */
public class DataSource {
    private HashMap<String,String> userSource;
    private QueryExecutor queryExecutor;

    public DataSource() {
        userSource = new HashMap<String, String>();
        generateTestData();
    }

    public void register(String name, String password) {
        userSource.put(name, password);
    }

    public boolean userExists(User user) {
        String passwordFromSource = userSource.get(user.getName());
        if (passwordFromSource != null) {
            return user.getPassword().equals(passwordFromSource);
        } else {
            return false;
        }
    }

    private void generateTestData() {
        userSource.put("admin", "test");
        userSource.put("user", "passUser");
        queryExecutor = new QueryExecutor();
        queryExecutor.doQuery("INSERT INTO login_server.users VALUES (NULL, 'elo', 'admin');");
    }

    public boolean nameExists(User user) {
        return userSource.containsKey(user.getName());
    }

    public void createUser(User user) {
        userSource.put(user.getName(), user.getPassword());
    }
}
