package de.mctzock.api.mysql;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    public static String type = "_DEFAULT";

    public static class Mysql extends Config {

        protected static String type = "";

        public static String host = "";
        public static String name = "";
        public static String user = "";
        public static String pass = "";
        public static Boolean autoReconnect = true;

        public static void prepare(String h, String n, String u, String p){
            host = h;
            name = n;
            user = u;
            pass = p;
        }
        public static void setAutoReconnect(Boolean reconnect){
            autoReconnect = reconnect;
        }

        public static String generateConnectCommand(){
            return "jdbc:mysql://" + host + "/" + name + "?user=" + user + "&password=" + pass + "&autoReconnect=" + autoReconnect;
        }
    }

    public static void prepare(Config c){
        if(c.type == "_DEFAULT"){
            return;
        }else {
            if(c.type == "MYSQL"){
                File mysql_config = new File("conf/mysql.yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(mysql_config);
                Mysql.prepare(config.getString("host"), config.getString("database"), config.getString("user"), config.getString("password"));
                Mysql.setAutoReconnect(true);
            }
        }
    }
}
