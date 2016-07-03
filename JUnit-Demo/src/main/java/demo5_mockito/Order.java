package demo5_mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.text.NumberFormat.getCurrencyInstance;
import static org.apache.commons.lang.StringUtils.EMPTY;

public class Order {

    List<Product> products;

    public Order(List<Product> products) {
        this.products = products != null ? products : new ArrayList<Product>();
    }

    public BigDecimal getTotalPrice() throws Exception {
        BigDecimal total = BigDecimal.ZERO;
        for (Product product : products) {
            total = total.add(product.getPrice());
        }
        return total;
    }

    public String formatTotalPrice(Locale locale) {
        try {
            return getCurrencyInstance(locale).format(getTotalPrice());
        } catch (Exception e) {
            return EMPTY;
        }
    }
}
