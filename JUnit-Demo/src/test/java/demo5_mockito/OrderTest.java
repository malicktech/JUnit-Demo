package demo5_mockito;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import demo5_mockito.Order;
import demo5_mockito.Product;

public class OrderTest {

	/**
	 * test simple qui permet de vérifier la création d’une nouvelle commande
	 * avec deux nouveaux produits
	 * 
	 * @throws Exception
	 */
	@Test
	public void should_instantiate_an_order_with_2_products() throws Exception {

		// way 1 to instanciate mock : "mock()" static method
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		Order order = new Order(newArrayList(product1, product2));

		// hamcrest assert
		assertThat(product1, notNullValue());
		assertThat(product2, notNullValue());
		assertThat(order.products.size(), equalTo(2));

		// same junit assert
		assertNotNull("product 1 should not be null", product1);
		assertNotNull("product 1 should not be null", product2);
		assertEquals("size is not ok", order.products.size(), 2);

	}

	/**
	 * on peut aussi définir le comportement par défaut qu’aura notre Mock
	 * @throws Exception
	 */
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

	/**
	 * Test méthode getToalPrice
	 * simuler le comportement d’un produit pour qu’il retourne un prix concret
	 * @throws Exception
	 */
	@Test
	public void should_have_a_total_price_equal_to_8_99() throws Exception {
		Product product1 = mock(Product.class);
		Product product2 = mock(Product.class);
		when(product1.getPrice()).thenReturn(new BigDecimal("3.99"));
		//la valeur 5.00 sera renvoyée quand la méthode getPrice() sera appelée.
		when(product2.getPrice()).thenReturn(new BigDecimal("5.00"));
		Order order = new Order(newArrayList(product1, product2));
		assertThat(order.getTotalPrice(), equalTo(new BigDecimal("8.99")));

	}

	/**
	 * On peut aussi vouloir simuler le déclenchement d’une exception
	 * @throws Exception
	 */
	@Test(expected = IllegalStateException.class)
	public void should_throws_exception_when_calling_get_price() throws Exception {
		Product product1 = mock(Product.class);
		when(product1.getPrice()).thenThrow(new IllegalStateException());
		product1.getPrice();
	}

	
	/**
	 * test sur la méthode formatTotalPrice()
	 * 
	 * Utilisaton dde spy pour simuler la méthode  getTotalPrice()
	 * 
	 * @throws Exception
	 */
	@Test
	public void should_format_total_price_to_10_00_euros_string() throws Exception {
		Order order = spy(new Order(mock(List.class)));
		doReturn(BigDecimal.TEN).when(order).getTotalPrice();
		assertThat(order.formatTotalPrice(Locale.FRANCE), equalTo("10,00 €"));
		verify(order, times(1)).getTotalPrice();
	}
}
