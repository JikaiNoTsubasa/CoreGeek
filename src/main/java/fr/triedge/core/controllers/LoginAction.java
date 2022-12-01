package fr.triedge.core.controllers;

import com.opensymphony.xwork2.ActionContext;
import fr.triedge.core.db.DB;
import fr.triedge.core.model.User;

import java.sql.SQLException;

public class LoginAction extends StrutsAction{
    private String strutsLoginName;
    private String strutsLoginPassword;

    private String strutsAction;

    @Override
    public String perform(String action) {
        return SUCCESS;
    }

    public String processForm(){
        if (getStrutsAction() != null && getStrutsAction().equalsIgnoreCase("login")){
            try {
                User user = DB.getInstance().loginUser(getStrutsLoginName(), getStrutsLoginPassword(), true);
                if (user != null){
                    ActionContext.getContext().getSession().put("user", user);
                    //System.out.println("Login success");
                    return "success";
                }else{
                    System.out.println("Login failed");
                    return "askLogin";
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return "success";
    }

    public String getStrutsAction() {
        return strutsAction;
    }

    public void setStrutsAction(String strutsAction) {
        this.strutsAction = strutsAction;
    }

    public String getStrutsLoginName() {
        return strutsLoginName;
    }

    public void setStrutsLoginName(String strutsLoginName) {
        this.strutsLoginName = strutsLoginName;
    }

    public String getStrutsLoginPassword() {
        return strutsLoginPassword;
    }

    public void setStrutsLoginPassword(String strutsLoginPassword) {
        this.strutsLoginPassword = strutsLoginPassword;
    }
}
