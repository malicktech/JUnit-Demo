package demo5_mockito;

import java.math.BigDecimal;


public class Product {

    private BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price != null ? price : BigDecimal.ZERO;
    }

    public BigDecimal getPrice() throws Exception {
        return price;
    }
    
    public void setPrice(BigDecimal price) throws Exception {
        this.price = price != null ? price : BigDecimal.ZERO;
    }
    
}
