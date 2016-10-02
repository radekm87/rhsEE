package pl.radmit.javaee.rest;

import pl.radmit.javaee.domain.ProductEntityManager;
import pl.radmit.javaee.rest.product.request.ProductPostRequest;
import pl.radmit.javaee.rest.product.response.ProductResultResponse;
import pl.radmit.javaee.rest.product.response.Todo;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rmorawski on 13.09.16.
 */
@Path("/hello")
@Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
@Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
public class RestServiceApplication {

    @PersistenceUnit(unitName = "example")
    private EntityManagerFactory entityManagerFactory;

//    @GET
//    @Path("/{param}")
//    public Response getMsg(@PathParam("param") String msg) {
//
//        String output = "Jersey say : " + msg;
//
//        return Response.status(200).entity(output).build();
//
//    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Todo> getXML() {
        ProductEntityManager productEntityManager = new ProductEntityManager();
        try {
            productEntityManager.addProduct(entityManagerFactory);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (javax.transaction.NotSupportedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }

        Todo todo = new Todo();
        todo.setSummary("This is my first todo");
        todo.setDescription("This is my first todo");

        Todo todo2 = new Todo();
        todo2.setSummary("This is my first todo2");
        todo2.setDescription("This is my first todo2");

        List<Todo> lista = new ArrayList<Todo>();
        lista.add(todo);
        lista.add(todo2);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/OracleDS");

            // This works too
            // Context envCtx = (Context) ctx.lookup("java:comp/env");
            // DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

            conn = ds.getConnection();

            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM product");

            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("name");

                sb.append("ID: " + id + ", First Name: " + firstName
                        + "<br/>");
                Todo todo1 = new Todo();
                todo1.setDescription(id.toString());
                todo1.setSummary(firstName);
                lista.add(todo1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    public ProductResultResponse addProduct(ProductPostRequest request) {
        ProductEntityManager productEntityManager = new ProductEntityManager();
//        productEntityManager.addProduct(entityManagerFactory);

        ProductResultResponse rr = new ProductResultResponse();
        rr.setId(1L);
        rr.setProductName(request.getProductName());
        return rr;

//        Todo todo = new Todo();
//        todo.setSummary("This is my first todo");
//        todo.setDescription("This is my first todo");
//        return todo;
    }
}
