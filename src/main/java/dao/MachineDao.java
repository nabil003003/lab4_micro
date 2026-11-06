package dao;

import entities.Machine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.List;

public class MachineDao implements IDao<Machine> {
    @Override public boolean create(Machine machine) { return persist(machine, "create"); }
    @Override public boolean delete(Machine machine) { return persist(machine, "delete"); }
    @Override public boolean update(Machine machine) { return persist(machine, "update"); }

    private boolean persist(Machine machine, String operation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if ("create".equals(operation)) session.save(machine);
            else if ("delete".equals(operation)) session.delete(machine);
            else session.update(machine);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
            exception.printStackTrace();
            return false;
        }
    }

    @Override public Machine getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) { return session.get(Machine.class, id); }
    }
    @Override public List<Machine> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Machine", Machine.class).list();
        }
    }
    public List<Machine> findByMarque(String marque) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Machine> query = session.createQuery("from Machine machine where machine.marque = :marque", Machine.class);
            query.setParameter("marque", marque);
            return query.list();
        }
    }
}
