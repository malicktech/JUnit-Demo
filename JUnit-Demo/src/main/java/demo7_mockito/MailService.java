package demo7_mockito;

public class MailService {

	public void validateAndSend(final Mail mail) {
			if (this.validate(mail)) {
				this.send(mail);
			}
	}
	
	public void validateAndSendwithException(final Mail mail) {
		try {
			this.validateWithException(mail);
			this.send(mail);
		} catch (final MailValidationException e) {
			e.printStackTrace();
		}
	}

	public boolean validate(final Mail mail) {
		// Vérification
			return false;
	}
	
	public boolean validateWithException(final Mail mail) throws MailValidationException {
		// Vérification
		boolean result = false; 
		if(result) {
			return true;
		} else {
			throw new MailValidationException();
		}
	}

	public void send(final Mail mail) {
		// Envoi
	}
	
}
