package fr.triedge.core.controllers;

public abstract class StrutsAction {

    protected static final String SUCCESS = "success";
    private String strutsAction;

    public String execute(){
        return perform(getStrutsAction());
    }

    public abstract String perform(String action);

    public String getStrutsAction() {
        return strutsAction;
    }

    public void setStrutsAction(String strutsAction) {
        this.strutsAction = strutsAction;
    }
}
