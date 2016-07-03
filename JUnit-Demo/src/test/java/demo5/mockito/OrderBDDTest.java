package demo5.mockito;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderBDDTest {

	// way 1 to instanciate mock : annotation @Mock
    @Mock Product product1;
    @Mock Product product2;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void should_have_a_total_price_equal_to_8_99() throws Exception {
        Order order = new Order(newArrayList(product1, product2));
        // given
        given(product1.getPrice()).willReturn(new BigDecimal("3.99"));
        given(product2.getPrice()).willReturn(new BigDecimal("5.00"));
        // when
        BigDecimal totalPrice = order.getTotalPrice();
        // then
        assertThat(totalPrice, equalTo(new BigDecimal("8.99")));
    }

    @Test
    public void should_format_total_price_to_10_00_euros_string() throws Exception {
        Order order = spy(new Order(null));
        // given
        given(order.getTotalPrice()).willReturn(BigDecimal.TEN);
        // when
        String price = order.formatTotalPrice(Locale.FRANCE);
        // then
        assertThat(price, equalTo("10,00 €"));
    }
}
