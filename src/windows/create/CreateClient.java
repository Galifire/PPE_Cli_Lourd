package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField adresseField;
    private JTextField emailField;
    private JTextField telField;

    public CreateClient() {
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

    public JTextField getNumField() {
        return numField;
    }

    public JTextField getNomField() {
        return nomField;
    }

    public JTextField getPrenomField() {
        return prenomField;
    }

    public JTextField getAdresseField() {
        return adresseField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getTelField() {
        return telField;
    }

    public static void main(String[] args) {
        CreateClient dialog = new CreateClient();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
