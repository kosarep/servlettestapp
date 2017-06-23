package kosa;

//import javax.servlet.http.HttpServletResponse;

/**
 * Created by JF194405 on 23.06.2017.
 */


public class User {
    private String name;
    private String password;
    //private HttpServletResponse response;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
