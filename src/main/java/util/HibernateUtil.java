package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    private HibernateUtil() { }
    private static SessionFactory buildSessionFactory() {
        try { return new Configuration().configure().buildSessionFactory(); }
        catch (Throwable exception) {
            System.err.println("Échec de la création de la SessionFactory : " + exception);
            throw new ExceptionInInitializerError(exception);
        }
    }
    public static SessionFactory getSessionFactory() { return SESSION_FACTORY; }
}
