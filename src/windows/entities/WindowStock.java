package windows.entities;

import javax.swing.*;

public class WindowStock extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox medicField;
    private JComboBox pharField;
    private JTextField qteField;
    private JTextField numField;

    public WindowStock() {
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
        return this.numField;
    }

    public JComboBox getMedicField() {
        return medicField;
    }

    public JComboBox getPharField() {
        return pharField;
    }

    public JTextField getQteField() {
        return qteField;
    }

    public static void main(String[] args) {
        WindowStock dialog = new WindowStock();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
