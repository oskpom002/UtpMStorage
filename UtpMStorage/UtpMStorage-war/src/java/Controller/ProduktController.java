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

    private Dostawa dostawaTemp = new Dostawa();

    //Używane podczas zakupu
    private List<Produkt> selectedProdukty;
    private Produkt selectedProduct;

    //używane do zapisywania dostawy
    private List<Produkt> produktListTemp = new ArrayList<Produkt>();
    private Produkt produktTemp = new Produkt();

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

    /**
     * Reakcja na przycisk "Dodaj" Dodaje obiekt dostawy do listy.
     *
     * @return
     */
    public String add() {

      
        produktTemp.setStan(Boolean.TRUE);
        produktListTemp.add(produktTemp);

        produktTemp = new Produkt();
        return "dostawy";
    }

    /**
     * Reakcja na przycisk "Dodaj do bazy" Dodaje listę obiektów dostawy do bazy
     * danych.
     *
     * @return
     */
    public String addToDataBase() {

        for (Produkt p : produktListTemp) {

            this.produktFacade.create(p);
        }

        dostawaTemp.setProdukty(produktListTemp);
        this.dostawaFacade.create(dostawaTemp);

        dostawaTemp = new Dostawa();
        produktListTemp = new ArrayList<Produkt>();

        return "index";
    }

}
