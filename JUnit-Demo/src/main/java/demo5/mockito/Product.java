package demo5.mockito;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:diop-malick@hotmail.fr">Malick</a>
 */
public class Product {

    private final BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price != null ? price : BigDecimal.ZERO;
    }

    public BigDecimal getPrice() throws Exception {
        return price;
    }
}
