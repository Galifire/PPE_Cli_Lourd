package windows;

import javax.swing.*;
import java.awt.event.*;

public class Register extends JDialog {
    private JPanel contentPane;
    private JButton buttonRegister;
    private JButton buttonCancel;
    private JTextField usernameField;
    private JTextField pwdField;
    private JTextField confirmPwdField;
    private JLabel pwdConfirmLabel;
    private JLabel usernameLabel;
    private JLabel pwdLabel;
    private JButton mainBtn;

    public Register() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRegister);
    }

    public JButton getMainBtn() {
        return this.mainBtn;
    }

    public JButton getRegisterBtn() {
        return this.buttonRegister;
    }

    public JButton getCancelBtn() {
        return this.buttonCancel;
    }

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public JTextField getPwdField() {
        return this.pwdField;
    }

    public JTextField getConfirmedPwdField() {
        return this.confirmPwdField;
    }

    public static void main(String[] args) {
        Register dialog = new Register();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
