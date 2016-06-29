import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConnecteurEmailTest {
    public class CompteEmail {
        private String email;
        private String motdepasse;
        private String serveursmtp;
        private String serveurpop;

        public CompteEmail(String email, String motdepasse, String serveursmtp, String serveurpop) {
            this.email = email;
            this.motdepasse = motdepasse;
            this.serveursmtp = serveursmtp;
            this.serveurpop = serveurpop;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMotdepasse() {
            return motdepasse;
        }

        public void setMotdepasse(String motdepasse) {
            this.motdepasse = motdepasse;
        }

        public String getServeursmtp() {
            return serveursmtp;
        }

        public void setServeursmtp(String serveursmtp) {
            this.serveursmtp = serveursmtp;
        }

        public String getServeurpop() {
            return serveurpop;
        }

        public void setServeurpop(String serveurpop) {
            this.serveurpop = serveurpop;
        }
    }
    
    public class Email {
        public String expediteur;
        public String sujet;
        public String corps;
        public List<String> destinataires;
        public void ajouterDestinataire(String d) {
        }

        public String getExpediteur() {
            return expediteur;
        }

        public void setExpediteur(String expediteur) {
            this.expediteur = expediteur;
        }

        public String getSujet() {
            return sujet;
        }

        public void setSujet(String sujet) {
            this.sujet = sujet;
        }

        public String getCorps() {
            return corps;
        }

        public void setCorps(String corps) {
            this.corps = corps;
        }

        public List<String> getDestinataires() {
            return destinataires;
        }

        public void setDestinataires(List<String> destinataires) {
            this.destinataires = destinataires;
        }
    }
    public class ConnecteurEmail {
        public ConnecteurEmail(CompteEmail compte) {

        }
        public void envoyerEmail(Email email){

        }
        public List<Email> recupereEmails() {
            return null;
        }
        public void viderBoite() {
            // Vide la boite de réception & d'envoi
        }
    }

    private String recupereDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void testEnvoiEmail() throws Exception {
        CompteEmail expediteur = new CompteEmail("test1@agilidee.com",
                                                    "toto1", 
                                                    "smtp.agilidee.com",
                                                    "pop.agilidee.com");
        CompteEmail destinataire = new CompteEmail("test2@agilidee.com",
                                                    "toto2",
                                                    "smtp.agilidee.com",
                                                    "pop.agilidee.com");

        ConnecteurEmail envoi = new ConnecteurEmail(expediteur);
        ConnecteurEmail reception = new ConnecteurEmail(destinataire);

        Email email = new Email();
        email.setExpediteur(expediteur.getEmail());
        email.setSujet("Sujet: "+recupereDate());
        email.setCorps("Corps de texte:"+recupereDate());
        email.ajouterDestinataire(destinataire.getEmail());

        envoi.envoyerEmail(email);

        // Patiente 5s pour laisse le temps à l'email d'arriver
        Thread.currentThread().sleep(5000);
        
        List<Email> liste = reception.recupereEmails();

        // Charge utile de test vérifiant le dernier email reçu
        assertEquals(email, liste.get(0));

        // Nettoyage des boites pour ne pas les saturer
        envoi.viderBoite();
        reception.viderBoite();
    }
}
