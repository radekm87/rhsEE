package pl.radmit.javaee.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rmorawski on 29.09.16.
 */
public class ProductEntityManager {


    public void addProduct() {
//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("myPU");
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("statCreateTablesJTA");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Product prod = new Product("Testowy");

        entitymanager.persist(prod);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
    }

    public void getAllProducts() {
//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
//        EntityManager entitymanager = emfactory.createEntityManager();
//        Employee employee = entitymanager.find( Employee.class, 1201 );
//
//        System.out.println("employee ID = " + employee.getEid( ));
//        System.out.println("employee NAME = " + employee.getEname( ));
//        System.out.println("employee SALARY = " + employee.getSalary( ));
//        System.out.println("employee DESIGNATION = " + employee.getDeg( ));
    }
}
