package com.agilidee.livrejunit.calculatrice.MachineAEtats;

import org.easymock.EasyMock;

import static org.junit.Assert.*;
import org.junit.Test;

public class MachineAEtats_EasyMock_Test {
	@Test
	public void testAvecEasyMockOK() throws Exception {
		// Initialisation du bouchon
		Etat bouchon = EasyMock.createStrictMock(Etat.class);
		
		// DŽfinition des appels attendus
		EasyMock.expect(bouchon.appuieTouche('1')).andReturn(bouchon);
		EasyMock.expect(bouchon.lireAffichage()).andReturn("1");
		EasyMock.expect(bouchon.appuieTouche('2')).andReturn(bouchon);
		EasyMock.expect(bouchon.lireAffichage()).andReturn("12");
		
		// Passage en mode simulation
		EasyMock.replay(bouchon);
		 
		// DŽbut du test ˆ proprement parler
		MachineAEtats mae = new MachineAEtats(bouchon);
		mae.appuieTouche('1');
		assertEquals("1", mae.lireAffichage());
		mae.appuieTouche('2');
		assertEquals("12", mae.lireAffichage());
		
		// Validation finale du bouchon
		EasyMock.verify(bouchon);
	}
	    
	@Test
	public void testAvecEasyMockKO() throws Exception {
    	// Initialisation du bouchon
	   	Etat bouchon = EasyMock.createStrictMock(Etat.class);
    	
	   	// DŽfinition des appels attendus
	   	EasyMock.expect(bouchon.appuieTouche('1')).andReturn(bouchon);
	   	EasyMock.expect(bouchon.lireAffichage()).andReturn("1");
	   	EasyMock.expect(bouchon.appuieTouche('E')).andThrow(new Exception("testAvecEasyMockKO"));
    	
    	// Passage en mode simulation
	   	EasyMock.replay(bouchon);
 
    	// DŽbut du test ˆ proprement parler
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
