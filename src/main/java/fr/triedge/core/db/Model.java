package fr.triedge.core.db;

import fr.triedge.core.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

    public static User getUser(int id) throws SQLException {
        String sql = "select * from cg_user where id=?";
        PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        User user = null;
        while (res.next()){
            user = new User();
            user.setId(res.getInt("id"));
            user.setPseudo(res.getString("pseudo"));
            user.setEmail(res.getString("email"));
            user.setPassword(res.getString("password"));
        }
        return user;
    }
}
