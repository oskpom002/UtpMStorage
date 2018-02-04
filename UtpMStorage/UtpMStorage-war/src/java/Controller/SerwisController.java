/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Klient;
import entity.Serwis;
import entity.Sprzedaz;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import service.SerwisFacade;
import service.SprzedazFacade;

/**
 *
 * @author Olek
 */
@Named(value = "serwisController")
@SessionScoped
public class SerwisController implements Serializable {

    @EJB
    private SerwisFacade serwisFacade;

    @EJB
    private SprzedazFacade sprzedazFacade;

    private Serwis serwis = new Serwis();
    private Serwis selectedSerwis = new Serwis();
    private Sprzedaz sprzedaz = new Sprzedaz();
    private String infoTemp;
    private List<Serwis> serwisy = new ArrayList<Serwis>();
    private boolean showButtonNapraw;
    private boolean showButtonZwrocone;

    /**
     * Creates a new instance of SerwisController
     */
    public SerwisController() {
//        serwisy=findAll();
    }

    public Serwis getSelectedSerwis() {
        return selectedSerwis;
    }

    public void setSelectedSerwis(Serwis selectedSerwis) {
        this.selectedSerwis = selectedSerwis;
    }

    public boolean isShowButtonNapraw() {
        return showButtonNapraw;
    }

    public String getInfoTemp() {
        return infoTemp;
    }

    public void setInfoTemp(String infoTemp) {
        this.infoTemp = infoTemp;
    }

    public void setShowButtonNapraw(boolean showButtonNapraw) {
        this.showButtonNapraw = showButtonNapraw;
    }

    public Sprzedaz getSprzedaz() {
        return sprzedaz;
    }

    public SprzedazFacade getSprzedazFacade() {
        return sprzedazFacade;
    }

    public void setSprzedazFacade(SprzedazFacade sprzedazFacade) {
        this.sprzedazFacade = sprzedazFacade;
    }
    
    

    public void setSprzedaz(Sprzedaz sprzedaz) {
        this.sprzedaz = sprzedaz;
    }

    public Serwis getSerwis() {
        return serwis;
    }

    public List<Serwis> findAll() {
        return this.serwisFacade.findAll();
    }

    public void setSerwis(Serwis serwis) {
        this.serwis = serwis;
    }

    public boolean isShowButtonZwrocone() {
        return showButtonZwrocone;
    }

    public void setShowButtonZwrocone(boolean showButtonZwrocone) {
        this.showButtonZwrocone = showButtonZwrocone;
    }

    public List<Serwis> getSerwisy() {
        return serwisy;
    }

    public void setSerwisy(List<Serwis> serwisy) {
        this.serwisy = serwisy;
    }

    public SerwisFacade getSerwisFacade() {
        return serwisFacade;
    }

    public void setSerwisFacade(SerwisFacade serwisFacade) {
        this.serwisFacade = serwisFacade;
    }

    public void findProduktByStatus(String status) {
        serwisy = this.serwisFacade.findProduktByStatus(status);

        if (status.equals("Przyjęte")) {
            showButtonNapraw = true;
            showButtonZwrocone = false;

        } else if (status.equals("Naprawione")) {
            showButtonNapraw = false;
            showButtonZwrocone = true;
        } else if (status.equals("Zwrócone")) {
            showButtonNapraw = false;
            showButtonZwrocone = false;
        }

    }

    public String zwrot() {
        if (selectedSerwis == null) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Wybierz urządzenie! "));

            return "";
        } else {

            sprzedaz.setDataSprzedazy(Date.from(Instant.now()));

            selectedSerwis.setDataOddania(Date.from(Instant.now()));
            selectedSerwis.setStatus("Zwrócone");

            sprzedaz.setSerwis(selectedSerwis);
            sprzedaz.setKlient(selectedSerwis.getKlient());

            sprzedazFacade.create(sprzedaz);
            serwisFacade.edit(selectedSerwis);

            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Produkt zwrócono! "));
            return "index";
        }
    }

    public void showDialogNaprawa() {
        if (selectedSerwis == null) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Wybierz urządzenie! "));

        } else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('carDialog2').show()");
        }
    }

    public void showDialogZwrot() {
        if (selectedSerwis == null) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Wybierz urządzenie! "));

        } else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('carDialog3').show()");
        }
    }

    public String zapiszNaprawa() {

        selectedSerwis.setStatus("Naprawione");
        serwisFacade.edit(selectedSerwis);

        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Produkt jest gotowy do zwrotu! "));
        return "index";
    }

    public String dodajSerwis(Klient klient) {

        if (klient == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Wybierz klienta! ", "Wybierz klienta!"));
            return "";
        }

        serwis.setKlient(klient);
        serwis.setStatus("Przyjęte");

        serwis.setDataPrzyjecia(Date.from(Instant.now()));

        serwisFacade.create(serwis);
        serwis = new Serwis();

        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Urzadzenie zostało przyjęte na serwis!"));

        return "index";
    }
}
