package windows.create;

import javax.swing.*;

public class CreatePharmacien extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JTextField pharmacieNum;

    public CreatePharmacien() {
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
        CreatePharmacien dialog = new CreatePharmacien();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
