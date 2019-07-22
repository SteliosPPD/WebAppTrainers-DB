package dao;

import entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class TrainerDao {

    public void persist(Trainer tr) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        //create transtaction
        //begin.transaction
        em.getTransaction().begin();
        try {
            em.persist(tr);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }

    public boolean InsertTrainerJPA(Trainer tr) {

        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        //create transtaction
        //begin.transaction
        em.getTransaction().begin();
        try {
            em.persist(tr);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
        return completed;
    }

    public boolean DeleteTrainerJpaById(long tid) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();

        boolean completed = false;
        Trainer tr = em.find(entities.Trainer.class, tid);
        //em.remove(tr);
        em.getTransaction().begin();
        em.remove(tr);
        try {
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
        return completed;
    }

    public List<Trainer> SelectTrainersJPA() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("SELECT * FROM trainers",Trainer.class);
        @SuppressWarnings("unchecked")
        List<Trainer> resultList = (List<Trainer>) query.getResultList();
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return resultList;
    }
    
    public void updateTrainerTnameById(long tid, String tname){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        
        Trainer tr = em.find(Trainer.class, tid);
        tr.setTname(tname);
        em.getTransaction().begin();
        try {
            em.persist(tr);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }
    
    public void updateTrainerTlameById(long tid, String tlname){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        
        Trainer tr = em.find(Trainer.class, tid);
        tr.setTlname(tlname);
        em.getTransaction().begin();
        try {
            em.persist(tr);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }
    
    public void updateTrainerTsubjectById(long tid, String tsubject){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("WebAppTrainersPU");
        EntityManager em = emf.createEntityManager();
        
        Trainer tr = em.find(Trainer.class, tid);
        tr.setTsubject(tsubject);
        em.getTransaction().begin();
        try {
            em.persist(tr);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
            //end transtaction
        }
    }

}
