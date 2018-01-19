/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Dostawy;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukasz
 */
@Stateless
public class DostawyFacade extends AbstractFacade<Dostawy> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DostawyFacade() {
        super(Dostawy.class);
    }

    public List<Dostawy> findTypes() {
        return em.createQuery("SELECT DISTINCT(d.typ) FROM Dostawy d")
                .getResultList();
    }

    public List<Dostawy> findMarki() {
        return em.createQuery("SELECT DISTINCT(d.marka) FROM Dostawy d")
                .getResultList();
    }

    public List<Dostawy> findModele() {
        return em.createQuery("SELECT DISTINCT(d.model) FROM Dostawy d")
                .getResultList();
    }

    public List<Dostawy> findMagazyny() {
        return em.createQuery("SELECT DISTINCT(d.magazyn) FROM Dostawy d")
                .getResultList();
    }

    public List<Dostawy> findImei() {
        return em.createQuery("SELECT DISTINCT(d.imei) FROM Dostawy d")
                .getResultList();
    }

}
