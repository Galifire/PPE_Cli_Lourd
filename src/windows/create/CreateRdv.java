package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateRdv extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField medecinField;
    private JTextField clientField;
    private JTextField dateField;
    private JTextField heureField;
    private JTextField dureeField;
    private JTextField prixField;
    private JTextField commentairesField;

    public CreateRdv() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JTextField getMedecinField() {
        return medecinField;
    }

    public JTextField getClientField() {
        return clientField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getHeureField() {
        return heureField;
    }

    public JTextField getDureeField() {
        return dureeField;
    }

    public JTextField getPrixField() {
        return prixField;
    }

    public JTextField getCommentairesField() {
        return commentairesField;
    }

    public static void main(String[] args) {
        CreateRdv dialog = new CreateRdv();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
