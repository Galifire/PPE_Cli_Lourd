package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateMedicament extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField numField;
    private JTextField nomField;
    private JTextField restrictionsField;
    private JTextField delaiField;

    public CreateMedicament() {
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

    public JTextField getRestrictionsField() {
        return restrictionsField;
    }

    public JTextField getDelaiField() {
        return delaiField;
    }

    public static void main(String[] args) {
        CreateMedicament dialog = new CreateMedicament();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
