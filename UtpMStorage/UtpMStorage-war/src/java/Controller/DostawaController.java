/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Dostawa;
import entity.Produkt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import service.CustomeProductFacade;
import service.DostawaFacade;
import service.ProduktFacade;

/**
 *
 * @author Olek
 */
@Named(value = "dostawaController")
@SessionScoped
public class DostawaController implements Serializable {

    @EJB
    private DostawaFacade dostawaFacade;

    @EJB
    private ProduktFacade produktFacade;

    @EJB
    private CustomeProductFacade customeProductFacade;

    private Dostawa selectedDostawa;

    //do edycji dostaw
    private List<Produkt> produktListTempDostawy = new ArrayList<Produkt>();
    private Boolean statusViewProdukt;
    private Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

    /**
     * Creates a new instance of DostawaController
     */
    public DostawaController() {
    }

    public CustomeProductFacade getCustomeProductFacade() {
        return customeProductFacade;
    }

    public void setCustomeProductFacade(CustomeProductFacade customeProductFacade) {
        this.customeProductFacade = customeProductFacade;
    }

    public ProduktFacade getProduktFacade() {
        return produktFacade;
    }

    public void setProduktFacade(ProduktFacade produktFacade) {
        this.produktFacade = produktFacade;
    }

    public Boolean getStatusViewProdukt() {
        return statusViewProdukt;
    }

    public void setStatusViewProdukt(Boolean statusViewProdukt) {
        this.statusViewProdukt = statusViewProdukt;
    }

    public DostawaFacade getDostawaFacade() {
        return dostawaFacade;
    }

    public Dostawa getSelectedDostawa() {
        return selectedDostawa;
    }

    public void setSelectedDostawa(Dostawa selectedDostawa) {
        this.selectedDostawa = selectedDostawa;
    }

    public void setDostawaFacade(DostawaFacade dostawaFacade) {
        this.dostawaFacade = dostawaFacade;
    }

    public List<Dostawa> findAll() {
        return this.dostawaFacade.findAll();
    }

    public List<Dostawa> findById(Integer did) {
        return this.dostawaFacade.findById(did);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Produkt> getProduktListTempDostawy() {
        return produktListTempDostawy;
    }

    public void setProduktListTempDostawy(List<Produkt> produktListTempDostawy) {
        this.produktListTempDostawy = produktListTempDostawy;
    }

    public List<Produkt> findAllProdukt() {
        return this.produktFacade.findAll();
    }

    public List<Produkt> findProduktByDostawa() {
        return this.customeProductFacade.findProduktByDostawa(data);
    }


    public void findProduktByDataDostawy(boolean statusView) {
        statusViewProdukt = statusView;
        if (statusView) {
            produktListTempDostawy = findAllProdukt();
        } else {

            produktListTempDostawy = findProduktByDostawa();
        }
    }

    public void onRowEdit(RowEditEvent event) {
        System.err.println("onRowEdit");

        Produkt tempProduktSave = (Produkt) event.getObject();
        produktFacade.edit(tempProduktSave);

        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Zmiany zostały naniesione!"));

//        FacesMessage msg = new FacesMessage("Car Edited", ((Produkt) event.getObject()).getMarka());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        System.err.println("onRowCancel");

        findProduktByDataDostawy(statusViewProdukt);
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat", "Zmiany zostały odrzucone!"));

//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Produkt) event.getObject()).getMarka());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
