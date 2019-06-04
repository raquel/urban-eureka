package com.serverless.rds;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static StandardServiceRegistry registry;

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (null == sessionFactory) {
            try {
                registry = new StandardServiceRegistryBuilder()
//                        .configure( "hibernate.cfg.xml" )
                        .configure()
                        .build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {

                e.printStackTrace();

                if (registry != null) {

                    StandardServiceRegistryBuilder.destroy(registry);

                }

            }

        }

        return sessionFactory;

//            sessionFactory = new MetadataSources( standardRegistry )
//                    .buildMetadata()
//                    .buildSessionFactory();
//            return sessionFactory;
//        }
//
//        Configuration configuration = new Configuration();
//
//        String jdbcUrl = "jdbc:mysql://"
//                + System.getenv("RDS_HOSTNAME")
//                + "/"
//                + System.getenv("RDS_DB_NAME");
//
//        System.out.println(jdbcUrl);
//        System.out.println(System.getenv("RDS_USERNAME"));
//        System.out.println(System.getenv("RDS_PASSWORD"));
//
//        configuration.setProperty("hibernate.connection.url", jdbcUrl);
//        configuration.setProperty("hibernate.connection.username", System.getenv("RDS_USERNAME"));
//        configuration.setProperty("hibernate.connection.password", System.getenv("RDS_PASSWORD"));
//
//        configuration.configure();
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//        try {
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        } catch (HibernateException e) {
//            System.err.println("Initial SessionFactory creation failed." + e);
//            throw new ExceptionInInitializerError(e);
//        }
//        return sessionFactory;
    }


}