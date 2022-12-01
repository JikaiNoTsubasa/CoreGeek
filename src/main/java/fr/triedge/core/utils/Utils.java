package fr.triedge.core.utils;

import com.opensymphony.xwork2.ActionContext;
import fr.triedge.core.model.User;

public class Utils {

    public static boolean isPublic(String action){
        for (String ac : Config.getInstance().getPublicActions()){
            if (action.equals(ac)){
                return true;
            }
        }
        return false;
    }

    public static boolean canAccessAction(User user, String action){
        boolean pageIsPublic = isPublic(action);
        return (user != null && !pageIsPublic) || (user == null && pageIsPublic);
    }

    public static void loginUser(User user){
        ActionContext.getContext().getSession().put("user", user);
    }

    public static User getUser(){
        return (User) ActionContext.getContext().getSession().get("user");
    }
}
