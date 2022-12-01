package fr.triedge.core.controllers;

import fr.triedge.core.db.DB;
import fr.triedge.core.model.User;
import fr.triedge.core.utils.Utils;

import java.sql.SQLException;

public class InscriptionAction extends StrutsAction{

    private String strutsEmail, strutsPassword, strutsPseudo;

    @Override
    public String perform(String action) {
        if (action == null)
            return "inscriptionForm";
        if (action.equalsIgnoreCase("inscription")){
            if (strutsEmail == null || strutsPassword == null || strutsPseudo == null){
                return "welcome";
            }
            try {
                User u = DB.getInstance().registerUser(strutsEmail, strutsPassword, strutsPseudo, true);
                Utils.loginUser(u);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return SUCCESS;
    }

    public String getStrutsPseudo() {
        return strutsPseudo;
    }

    public void setStrutsPseudo(String strutsPseudo) {
        this.strutsPseudo = strutsPseudo;
    }

    public String getStrutsEmail() {
        return strutsEmail;
    }

    public void setStrutsEmail(String strutsEmail) {
        this.strutsEmail = strutsEmail;
    }

    public String getStrutsPassword() {
        return strutsPassword;
    }

    public void setStrutsPassword(String strutsPassword) {
        this.strutsPassword = strutsPassword;
    }
}
