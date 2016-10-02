package pl.radmit.javaee.domain;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.*;


/**
 * Created by rmorawski on 29.09.16.
 */
public class ProductEntityManager {

//    @PersistenceContext(unitName = "example")
//    private EntityManager em;

    public void addProduct(EntityManagerFactory emfactory) throws NamingException, SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

//        Server server = (Server) SessionManager.getManager().getSession("session");
//        Session session = (Session) server.acquireClientSession();
//        UnitOfWork uow = session.acquireUnitOfWork();


//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("myPU");
        emfactory = Persistence.createEntityManagerFactory("example");

        EntityManager entitymanager = emfactory.createEntityManager();
//        entitymanager.getTransaction().begin();

        UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        transaction.begin();
        Product prod = new Product("Testowy");

        entitymanager.joinTransaction();
        entitymanager.persist(prod);
        entitymanager.flush();
//        entitymanager.getTransaction().commit();

        transaction.commit();

        entitymanager.close();
//        emfactory.close();

//        em.persist(prod);
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
