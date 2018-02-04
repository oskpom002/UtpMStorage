/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Magazyn;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukasz
 */
@Stateless
public class MagazynFacade extends AbstractFacade<Magazyn> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagazynFacade() {
        super(Magazyn.class);
    }

    public Magazyn findMagazynByMid(Integer mid) {
        return (Magazyn) em.createQuery("SELECT m FROM Magazyn m WHERE m.mid=:mid")
                .setParameter("mid", mid)
                .getSingleResult();

    }

}
