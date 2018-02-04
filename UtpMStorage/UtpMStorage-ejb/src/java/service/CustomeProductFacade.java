/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Produkt;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 *
 * @author lukasz
 */
@Stateless
public class CustomeProductFacade {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Metoda przeszukuje baze w celu znalezienia produktów o podanym typie
     *
     * @param typ
     * @return
     */
    public List<Produkt> findByTyp(String typ) {
        return em.createNamedQuery("Produkt.findByTyp")
                .setParameter("typ", typ)
                .getResultList();
    }

    /**
     * Metoda przeszukuje baze w celu znalezienia produktów o podanej marce
     *
     * @param marka
     * @return
     */
    public List<Produkt> findByMarka(String marka) {
        return em.createNamedQuery("Produkt.findByMagazyn")
                .setParameter("marka", marka)
                .getResultList();
    }

    /**
     * Metoda przeszukuje baze w celu znalezienia produktów o podanym imeiu
     *
     * @param imei
     * @return
     */
    public List<Produkt> findByImei(String imei) {
        return em.createNamedQuery("Produkt.findByImei")
                .setParameter("imei", imei)
                .getResultList();
    }

    public List<Produkt> findByModel(String model) {
        return em.createNamedQuery("Produkt.findByModel")
                .setParameter("model", model)
                .getResultList();
    }

    public List<Produkt> findByStan(String stan) {
        return em.createNamedQuery("Produkt.findByStan")
                .setParameter("stan", stan)
                .getResultList();
    }

    public List<Produkt> findByMagazyn(String magazyn) {
        return em.createNamedQuery("Produkt.findByMagazyn")
                .setParameter("magazyn", magazyn)
                .getResultList();
    }

    public List<Produkt> findByModelAndMarka(String model, String marka) {
        return em.createQuery("SELECT p FROM Produkt p WHERE p.model=:model AND p.marka=:marka")
                .setParameter("marka", marka)
                .setParameter("model", model)
                .getResultList();
    }

    public List<Produkt> findTypes() {
        return em.createQuery("SELECT DISTINCT(p.typ) FROM Produkt p")
                .getResultList();
    }

    public List<Produkt> findMarki() {
        return em.createQuery("SELECT DISTINCT(p.marka) FROM Produkt p")
                .getResultList();
    }

    public List<Produkt> findModele() {
        return em.createQuery("SELECT DISTINCT(p.model) FROM Produkt p")
                .getResultList();
    }

    public List<Produkt> findMagazyny() {
        return em.createQuery("SELECT DISTINCT(p.magazyn.nazwa) FROM Produkt p")
                .getResultList();
    }
    public List<Produkt> findProduktByDostawa(Date data) {
        return em.createQuery("SELECT p FROM Produkt p JOIN p.dostawy d WHERE d.dataZamowienia = :data")
                .setParameter("data", data)
                .getResultList();
    }
    
    public List<Produkt> findProduktByStan(boolean b) {
        return em.createQuery("SELECT p FROM Produkt p WHERE p.stan = :b")
                .setParameter("b", b)
                .getResultList();
    }
    
    
    
}
