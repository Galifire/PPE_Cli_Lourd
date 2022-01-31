package windows.entities;

import javax.swing.*;

public class WindowPharmacie extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField villeField;
    private JTextField codePostalField;
    private JTextField adresseField;
    private JTextField effectifField;

    public WindowPharmacie() {
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
        WindowPharmacie dialog = new WindowPharmacie();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
