/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Sprzedaz;
import java.util.Date;
import java.util.List;
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SprzedazFacade() {
        super(Sprzedaz.class);
    }

    public List<Sprzedaz> findSprzedazByData(Date data) {
        return em.createQuery("SELECT s FROM Sprzedaz s WHERE s.dataSprzedazy = :data AND s.serwis=null")
                .setParameter("data", data)
                .getResultList();
    }

}
