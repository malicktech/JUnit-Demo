package calculator.MachineAEtats;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MachineAEtats_Mockito_Test {
	
	// Initialisation du bouchon
	@Mock Etat bouchon;
	
	@Test
	public void testAvecMockitoOK() throws Exception {

		/* given */
		// Définition des comportements attendus
        
		/* when(bouchon.appuieTouche('1')).thenReturn(bouchon);
        when(bouchon.lireAffichage()).thenReturn("1");
		when(bouchon.appuieTouche('2')).thenReturn(bouchon);
		when(bouchon.lireAffichage()).thenReturn("12");
		 */
		
		
		/* when */ 
		//MachineAEtats mae = new MachineAEtats(bouchon);
		
		MachineAEtats mae = spy(new MachineAEtats(mock(Etat.class)));
		mae.appuieTouche('1');
		doReturn("1").when(mae).lireAffichage();
		assertEquals("1", mae.lireAffichage());

		mae.appuieTouche('2');
		doReturn("12").when(mae).lireAffichage();
		assertEquals("12", mae.lireAffichage());

		// then
		/*
		mae.appuieTouche('1');
		assertEquals("1", mae.lireAffichage());
		mae.appuieTouche('2');
		assertEquals("12", mae.lireAffichage());
		*/
	}
	    
	@Ignore
	@Test
	public void testAvecMockitoKO() throws Exception {
    	// Initialisation du bouchon
	   	Etat bouchon = EasyMock.createStrictMock(Etat.class);
    	
	   	// D�finition des appels attendus
	   	EasyMock.expect(bouchon.appuieTouche('1')).andReturn(bouchon);
	   	EasyMock.expect(bouchon.lireAffichage()).andReturn("1");
	   	EasyMock.expect(bouchon.appuieTouche('E')).andThrow(new Exception("testAvecEasyMockKO"));
    	
    	// Passage en mode simulation
	   	EasyMock.replay(bouchon);
 
    	// D�but du test � proprement parler
		MachineAEtats mae = new MachineAEtats(bouchon);
    	
    	mae.appuieTouche('1');
		assertEquals("1", mae.lireAffichage());
    	mae.appuieTouche('E');
		assertEquals("ERREUR", mae.lireAffichage());
    	mae.appuieTouche('2');
		assertEquals("ERREUR", mae.lireAffichage());    	
   		
		// Validation finale du bouchon
		EasyMock.verify(bouchon);
	}
}
