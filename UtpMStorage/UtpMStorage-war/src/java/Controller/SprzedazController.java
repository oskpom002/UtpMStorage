/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Klient;
import entity.Produkt;
import entity.Sprzedaz;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import service.KlientFacade;
import service.ProduktFacade;
import service.SprzedazFacade;

/**
 *
 * @author Olek
 */
@Named(value = "sprzedazController")
@SessionScoped
public class SprzedazController implements Serializable {

    @EJB
    private KlientFacade klientFacade;

    @EJB
    private ProduktFacade produktFacade;

    @EJB
    private SprzedazFacade sprzedazFacade;

    private Map<Produkt, String> quantities = new HashMap<>();

    private Sprzedaz sprzedaz;

    private List<Sprzedaz> sprzedazs = new ArrayList<Sprzedaz>();

    private List<Sprzedaz> datasprzedazs = new ArrayList<Sprzedaz>();

    private Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

    public Map<Produkt, String> getQuantities() {
        return quantities;
    }

    public String sprzedaz(Klient klient, List<Produkt> selectedProdukty, Boolean b) {

        if (b) {

            if (klient == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, "Wybierz klienta!", "Wybierz klienta!"));
                return "";
            }
        }

        for (Produkt produkt : selectedProdukty) {
            String quantity = quantities.get(produkt);
            //System.out.println("Quantity: " + quantity);          

            sprzedaz = new Sprzedaz();
            if (b) {
                sprzedaz.setKlient(klient);
            }

            sprzedaz.setProdukt(produkt);
            sprzedaz.setCena(quantity);

            sprzedaz.setDataSprzedazy(Date.from(Instant.now()));

            sprzedazFacade.create(sprzedaz);

            int ilosc = produkt.getAktualnailosc() - 1;
            if (ilosc <= 0) {
                produkt.setAktualnailosc(0);
                produkt.setStan(Boolean.FALSE);
            } else {
                produkt.setAktualnailosc(ilosc);
            }

            produktFacade.edit(produkt);
        }

        if (b) {
            klient.setSprzedaze(sprzedazs);
            klientFacade.edit(klient);
        }
        sprzedazs = new ArrayList<Sprzedaz>();
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Sprzedaż zakończona! "));
        return "index";
    }

    public void setQuantities(Map<Produkt, String> quantities) {
        this.quantities = quantities;
    }

    public SprzedazController() {
    }

    public KlientFacade getKlientFacade() {
        return klientFacade;
    }

    public void setKlientFacade(KlientFacade klientFacade) {
        this.klientFacade = klientFacade;
    }

    public List<Sprzedaz> getDatasprzedazs() {
        return datasprzedazs;
    }

    public void setDatasprzedazs(List<Sprzedaz> datasprzedazs) {
        this.datasprzedazs = datasprzedazs;
    }


    public List<Sprzedaz> findAll() {
        return this.sprzedazFacade.findAll();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Sprzedaz> findSprzedazByData() {
        return this.sprzedazFacade.findSprzedazByData(data);
    }

    public void findSprzedazByDataAll(boolean statusView) {

        if (statusView) {
            datasprzedazs = findAll();
        } else {
            datasprzedazs = findSprzedazByData();
        }
    }

}
