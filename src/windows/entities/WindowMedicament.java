package windows.entities;

import javax.swing.*;

public class WindowMedicament extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField restrictionsField;
    private JTextField delaiField;

    public WindowMedicament() {
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

    public JTextField getRestrictionsField() {
        return restrictionsField;
    }

    public JTextField getDelaiField() {
        return delaiField;
    }

    public static void main(String[] args) {
        WindowMedicament dialog = new WindowMedicament();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
