package fr.triedge.core.controllers;

import com.opensymphony.xwork2.ActionContext;
import com.sun.net.httpserver.Authenticator;
import fr.triedge.core.db.DB;
import fr.triedge.core.model.Message;
import fr.triedge.core.model.User;
import fr.triedge.core.utils.Utils;

import java.sql.SQLException;
import java.util.ArrayList;

public class IndexAction extends StrutsAction{

    private User user;
    private ArrayList<User> users;

    private ArrayList<Message> messages;

    @Override
    public String perform(String action) {
        System.out.println("Execute Index Action");
        user = Utils.getUser();
        if (user == null){
            System.out.println("User not logged, displaying welcome");
            return "welcome";
        }
        System.out.println("User logged, displaying index");
        try {
            users = DB.getInstance().getAllUsers();
            messages = DB.getInstance().getMessages(user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return SUCCESS;
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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
