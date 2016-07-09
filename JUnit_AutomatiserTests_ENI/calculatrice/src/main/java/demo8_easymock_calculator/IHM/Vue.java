package demo8_easymock_calculator.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Vue extends JFrame {

	private static final long serialVersionUID = 7407559771362912013L;
	private ArrayList<JButton> listeDeBoutons = new ArrayList<JButton>();
    private JLabel afficheur;

    protected void addButton(String label, JPanel clavier) {
        JButton button = new JButton(label);
        listeDeBoutons.add(button);
        clavier.add(button);
    }
    public Vue() {
        super("Calculatrice");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        afficheur = new JLabel("0", SwingConstants.RIGHT);
        afficheur.setBackground(Color.WHITE);
        afficheur.setOpaque(true);

        JPanel clavier = new JPanel();
        clavier.setLayout(new GridLayout(5, 4, 2 ,2));

        addButton("1", clavier);
        addButton("2", clavier);
        addButton("3", clavier);
        addButton("+", clavier);
        addButton("4", clavier);
        addButton("5", clavier);
        addButton("6", clavier);
        addButton("-", clavier);
        addButton("7", clavier);
        addButton("8", clavier);
        addButton("9", clavier);
        addButton("*", clavier);
        addButton("G", clavier);
        addButton("P", clavier);                   
        addButton("0", clavier);
        addButton("/", clavier);
        addButton("=", clavier);
 
        getContentPane().add(afficheur, BorderLayout.NORTH);
        getContentPane().add(clavier, BorderLayout.SOUTH);
    }

    public void ajouteEcouteur(ActionListener ecouteur) {
         for (JButton b : listeDeBoutons) {
            b.addActionListener(ecouteur);
        }
    }
    public void afficher(String ligne) {
        afficheur.setText(ligne);
    }
}
