/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Dostawa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import service.DostawaFacade;

/**
 *
 * @author Olek
 */
@Named(value = "dostawaController")
@SessionScoped
public class DostawaController implements Serializable{

    
    @EJB
    private DostawaFacade dostawaFacade;
    
        
    private Dostawa selectedDostawa;
    
   
    /**
     * Creates a new instance of DostawaController
     */
    public DostawaController() {
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

    public List<Dostawa> findById(Integer did){
       return this.dostawaFacade.findById(did);
    }
                
}
