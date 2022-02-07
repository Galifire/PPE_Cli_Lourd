package windows.admin;

import javax.swing.*;
import java.awt.event.*;

public class Confirm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Confirm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(400,200);
        setLocationRelativeTo(null);
    }

    public JButton getButtonOK() {
        return this.buttonOK;
    }

    public JButton getButtonCancel() {
        return this.buttonCancel;
    }
}
