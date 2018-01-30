/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Sprzedaz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olek
 */
@Stateless
public class SprzedazFacade extends AbstractFacade<Sprzedaz> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;
    
    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SprzedazFacade() {
        super(Sprzedaz.class);
    }
    
}
