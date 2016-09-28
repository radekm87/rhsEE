package pl.radmit.javaee.rest.product.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rmorawski on 13.09.16.
 */
@XmlRootElement
public class ProductResultResponse {
    /**
     * @description Identyfikator konferencji
     */
    private Long id;

    /**
     * @description Nazwa konferencji
     */
    private String productName;

//    public ProductResultResponse(Long id, String productName) {
//        this.id = id;
//        this.productName = productName;
//    }
//
//    public ProductResultResponse() {
//    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
