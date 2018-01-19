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
    private List<Produkt> selectedProdukty;

    private Produkt selectedProduct;

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

}
