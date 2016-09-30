package pl.radmit.javaee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by rmorawski on 29.09.16.
 */
@Entity
//@Table(name = "STUDENT")
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_SEQ")
    @SequenceGenerator(name = "PROD_SEQ", sequenceName = "PRODUCT3_SEQ", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    public Product(String name) {
//        this.id = id;
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
