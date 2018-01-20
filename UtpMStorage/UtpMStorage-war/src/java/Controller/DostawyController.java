/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import service.DostawyFacade;
import entity.*;
import java.util.ArrayList;
import java.util.Date;
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

    List<Dostawy> dostawylist = new ArrayList<Dostawy>();

    Dostawy dostawyTemp = new Dostawy();


    /**
     * Zwraca listę obiektów dostawy
     * @return 
     */
    public List<Dostawy> getDostawylist() {
        return dostawylist;
    }
    /**
     * Zwraca obiekt tymczasowy dostawy
     * @return 
     */
    public Dostawy getDostawyTemp() {
        return dostawyTemp;
    }

    /**
     * Zapisuje dane użytkownika do obiektu dostawy.
     * @param dostawyTemp 
     */
    public void setDostawyTemp(Dostawy dostawyTemp) {
        this.dostawyTemp = dostawyTemp;
    }
    
//    
//    public DostawyController() {
//    }
//
//    public List<Dostawy> findAll() {
//        return this.dostawyFacade.findAll();
//    }


    /**
     * Reakcja na przycisk "Dodaj"
     * Dodaje obiekt dostawy do listy.
     * @return 
     */
    public String add() {
        
        dostawyTemp.setStan(Boolean.TRUE);
        dostawylist.add(dostawyTemp);
            
        dostawyTemp = new Dostawy();
        
        return "dostawy";
    }
    
    /**
     * Reakcja na przycisk "Dodaj do bazy"
     * Dodaje listę obiektów dostawy do bazy danych.
     * @return 
     */
    public String addToDataBase()
    {
        
        for (Dostawy d: dostawylist)
        {
            this.dostawyFacade.create(d);
        }
  
        
        dostawylist = new ArrayList<Dostawy>();
        return "index";
    }
    

}
