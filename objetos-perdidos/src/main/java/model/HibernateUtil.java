package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	
	private static  SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
        try {
        	
        	
        	Configuration cfg = new Configuration()
            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
            .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
            .setProperty("hibernate.connection.url", "jdbc:mysql://db4free.net:3306/bd_objetos?zeroDateTimeBehavior=convertToNull")
            .setProperty("hibernate.connection.username", "vicgp91")
            .setProperty("hibernate.connection.password","123456")
             //.addClass(Usuarios.class).addClass(Reporte.class)
             .addAnnotatedClass(model.Usuarios.class).addAnnotatedClass(model.Reporte.class);
           //.addResource("model/Usuarios__.hbm.xml").addResource("model/Reporte__.hbm.xml");
        
             StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
             sessionFactory = cfg.buildSessionFactory(builder.build());
             

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
