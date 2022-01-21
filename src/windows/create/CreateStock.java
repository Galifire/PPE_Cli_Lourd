package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateStock extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField medicField;
    private JTextField pharField;
    private JTextField qteField;

    public CreateStock() {
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

    public JTextField getMedicField() {
        return medicField;
    }

    public JTextField getPharField() {
        return pharField;
    }

    public JTextField getQteField() {
        return qteField;
    }

    public static void main(String[] args) {
        CreateStock dialog = new CreateStock();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
