package windows.entities;

import javax.swing.*;

public class WindowUser extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField idField;
    private JTextField usernameField;
    private JTextField pwdField;
    private JTextField roleField;

    public WindowUser() {
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

    public JTextField getRoleField() {
        return roleField;
    }

    public static void main(String[] args) {
        WindowUser dialog = new WindowUser();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
