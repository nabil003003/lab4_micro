package dao;

import entities.Salle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class SalleDao implements IDao<Salle> {
    @Override public boolean create(Salle salle) { return persist(salle, "create"); }
    @Override public boolean delete(Salle salle) { return persist(salle, "delete"); }
    @Override public boolean update(Salle salle) { return persist(salle, "update"); }

    private boolean persist(Salle salle, String operation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if ("create".equals(operation)) session.save(salle);
            else if ("delete".equals(operation)) session.delete(salle);
            else session.update(salle);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override public Salle getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) { return session.get(Salle.class, id); }
    }
    @Override public List<Salle> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Salle", Salle.class).list();
        }
    }
}
