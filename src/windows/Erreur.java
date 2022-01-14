package windows;

import javax.swing.*;
import java.awt.event.*;

public class Erreur extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JPanel errorPanel;
    private JLabel errorText;

    public Erreur() {
        setContentPane(contentPane);
        setModal(true);
    }

    public JButton getOkBtn() {
        return this.buttonOK;
    }

    public JLabel getErrorText() {
        return this.errorText;
    }

    public static void main(String[] args) {
        Erreur dialog = new Erreur();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
