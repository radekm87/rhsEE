package pl.radmit.javaee.rest.product.request;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by rmorawski on 13.09.16.
 */
@XmlRootElement
public class ProductPostRequest implements Serializable {

    private String productName;

    public ProductPostRequest() {
    }

    public ProductPostRequest(String productName) {
        this.productName = productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
