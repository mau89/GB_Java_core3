package auth;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {

    public Map<String, String> users = new HashMap<>();

    public AuthServiceImpl() {

        try {
            users=JdbcLogin_password.mapLoginPassword();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        users.put("1", "1");
//        users.put("2", "2");
//        users.put("3", "3");
    }

    @Override
    public boolean authUser(String username, String password) {
        String pwd = users.get(username);
        return pwd != null && pwd.equals(password);
    }
}