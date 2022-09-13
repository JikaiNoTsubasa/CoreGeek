package fr.triedge.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config extends Properties {
    private static Config instance;
    public static Config getInstance(){
        if (instance == null)
            instance = new Config();
        return instance;
    }

    static{
        try {
            Config.getInstance().load(Config.class.getResourceAsStream("/application.properties"));
            System.out.println("Config loaded");
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("Could not load config"+ e.getMessage());
        }
    }

    public static final String DB_HOST                                  = "db.host";
    public static final String DB_USER                                  = "db.user";
    public static final String DB_PASSWORD                              = "db.password";
    public static final String DB_NAME                                  = "db.name";
    public static final String DB_PORT                                  = "db.port";
    public static final String APP_IMAGE_PATH                           = "app.image.path";

    public static final String VALUE_DB_HOST                                  = "localhost";
    public static final String VALUE_DB_USER                                  = "postgres";
    public static final String VALUE_DB_PASSWORD                              = "c2JpdXNlclM4OA==";
    public static final String VALUE_DB_NAME                                  = "coregeek";
    public static final String VALUE_DB_PORT                                  = "5432";
}
