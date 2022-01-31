package windows.admin;

import javax.swing.*;

public class Logger extends JDialog {
    private JPanel contentPane;
    private JButton buttonLogin;
    private JButton buttonCancel;
    private JTextField loginField;
    private JTextField pwdField;
    private JButton registerBtn;

    public Logger() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonLogin);
        setSize(800,600);
        setLocationRelativeTo(null);
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

    public JButton getLoginBtn() {
        return this.buttonLogin;
    }

    public JButton getCancelBtn() {
        return this.buttonCancel;
    }

    public JButton getRegisterBtn() {
        return this.registerBtn;
    }
}
