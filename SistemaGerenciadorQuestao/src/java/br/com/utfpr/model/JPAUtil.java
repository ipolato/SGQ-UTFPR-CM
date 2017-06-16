package br.com.utfpr.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGQ");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void close(EntityManager em) {
        em.close();
    }
}
