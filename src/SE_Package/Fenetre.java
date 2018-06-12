package SE_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by tgrdt on 12/06/2018.
 */
public class Fenetre extends JFrame {

    // Historique systeme expert
    ArrayList<String> historique = new ArrayList<>();

    private JButton btnResultat = new JButton("Analyser le polygone");
    private JPanel container = new JPanel();
    private JComboBox comboNbCote = new JComboBox();
    private JLabel labelNbCote = new JLabel("Nombre de cotes : ");

    private JComboBox comboNbADroit = new JComboBox();
    private JLabel labelNbADroit = new JLabel("Nombre d'angle droit : ");

    private JComboBox comboNbParallele = new JComboBox();
    private JLabel labelNbParallele = new JLabel("Nombre de cotes parallele : ");

    private JComboBox comboNbCoteEgaux = new JComboBox();
    private JLabel labelNbCoteEgaux = new JLabel("Nombre de cotes egaux: ");

    private JLabel result = new JLabel(" Le resultat est : ");
    private JLabel resultF = new JLabel("Remplissez le formulaire");
    private JLabel resBool = new JLabel("Polygon non connus");

    public Fenetre() {

        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(8,1));

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        comboNbCote.setPreferredSize(new Dimension(100, 20));
        comboNbADroit.setPreferredSize(new Dimension(100, 20));
        comboNbParallele.setPreferredSize(new Dimension(100, 20));
        comboNbCoteEgaux.setPreferredSize(new Dimension(100, 20));

        this.getContentPane().add(labelNbCote);
        this.getContentPane().add(comboNbCote);
        this.getContentPane().add(labelNbADroit);
        this.getContentPane().add(comboNbADroit);
        this.getContentPane().add(labelNbCoteEgaux);
        this.getContentPane().add(comboNbCoteEgaux);
        this.getContentPane().add(labelNbParallele);
        this.getContentPane().add(comboNbParallele);
        this.getContentPane().add(result);
        this.getContentPane().add(resultF);
        this.getContentPane().add(resBool);

        comboNbCoteEgaux = fillComboBox(8,comboNbCoteEgaux);
        comboNbCote = fillComboBox(8, comboNbCote);
        comboNbParallele = fillComboBox(8, comboNbParallele);
        comboNbADroit = fillComboBox(8, comboNbADroit);

        //On ajoute le bouton au content pane de la JFrame
        this.getContentPane().add(btnResultat);
        btnResultat.addActionListener(new BoutonListener());
        this.setVisible(true);

    }

    public JComboBox fillComboBox(int _number, JComboBox _cb) {
        for(int i = 0; i < _number; i++) {
            _cb.addItem(i);
        }

        return _cb;
    }

    //Classe écoutant notre bouton
    public class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ES sysExpert = new ES();
            int nbCote = comboNbCote.getSelectedIndex();
            int nbDroit = comboNbADroit.getSelectedIndex();
            int nbParallele = comboNbParallele.getSelectedIndex();
            int nbCoteEgaux = comboNbCoteEgaux.getSelectedIndex();
            boolean paral = false;
            if(nbParallele != 0) {
                paral = true;
            }

            Poly poly = new Poly(nbCote, nbDroit, nbCoteEgaux, paral, nbParallele);
            System.out.println(poly.getDescription());
            historique = sysExpert.getInfo(poly, historique);
            resultF.setText(historique.get(historique.size() -2 ));
            if(historique.get(historique.size()-1) == "Connu") {
                resBool.setText("Poygone déjà connu");
            }

        }
    }
}
