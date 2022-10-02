package fr.triedge.core.controllers;

import com.opensymphony.xwork2.ActionContext;
import fr.triedge.core.db.DB;
import fr.triedge.core.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class IndexAction {

    private User user;
    private ArrayList<User> users;


    public String execute(){
        user = (User) ActionContext.getContext().getSession().get("user");
        try {
            users = DB.getInstance().getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "success";
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
