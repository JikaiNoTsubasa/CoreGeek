package fr.triedge.core.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import fr.triedge.core.model.User;
import fr.triedge.core.utils.Utils;

public class SecurityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation inv) throws Exception {
        User user = (User)inv.getInvocationContext().getSession().get("user");
        String action = inv.getInvocationContext().getActionName();
        System.out.println("Accessing action: '"+action+"'");

        if (!Utils.canAccessAction(user, action)){
            System.out.println("User not authenticated and trying to access '"+action+"'");
            return "welcome";
        }
        //System.out.println("User already authenticated");

        return inv.invoke();
    }
}
