package demo7_mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MailServiceTest {

	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    
    /**
     * Simuler le comportement d’une méthode retournant une valeur
     *  simule les deux cas où le mail est validé ou non par la méthode de validation
     *  Ce test vérifie que la méthode d’envoi du mail est effectué ou non suivant que la validation a réussi ou non
     */
    @Test
    public void test_validation_ok() {
    	
        MailService mailService = new MailService();
        mailService = Mockito.spy(mailService);
        
        Mail mail = Mockito.mock(Mail.class);
        
        // indiquons dans un premier temps que cette méthode est mockée et qu’elle retourne une valeur en fonction du paramètre.
        //  indiquer la valeur retournée par cette méthode en fonction du paramètre.
        
        Mockito.doReturn(true).when(mailService).validate(mail);
        
        // stubber une méthode void : permettent d’indiquer à Mockito que ces méthodes n’effectue aucune action. 
        Mockito.doNothing().when(mailService).send(mail);
                
        
        // test
        mailService.validateAndSend(mail);
        
        // permettent de vérifier que ces méthodes ont bien été appelées.
        Mockito.verify(mailService).send(mail);
    }

    /**
     * Validation KO
     */
    @Test
	public void test_validation_ko() {
		MailService mailService = new MailService();
		mailService = Mockito.spy(mailService);

		final Mail mail = Mockito.mock(Mail.class);

		Mockito.doReturn(false).when(mailService).validate(mail);
		Mockito.doNothing().when(mailService).send(mail);

		// Test
		mailService.validateAndSend(mail);

		Mockito.verify(mailService, Mockito.never()).send(mail);
	}

    
    @Test(expected = MailValidationException.class)
	public void test_validation_exception()  throws Exception {
    	//MailService mailService = new MailService();
		//mailService = Mockito.spy(mailService);
		MailService mailService = Mockito.spy(new MailService());

		final Mail mail = Mockito.mock(Mail.class);
	
		Mockito.doThrow(new MailValidationException()).when(mailService).validateWithException(mail);
		Mockito.doNothing().when(mailService).send(mail);

		// Test
		mailService.validateAndSendwithException(mail);

		Mockito.verify(mailService, Mockito.never()).send(mail);
	}

    

	
}
