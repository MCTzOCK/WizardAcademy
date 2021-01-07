package de.mctzock.api.mysql;

import net.craftions.wizardacademy.tutorial.Tutorial;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.sql.*;

public class MySQL {

    protected static Connection con = null;

    public static void connect(){
        System.out.println("Trying to connect to MySQL Database...");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            File mysql_config = new File("conf/mysql.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(mysql_config);
            String connectionCommand = "jdbc:mysql://" + config.getString("host") + "/" + config.getString("database") + "?user=" + config.getString("user") + "&password=" + config.getString("password") + "&autoReconnect=true&useSSL=false";
            System.out.println("Using connection Command: " + connectionCommand);
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
