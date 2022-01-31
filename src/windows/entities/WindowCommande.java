package windows.entities;

import javax.swing.*;

public class WindowCommande extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField cliField;
    private JTextField medicField;
    private JTextField dateField;
    private JTextField qtyField;

    public WindowCommande() {
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
        WindowCommande dialog = new WindowCommande();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
