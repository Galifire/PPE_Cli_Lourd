package windows.create;

import javax.swing.*;
import java.awt.event.*;

public class CreateUser extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idField;
    private JTextField usernameField;
    private JTextField pwdField;
    private JLabel roleField;

    public CreateUser() {
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

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPwdField() {
        return pwdField;
    }

    public JLabel getRoleField() {
        return roleField;
    }

    public static void main(String[] args) {
        CreateUser dialog = new CreateUser();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
