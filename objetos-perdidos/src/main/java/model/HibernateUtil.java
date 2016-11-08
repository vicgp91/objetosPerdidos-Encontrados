package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static  SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
        try {
        	
        	 Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
             StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
             sessionFactory = configuration.buildSessionFactory(builder.build());
    
            return  sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
