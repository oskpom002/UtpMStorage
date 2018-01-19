/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DostawyController;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import service.DostawyFacade;
import entity.*;
import java.util.List;

/**
 *
 * @author Olek
 */
@Named(value = "dostawyController")
@SessionScoped
public class DostawyController implements Serializable {


    @EJB
    private DostawyFacade dostawyFacade;

   
    Dostawy d = new Dostawy();

    public Dostawy getD() {
        return d;
    }

    public void setD(Dostawy d) {
        this.d = d;
    }

    public DostawyController() {
    }
    
    public List<Dostawy> findAll(){
        return this.dostawyFacade.findAll();
    }
    
    public List<Dostawy> findTypes() {
        return this.dostawyFacade.findTypes();
    }

    public List<Dostawy> findMarki() {
        return this.dostawyFacade.findMarki();
    }

    public List<Dostawy> findModele() {
        return this.dostawyFacade.findModele();
    }

    public List<Dostawy> findMagazyny() {
        return this.dostawyFacade.findMagazyny();
    }

    public List<Dostawy> findImei() {
        return this.dostawyFacade.findImei();
    }
    
    public String add() 
    {
        d.setStan(Boolean.TRUE);
        this.dostawyFacade.create(this.d);
        
        this.d = new Dostawy();
        return "index";
    }
    
}
