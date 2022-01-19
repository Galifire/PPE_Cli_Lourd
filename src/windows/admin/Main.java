package windows.admin;

import javax.swing.*;

public class Main extends JDialog {
    private JPanel contentPane;
    private JButton registerButton;
    private JButton loginButton;

    public Main() {
        setContentPane(contentPane);
        setModal(true);;
    }

    public JButton getRegisterBtn() {
        return this.registerButton;
    }

    public JButton getLoginBtn() {
        return this.loginButton;
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
