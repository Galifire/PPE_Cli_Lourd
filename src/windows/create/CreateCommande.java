package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateCommande extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField cliField;
    private JTextField medicField;
    private JTextField dateField;
    private JTextField qtyField;

    public CreateCommande() {
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

    public JTextField getCliField() {
        return cliField;
    }

    public JTextField getMedicField() {
        return medicField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getQtyField() {
        return qtyField;
    }

    public static void main(String[] args) {
        CreateCommande dialog = new CreateCommande();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
