package windows.entities;

import javax.swing.*;

public class WindowMedecin extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField adresseField;
    private JTextField emailField;
    private JTextField telField;
    private JTextField cabField;

    public WindowMedecin() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(800,600);
        setLocationRelativeTo(null);
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

    public JTextField getCabField() {
        return cabField;
    }

    public static void main(String[] args) {
        WindowMedecin dialog = new WindowMedecin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
