package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreatePharmacie extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField villeField;
    private JTextField codePostalField;
    private JTextField adresseField;
    private JTextField effectifField;

    public CreatePharmacie() {
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

    public JTextField getVilleField() {
        return villeField;
    }

    public JTextField getCodePostalField() {
        return codePostalField;
    }

    public JTextField getAdresseField() {
        return adresseField;
    }

    public JTextField getEffectifField() {
        return effectifField;
    }

    public static void main(String[] args) {
        CreatePharmacie dialog = new CreatePharmacie();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
