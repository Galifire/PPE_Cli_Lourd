package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateCabinetMedical extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField adresseField;
    private JTextField effectifField;
    private JTextField horairesField;

    public CreateCabinetMedical() {
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

    public JTextField getAdresseField() {
        return adresseField;
    }

    public JTextField getEffectifField() {
        return effectifField;
    }

    public JTextField getHorairesField() {
        return horairesField;
    }

    public static void main(String[] args) {
        CreateCabinetMedical dialog = new CreateCabinetMedical();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
