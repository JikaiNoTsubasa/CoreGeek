package fr.triedge.core.controllers;

import com.opensymphony.xwork2.ActionContext;
import fr.triedge.core.model.User;

public class IndexAction {

    public User user;

    public String execute(){
        user = (User) ActionContext.getContext().getSession().get("user");

        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
