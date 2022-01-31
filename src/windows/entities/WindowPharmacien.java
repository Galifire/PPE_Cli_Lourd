package windows.entities;

import javax.swing.*;

public class WindowPharmacien extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JTextField pharmacieNum;

    public WindowPharmacien() {
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

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getTelephoneField() {
        return telephoneField;
    }

    public JTextField getPharmacieNum() {
        return pharmacieNum;
    }

    public static void main(String[] args) {
        WindowPharmacien dialog = new WindowPharmacien();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
