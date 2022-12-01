package fr.triedge.core.utils;

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
}
