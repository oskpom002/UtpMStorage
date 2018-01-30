/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import service.ProduktFacade;
import entity.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import service.CustomeProductFacade;
import service.DostawaFacade;

/**
 *
 * @author lukasz
 */
@Named(value = "produktController")
@SessionScoped
public class ProduktController implements Serializable {

    @EJB
    private ProduktFacade produktFacade;

    @EJB
    private CustomeProductFacade customeProductFacade;

    @EJB
    private DostawaFacade dostawaFacade;

    //Używane podczas zakupu
    private List<Produkt> selectedProdukty;
    private Produkt selectedProduct;

    //używane do zapisywania dostawy
    private Dostawa dostawaTemp = new Dostawa();
    private List<Produkt> produktListTemp = new ArrayList<Produkt>();
    private Produkt produktTemp = new Produkt();
    private Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
    private String ilosc;
    private String imei;
    private String magazyn;
    private String marka;
    private String model;
    private String typ;

    /**
     * Creates a new instance of ProduktController
     */
    public ProduktController() {
    }

    public List<Produkt> findAll() {
        return this.produktFacade.findAll();
    }

    public List<Produkt> findTypes() {
        return this.customeProductFacade.findTypes();
    }

    public List<Produkt> findMarki() {
        return this.customeProductFacade.findMarki();
    }

    public List<Produkt> findModele() {
        return this.customeProductFacade.findModele();
    }

    public List<Produkt> findMagazyny() {
        return this.customeProductFacade.findMagazyny();
    }

    public List<Produkt> find() {
        return (List<Produkt>) this.produktFacade.find(this);
    }

    /**
     * Reakcja na przycisk "Dodaj" Dodaje obiekt dostawy do listy.
     *
     * @return
     */
    public void add() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (ilosc.equals("") || ilosc.equals(null)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd", "Pole ilość nie może być puste"));

        } else if (magazyn.equals("") || magazyn.equals(null)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd", "Pole magazyn nie może być puste"));

        } else if (marka.equals("") || magazyn.equals(null)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd", "Pole marka nie może być puste"));
        } else if (model.equals("") || model.equals(null)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd", "Pole marka nie może być puste"));
        } else if (typ.equals("") || typ.equals(null)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Błąd", "Pole typ nie może być puste"));
        } else {
            produktTemp = new Produkt();
            produktTemp.setTyp(typ);
            produktTemp.setMagazyn(magazyn);
            produktTemp.setModel(model);
            produktTemp.setMarka(marka);
            produktTemp.setIlosc(Integer.valueOf(ilosc));
            if (!imei.equals(null) || imei.equals("")) {
                produktTemp.setImei(imei);
            }
            produktListTemp.add(produktTemp);
            typ = "";
            magazyn = "";
            model = "";
            imei = "";
            marka = "";
            ilosc = "";

            produktTemp = new Produkt();
        }

    }

    /**
     * Reakcja na przycisk "Dodaj do bazy" Dodaje listę obiektów dostawy do bazy
     * danych.
     *
     * @return
     */
    public void addToDataBase() {

        for (Produkt p : produktListTemp) {

            this.produktFacade.create(p);
        }

        dostawaTemp.setProdukty(produktListTemp);
        this.dostawaFacade.create(dostawaTemp);

        //Tworzenie nowych obiektów.
        dostawaTemp = new Dostawa();
        produktListTemp = new ArrayList<Produkt>();

    }

    public String getIlosc() {
        return ilosc;
    }

    public void setIlosc(String ilosc) {
        this.ilosc = ilosc;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(String magazyn) {
        this.magazyn = magazyn;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public ProduktFacade getProduktFacade() {
        return produktFacade;
    }

    public void setProduktFacade(ProduktFacade produktFacade) {
        this.produktFacade = produktFacade;
    }

    public DostawaFacade getDostawaFacade() {
        return dostawaFacade;
    }

    public void setDostawaFacade(DostawaFacade dostawaFacade) {
        this.dostawaFacade = dostawaFacade;
    }

    public Dostawa getDostawaTemp() {
        return dostawaTemp;
    }

    public void setDostawaTemp(Dostawa dostawaTemp) {
        this.dostawaTemp = dostawaTemp;
    }

    public CustomeProductFacade getCustomeProductFacade() {
        return customeProductFacade;
    }

    public void setCustomeProductFacade(CustomeProductFacade customeProductFacade) {
        this.customeProductFacade = customeProductFacade;
    }

    public List<Produkt> getProduktListTemp() {
        return produktListTemp;
    }

    public void setProduktListTemp(List<Produkt> produktListTemp) {
        this.produktListTemp = produktListTemp;
    }

    public Produkt getProduktTemp() {
        return produktTemp;
    }

    public void setProduktTemp(Produkt produktTemp) {
        this.produktTemp = produktTemp;
    }

    public Produkt getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Produkt selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Produkt> getSelectedProdukty() {
        return selectedProdukty;
    }

    public void setSelectedProdukty(List<Produkt> selectedProdukty) {
        this.selectedProdukty = selectedProdukty;
    }

    public List<Produkt> findProduktByDostawa() {
        return this.customeProductFacade.findProduktByDostawa(data);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String validationSelectSaleProduct() {

        if (selectedProdukty.size() < 1) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("Komunikat","Wybierz produkty, które chcesz sprzedać!"));
            return "";
        } else {
            return "sprzedaz";
        }

    }

}
