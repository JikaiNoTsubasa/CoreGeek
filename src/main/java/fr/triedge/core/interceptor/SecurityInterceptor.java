package fr.triedge.core.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import fr.triedge.core.model.User;

public class SecurityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation inv) throws Exception {
        User user = (User)inv.getInvocationContext().getSession().get("user");

        if (user == null && !inv.getInvocationContext().getActionName().equalsIgnoreCase("register")){
            System.out.println("User not authenticated");
            return "login";
        }
        //System.out.println("User already authenticated");

        return inv.invoke();
    }
}
