package entities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import entities.User;

public class Logger extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField loginField;
    private JTextField pwdField;

    public Logger() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        Logger dialog = new Logger();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public JTextField getLogin() {
        return this.loginField;
    }

    public JTextField getPwd() {
        return this.pwdField;
    }

    public JButton getOkBtn() {
        return this.buttonOK;
    }

    public JButton getCancelBtn() {
        return this.buttonCancel;
    }
}
