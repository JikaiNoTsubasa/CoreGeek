package fr.triedge.core.db;

import fr.triedge.core.model.User;
import fr.triedge.core.utils.Config;
import fr.triedge.core.utils.PWDManager;

import java.sql.*;

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
            try {
                StringBuilder url = new StringBuilder();
                url.append("jdbc:mysql://")
                        .append(host)
                        .append(":")
                        .append(port);
                url.append("/").append(name);
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url.toString(),user,password);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return this.connection;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null){
            connection = connectToDatabase();
        }
        return connection;
    }

    public User loginUser(String name, String password, boolean isEncrypted) throws SQLException {
        if (name == null || password == null)
            return null;
        String pwd = password;
        if (isEncrypted)
            pwd = new PWDManager().encode(password);
        String sql = "select * from cg_user where email=? and password=?";
        User user = null;
        PreparedStatement stmt = getConnection().prepareStatement(sql);
        stmt.setString((int)1, name);
        stmt.setString((int)2, pwd);
        ResultSet res = stmt.executeQuery();
        while (res.next()){
            user = new User();
            user.setPseudo(res.getString("pseudo"));
            user.setEmail(res.getString("email"));
            user.setId(res.getInt("id"));
            user.setDescription(res.getString("description"));
        }
        res.close();
        stmt.close();

        return user;
    }
}
