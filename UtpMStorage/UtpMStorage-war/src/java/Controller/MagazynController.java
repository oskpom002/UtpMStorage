/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Magazyn;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import service.MagazynFacade;

/**
 *
 * @author Olek
 */
@Named(value = "magazynController")
@SessionScoped
public class MagazynController implements Serializable {

    @EJB
    private MagazynFacade magazynFacade;

    private Magazyn selectedMagazyn;

    //Do combobox przy wyborze magazynu
    private Integer magazynId;

    public MagazynController() {
    }

    public Integer getMagazynId() {
        return magazynId;
    }

    public void setMagazynId(Integer magazynId) {
        this.magazynId = magazynId;
    }

    public void setMagazynFacade(MagazynFacade magazynFacade) {
        this.magazynFacade = magazynFacade;
    }

    public Magazyn getSelectedMagazyn() {
        return selectedMagazyn;
    }

    public void setSelectedMagazyn(Magazyn selectedMagazyn) {
        this.selectedMagazyn = selectedMagazyn;
    }

    public List<Magazyn> findAll() {
        return this.magazynFacade.findAll();
    }

    public void addMagazyn() {
        magazynFacade.create(selectedMagazyn);
        
        selectedMagazyn=new Magazyn();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "Dodano magazyn!", "Dodano magazyn!"));


    }

}
