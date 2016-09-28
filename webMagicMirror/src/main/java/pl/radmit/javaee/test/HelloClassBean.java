package pl.radmit.javaee.test;


import javax.faces.bean.ManagedBean;

/**
 * Created by rmorawski on 16.09.16.
 */
@ManagedBean(name = "helloClassBean2")
public class HelloClassBean {
    private String jakiesPole = "U mnie dizała";
    private String primeFacePole = "A tu pole primeFace!";

    public String getJakiesPole() {
        return jakiesPole;
    }

    public String getPrimeFacePole() {
        return primeFacePole;
    }
}
