/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Klient;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import service.KlientFacade;

/**
 *
 * @author Olek
 */
@Named(value = "klientController")
@SessionScoped
public class KlientController implements Serializable {

    @EJB
    private KlientFacade klientFacade;

    private Klient klientTemp = new Klient();
    private Klient selectedKlient;

    public KlientController() {
    }

    public void setSelectedKlient(Klient selectedKlient) {
        this.selectedKlient = selectedKlient;
    }

    public KlientFacade getKlientFacade() {
        return klientFacade;
    }

    public void setKlientFacade(KlientFacade klientFacade) {
        this.klientFacade = klientFacade;
    }

    public Klient getKlientTemp() {
        return klientTemp;
    }

    public void setKlientTemp(Klient klientTemp) {
        this.klientTemp = klientTemp;
    }

    public void addKlient() {
        this.klientFacade.create(klientTemp);
        klientTemp = new Klient();

        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Dodano klienta! ", "Dodano klienta!"));
    }

    public List<Klient> findAll() {
        return this.klientFacade.findAll();
    }

    public Klient getSelectedKlient() {
        return selectedKlient;
    }

}
