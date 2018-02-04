/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Serwis;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olek
 */
@Stateless
public class SerwisFacade extends AbstractFacade<Serwis> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SerwisFacade() {
        super(Serwis.class);
    }
    
      public List<Serwis> findProduktByStatus(String status) {
        return em.createQuery("SELECT s FROM Serwis s WHERE s.status = :status")
                .setParameter("status", status)
                .getResultList();
    }
    
}
