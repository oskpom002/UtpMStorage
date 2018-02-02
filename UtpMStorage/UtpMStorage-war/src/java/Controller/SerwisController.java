/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Klient;
import entity.Serwis;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import service.SerwisFacade;

/**
 *
 * @author Olek
 */
@Named(value = "serwisController")
@SessionScoped
public class SerwisController implements Serializable {

    @EJB
    private SerwisFacade serwisFacade;

    private Serwis serwis = new Serwis();

    /**
     * Creates a new instance of SerwisController
     */
    public SerwisController() {
    }

    public Serwis getSerwis() {
        return serwis;
    }

    public void setSerwis(Serwis serwis) {
        this.serwis = serwis;
    }

    public SerwisFacade getSerwisFacade() {
        return serwisFacade;
    }

    public void setSerwisFacade(SerwisFacade serwisFacade) {
        this.serwisFacade = serwisFacade;
    }

    public String dodajSerwis(Klient klient) {

        if (klient == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Wybierz klienta! ", "Wybierz klienta!"));
            return "";
        }
        
        serwis.setKlient(klient);
        serwis.setStatus("Przyjęto");
        serwis.setDataPrzyjecia(Date.from(Instant.now()));    
        
        
        serwisFacade.create(serwis);
        serwis= new Serwis();
        
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Urzadzenie zostało przyjęte na serwis!"));

            
        return "index";
    }
}
