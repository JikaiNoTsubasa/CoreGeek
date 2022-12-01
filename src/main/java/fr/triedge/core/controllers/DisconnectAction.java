package fr.triedge.core.controllers;

import com.opensymphony.xwork2.ActionContext;

public class DisconnectAction extends StrutsAction{
    @Override
    public String perform(String action) {
        ActionContext.getContext().getSession().put("user", null);
        return SUCCESS;
    }
}
