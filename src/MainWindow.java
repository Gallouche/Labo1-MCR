import javax.swing.*;

/**
 * Created by Gallouche on 24/02/2017.
 */
public class MainWindow {
    public MainWindow(){

        JFrame f = new JFrame("Test");
        JPanel panel = new JPanel();
        JPanel haut = new JPanel();
        JPanel bas = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel.add(haut);
        panel.add(bas);

        f.setContentPane(panel);

        JButton horlogeRomaine = new JButton("Horloge Romaine");
        JButton horlogeArabe = new JButton("Horloge Arabe");
        JButton horlogeNumerique = new JButton("Horloge Numérique");
        JButton horlogeMixte = new JButton("Horloge Mixte");
        JButton demarrer = new JButton("Démarer");
        JButton arreter = new JButton("Arreter");
        JButton reinitialiser = new JButton("Réinitialiser");
        JButton quitter = new JButton("Quitter");

        haut.add(horlogeRomaine);
        haut.add(horlogeArabe);
        haut.add(horlogeNumerique);
        haut.add(horlogeMixte);
        bas.add(demarrer);
        bas.add(arreter);
        bas.add(reinitialiser);
        bas.add(quitter);

        f.pack();
        f.setVisible(true);
    }
}
