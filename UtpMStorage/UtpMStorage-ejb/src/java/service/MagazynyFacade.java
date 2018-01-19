/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Magazyny;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukasz
 */
@Stateless
public class MagazynyFacade extends AbstractFacade<Magazyny> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagazynyFacade() {
        super(Magazyny.class);
    }
    
}
