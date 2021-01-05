package de.mctzock.api.mysql;

import java.sql.*;

public class MySQL {

    protected static Connection con = null;

    public static void connect(){
        System.out.println("Trying to connect to MySQL Database...");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionCommand = Config.Mysql.generateConnectCommand();
            con = DriverManager.getConnection(connectionCommand);
        }catch (Exception ex){
            System.err.println("Error connecting to MySQL Database!");
            ex.printStackTrace();
        }
    }

    public static void executeUpdate(String sql){
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql) {
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
