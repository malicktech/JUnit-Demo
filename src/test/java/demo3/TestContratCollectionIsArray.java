package demo3;

import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArray.array;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class TestContratCollectionIsArray {

	/*
	 * Le contrat "IsArray" vérifie que les éléments d'un tableau respecte un
	 * tableau de contrats (un contrat par élément). La javadoc de ce contrat
	 * est disponible ici.
	 * 
	 * Le contrat "IsArrayContaining" vérifie qu'un tableau contient au moins un
	 * élément qui respecte un contrat passé en paramètre ou qui est égal à une
	 * valeur passée en paramètre. La javadoc de ce contrat est disponible ici.
	 * 
	 * Le contrat "IsCollectionContaining" vérifie qu'une Collection contient
	 * des éléments qui respectent un ou des contrats passés en paramètres ou
	 * qui sont égaux à une valeur ou des valeurs passées en paramètres. La
	 * javadoc de ce contrat est disponible ici.
	 * 
	 * Le contrat "IsIn" vérifie qu'un objet est contenu dans une Collection, un
	 * tableau ou parmi les paramètres du contrat. La javadoc de ce contrat est
	 * disponible ici.
	 * 
	 * Le contrat "IsMapContaining" vérifie qu'une Map contient une entrée, une
	 * clé ou valeur qui respecte un contrat ou qui sont égaux à une valeur
	 * passée en paramètre. La javadoc de ce contrat est disponible
	 * 
	 */
	
	@Test
    public void elementsEgaux() {
        assertThat(new Integer[]{1, 2}, array(is(1), is(2)));
    }

    @Test
    public void elementsDifferents() {
        assertThat(new Integer[]{1, 2}, array(is(1), is(3)));
    }
}
