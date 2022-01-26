package windows.entities;

import javax.swing.*;

public class WindowRdv extends JDialog {
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
    private JTextField numField;

    public WindowRdv() {
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
        return this.numField;
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
        WindowRdv dialog = new WindowRdv();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
