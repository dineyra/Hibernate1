package project.util;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import project.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД

    final static String URL_JDBC = "jdbc:mysql://localhost:3306/test?useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String USERNAME_JDBC = "root";
    final static String PASSWORD_JDBC = "root";


    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&allowMultiQueries=true&serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory = null;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL_JDBC, USERNAME_JDBC, PASSWORD_JDBC);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено");
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getHibernateConnection() {
        try {
            org.hibernate.cfg.Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", DRIVER)
                    .setProperty("hibernate.connection.url", URL_JDBC)
                    .setProperty("hibernate.connection.username", LOGIN)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                    .addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();


            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            // metadataSources.addAnnotatedClass(Player.class);
            Metadata metadata = metadataSources.buildMetadata();

            // here we build the SessionFactory (Hibernate 5.4)
            sessionFactory = metadata.getSessionFactoryBuilder().build();
//            Session session = sessionFactory.getCurrentSession();

//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }


}
