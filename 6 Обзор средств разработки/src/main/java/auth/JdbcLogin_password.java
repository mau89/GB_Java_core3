package auth;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcLogin_password {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement updateLogin;


    public static Map<String, String> mapLoginPassword() throws ClassNotFoundException, SQLException {

        Map<String,String>stringStringMap=new HashMap<>();
        stringStringMap.put("","");
        try  {
            connection = DriverManager.getConnection("jdbc:sqlite:login_password.db");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from login_password");
            while (resultSet.next()){
                String login = resultSet.getString("Login");
                String password = resultSet.getString("Password");
                stringStringMap.put(login,password);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return stringStringMap;
    }

    public static void changeNickname(String nick,String username) throws ClassNotFoundException {

        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("", "");
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:login_password.db");
            updateLogin=connection.prepareStatement("UPDATE login_password SET Login=? WHERE login = ?");
            updateLogin.setString(1,nick);
            updateLogin.setString(2,username);
            System.out.println("Updated rows: " + updateLogin.executeUpdate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close() throws SQLException {
        connection.close();
    }

}
