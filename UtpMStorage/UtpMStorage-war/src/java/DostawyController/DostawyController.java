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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Olek
 */
@Named(value = "dostawyController")
@SessionScoped
public class DostawyController implements Serializable {


    @EJB
    private DostawyFacade dostawyFacade;

    
    String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
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
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.GERMAN);
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(DostawyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        d.setDataZamowienia(date);
        this.dostawyFacade.create(this.d);
        return "index";
    }
    
}
