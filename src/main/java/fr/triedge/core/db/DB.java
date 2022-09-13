package fr.triedge.core.db;

import fr.triedge.core.utils.Config;
import fr.triedge.core.utils.PWDManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static DB instance;

    private Connection connection;

    private DB(){}

    public static DB getInstance(){
        if (instance == null)
            instance = new DB();
        return instance;
    }

    private Connection connectToDatabase() throws SQLException {
        String host = Config.getInstance().getProperty(Config.DB_HOST, Config.VALUE_DB_HOST);
        String name = Config.getInstance().getProperty(Config.DB_NAME, Config.VALUE_DB_NAME);
        String port = Config.getInstance().getProperty(Config.DB_PORT, Config.VALUE_DB_PORT);
        String user = Config.getInstance().getProperty(Config.DB_USER, Config.VALUE_DB_USER);
        String password = new PWDManager().decode(Config.getInstance().getProperty(Config.DB_PASSWORD,Config.VALUE_DB_PASSWORD));
        if (this.connection == null || this.connection.isClosed()){
            StringBuilder url = new StringBuilder();
            url.append("jdbc:postgresql://")
                    .append(host)
                    .append(":")
                    .append(port);
            url.append("/").append(name);
            this.connection = DriverManager.getConnection(url.toString(), user, password);
        }
        return this.connection;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null){
            connection = connectToDatabase();
        }
        return connection;
    }


}
