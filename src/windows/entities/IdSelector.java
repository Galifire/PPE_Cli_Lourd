package windows.entities;

import javax.swing.*;
import java.awt.event.*;

public class IdSelector extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox idBox;

    public IdSelector() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public JButton getButtonOK() {
        return this.buttonOK;
    }

    public JButton getButtonCancel() {
        return this.buttonCancel;
    }

    public JComboBox getIdBox() {
        return this.idBox;
    }

    public static void main(String[] args) {
        IdSelector dialog = new IdSelector();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}