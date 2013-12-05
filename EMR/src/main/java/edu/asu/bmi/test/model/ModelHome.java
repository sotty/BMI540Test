package edu.asu.bmi.test.model;

import edu.asu.bmi.test.model.impl.PatientImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;
import java.util.Collection;

public class ModelHome {

    private EntityManagerFactory emf;
    private EntityManager manager;
    private CriteriaBuilder cb;

    public ModelHome() {
        emf = Persistence.createEntityManagerFactory( "bmi540" );
        manager = emf.createEntityManager();
        cb = manager.getCriteriaBuilder();

        populateSampleData();
    }


    public <T> T get( Class<T> klass, Object id ) {
        return manager.find( klass, id );
    }

    public <T,K> Collection<K> getAll( Class<T> klass, Class<K> keyKlass, String keyProperty ) {
        CriteriaQuery<K> query = cb.createQuery( keyKlass );

        Root<T> source = query.from( klass );
        query.select( source.<K>get( keyProperty ) );

        return manager.createQuery( query ).getResultList();
    }

    public void persist( Object obj ) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist( obj );
        tx.commit();
    }

    public boolean delete( Object obj ) {
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        manager.remove( obj );
        tx.commit();

        return true;
    }




    // Prepare a clean DB with some data
    private void populateSampleData() {
        Patient p1 = ModelFactory.createPatient( "p-111", "johnDoe", 36 );
        Patient p2 = ModelFactory.createPatient( "p-222", "janeSmith", 84 );
        Patient p3 = ModelFactory.createPatient( "p-333", "alanFord", 11 );


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Patient oldP1 = em.find( p1.getClass(), p1.getMrn() );
        if ( oldP1 != null ) {
            em.remove( oldP1 );
        }
        Patient oldP2 = em.find( p2.getClass(), p2.getMrn() );
        if ( oldP2 != null ) {
            em.remove( oldP2 );
        }
        Patient oldP3 = em.find( p3.getClass(), p3.getMrn() );
        if ( oldP3 != null ) {
            em.remove( oldP3 );
        }

        em.getTransaction().commit();

        em.getTransaction().begin();

        em.persist( p1 );
        em.persist( p2 );
        em.persist( p3 );

        em.getTransaction().commit();
        em.close();

    }


    public void dispose() {
        manager.close();
        emf.close();
    }
}
