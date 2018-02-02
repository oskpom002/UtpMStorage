package service;

import entity.Dostawa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olek
 */
@Stateless
public class DostawaFacade extends AbstractFacade<Dostawa> {

    @PersistenceContext(unitName = "UtpMStorage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DostawaFacade() {
        super(Dostawa.class);
    }

    public List<Dostawa> findById(Integer did) {
        return em.createQuery("SELECT d FROM Dostawa d WHERE d.did = did")
                .setParameter("did", did)
                .getResultList();
    }
}
