package windows.admin;

import javax.swing.*;

public class Main extends JDialog {
    private JPanel contentPane;
    private JButton registerButton;
    private JButton loginButton;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        setSize(800,600);
        setLocationRelativeTo(null);
    }

    public JButton getRegisterBtn() {
        return this.registerButton;
    }

    public JButton getLoginBtn() {
        return this.loginButton;
    }
}
