package calculator.IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    private Vue cVue;
    private Modele cModele;

    public Controleur(Vue pVue, Modele pModele) {
        cVue = pVue;
        cModele = pModele;

        pVue.ajouteEcouteur(this);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        cModele.appuieTouche(b.getText().charAt(0));
        cVue.afficher(cModele.lireAffichage());
    }
}


