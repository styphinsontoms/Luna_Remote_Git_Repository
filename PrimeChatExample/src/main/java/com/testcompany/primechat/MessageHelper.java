package com.testcompany.primechat;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;


@ApplicationScoped
public class MessageHelper implements Serializable {
    @Inject
    private FacesContext facesContext;

    public void addErrorMessage(String msg) {
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
    }
}
