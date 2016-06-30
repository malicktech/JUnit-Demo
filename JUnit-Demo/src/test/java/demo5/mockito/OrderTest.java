package demo5.mockito;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue; 
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;




/**
 * @author <a href="mailto:clardeur@xebia.fr">Clement Lardeur</a>
 */
public class OrderTest {

    @Test
    public void should_instantiate_an_order_with_2_products() throws Exception {
        
    	Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        Order order = new Order(newArrayList(product1, product2));
        
        // hamcrest assert
        // assertThat(product1, notNullValue());
        // assertThat(product2, notNullValue())
        // assertThat(order.products.size(), equalTo(2));
        
        // junit assert
        assertNotNull("product 1 should not be null", product1);
        assertNotNull("product 1 should not be null", product2);
        assertEquals("size is not ok", order.products.size(), 2);

    }

    @Test
    public void test_default_answer_mocking() throws Exception {
        Product product1 = mock(Product.class, RETURNS_DEFAULTS);
         assertThat(product1.getPrice(), nullValue());
         // assertNull("product 1 should be null", product1.getPrice());

        // product1.getPrice().abs() -> NPE

        Product product2 = mock(Product.class, RETURNS_SMART_NULLS);
        assertThat(product2.getPrice(), notNullValue());
        // assertNotNull("product 2 should not be null", product2);

        // product2.getPrice().abs() -> NPE

        Product product3 = mock(Product.class, RETURNS_MOCKS);
        assertThat(product3.getPrice(), notNullValue());
        assertThat(product3.getPrice().abs(), notNullValue());
        assertThat(product3.getPrice().getClass().getName(), containsString(BigDecimal.class.getName()));
    }

    @Test
    public void should_have_a_total_price_equal_to_8_99() throws Exception {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);
        when(product1.getPrice()).thenReturn(new BigDecimal("3.99"));
        when(product2.getPrice()).thenReturn(new BigDecimal("5.00"));
        Order order = new Order(newArrayList(product1, product2));
        assertThat(order.getTotalPrice(), equalTo(new BigDecimal("8.99")));

    }

    @Test(expected = IllegalStateException.class)
    public void should_throws_exception_when_calling_get_price() throws Exception {
        Product product1 = mock(Product.class);
        when(product1.getPrice()).thenThrow(new IllegalStateException());
        product1.getPrice();
    }

    @Test
    public void should_format_total_price_to_10_00_euros_string() throws Exception {
        Order order = spy(new Order(mock(List.class)));
        doReturn(BigDecimal.TEN).when(order).getTotalPrice();
        assertThat(order.formatTotalPrice(Locale.FRANCE), equalTo("10,00 €"));
        verify(order, times(1)).getTotalPrice();
    }
}
