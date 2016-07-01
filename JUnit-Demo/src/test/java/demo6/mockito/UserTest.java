package demo6.mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import demo0.gettingstarted.gs1.Address;

public class UserTest {

	/**
	 * l’initialisation dans la méthode setUp() Greffer Mockito sur la classe
	 * JUnit
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUserLogin1() throws Exception {
		User user = Mockito.mock(User.class);
		// System.out.println(user.getLogin()); // affiche null
		assertThat(user.getLogin(), nullValue());

		user.setLogin("bob");
		// System.out.println(user.getLogin()); // affiche encore null !
		assertThat(user.getLogin(), nullValue());

		Mockito.when(user.getLogin()).thenReturn("bob");
		// System.out.println(user.getLogin()); // affiche "bob"
		assertThat(user.getLogin(), equalTo("bob"));
		user.setLogin("drake");
		// System.out.println(user.getLogin()); // affiche toujours "bob"
		assertThat(user.getLogin(), equalTo("bob"));

	}

	/** on peut rétablir le comportement normal d’une méthode */

	@Test
	public void testUserLogin2() throws Exception {

		User user = Mockito.mock(User.class);

		// on rétablit le getLogin()
		Mockito.when(user.getLogin()).thenCallRealMethod();

		// affiche null mais cette fois car la variable login vaut vraiment null
		// dans le mock
		// System.out.println(user.getLogin());
		assertThat(user.getLogin(), nullValue());

		// on rétablit également le comportement de la méthode setLogin()
		Mockito.doCallRealMethod().when(user).setLogin(Mockito.anyString());

		user.setLogin("drake");
		// System.out.println(user.getLogin()); // affiche enfin "drake" !
		assertThat(user.getLogin(), is(equalTo("drake")));
	}

	/** stubbing d’un objet réel */
	@Test
	public void testUserLogin3() {

		/* stubber uniquement une partie de notre objet */

		User user = Mockito.spy(new User());
		Mockito.doReturn("drake").when(user).getLogin();

		user.setLogin("bob");

		// affiche "drake" mais la vraie valeur dans la classe User vaut bien
		// "bob"
		// System.out.println(user.getLogin());
		assertThat(user.getLogin(), is(equalTo("drake")));

		/* stubber une méthode void */
		// Mockito.doNothing().when(user).getLogin();
	}

	/** générer une exception lors d’un appel */
	@Test(expected = IllegalArgumentException.class)
	public void testUserLogin4() {
		User user = Mockito.spy(new User());
		Mockito.doThrow(new IllegalArgumentException()).when(user).setLogin(Mockito.eq("bad"));
		user.setLogin("bad");
	}

	/** Matchers | vérification */
	@Test
	public void testUserLogin5() {

		User obj = Mockito.mock(User.class);
		Address obj2 = new Address();

		obj.setAge(19);
		// vérifie que la méthode setAge a été appelée sur objUser, avec une int
		// strictement égale à 19
		Mockito.verify(obj).setAge(Mockito.eq(19));
		// note : ici, le matcher n'est pas indispensable, la ligne suivante est
		// équivalente :
		// Mockito.verify(obj).setAge(19);

		// vérifie que la méthode setAddress n'a jamais été appelée sur l'objet
		// obj
		Mockito.verify(obj, Mockito.never()).setAddress(obj2);
		Mockito.verify(obj, Mockito.never()).setAddress(new Address());
		// vérifie que la méthode setAddress a été appelée sur objUser, avec un
		// objet similaire à celui passé en argument "Addresse"
		obj.setAddress(obj2);
		Mockito.verify(obj).setAddress(Mockito.refEq(obj2));
		Mockito.verify(obj).setAddress(Mockito.refEq(new Address()));

		// vérifie que la méthode getAge a été appelée exactement 2 fois sur l'objet
		// obj
		 Mockito.when(obj.getAge()).thenReturn(19);
		assertThat(obj.getAge(), is(19));
		assertThat(obj.getAge(), is(equalTo(19)));
		Mockito.verify(obj, Mockito.times(2)).getAge();
		
		// idem avec un nombre minimum et maximum
		Mockito.verify(obj, Mockito.atLeast(1)).getAge();
		Mockito.verify(obj, Mockito.atMost(10)).getAge();

	}
	
	/** définir ses propres matchers */
	@Test
	public void testArgMatcher() {
		User obj = new User();
		obj.setBirthday(new Date(1990, 07, 16));
	    // valide que la date passée en argument de setDate est bien non nulle et postérieure à la date du jour
	    Mockito.verify(obj).setBirthday(Mockito.argThat(new MyDateMatcher()));
	    
	}
	
	private class MyDateMatcher extends ArgumentMatcher<Date> {
		 
	    @Override
	    public boolean matches(Object argument) {
	        Date d = (Date) argument;
	        return d != null && d.after(new Date());
	    }
	}
	
	/** valider qu’un enchaînement bien précis de méthodes a été réalisé sur un ou plusieurs objets : */
	@Test
	public void testInOrder() {
		User u1 = Mockito.mock(User.class);
		User u2 = Mockito.mock(User.class);
		 
		u1.setLogin("bob");
		u2.setLogin("drake");
		 
		// ajoute ces 2 mocks à l'ordre de vérification
		InOrder inOrder = Mockito.inOrder(u1, u2);
		 
		// en inversant ces instructions, le test va échouer
		inOrder.verify(u1).setLogin("bob");
		inOrder.verify(u2).setLogin("drake");		
	}
	
	/*
	@Test(expected = IllegalArgumentException.class)
	public void testArgMatcher2() {
		User obj = Mockito.mock(User.class);
		Mockito.doThrow(new IllegalArgumentException()).when(obj).setBirthday(Mockito.argThat(new MyDateMatcher()));
		obj.setBirthday(new Date());
	}
	*/
}
