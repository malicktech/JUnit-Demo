package demo3;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;


import org.junit.Test;

public class TestContratBean {

	@Test
	public void beanSansPropriete() {
		assertThat(new BeanSansPropriete(), hasProperty("prop"));
	}

	@Test
	public void beanAvecPropriete() {
		assertThat(new BeanAvecPropriete(), hasProperty("prop"));
	}

	@Test
	public void beanAvecBonneValeur() {
		final BeanAvecPropriete lBean = new BeanAvecPropriete();
		lBean.setProp(10);
		assertThat(lBean, hasProperty("prop", equalTo(10)));
	}

	@Test
	public void beanAvecMauvaiseValeur() {
		final BeanAvecPropriete lBean = new BeanAvecPropriete();
		assertThat(lBean, hasProperty("prop", equalTo(10)));
	}
}
