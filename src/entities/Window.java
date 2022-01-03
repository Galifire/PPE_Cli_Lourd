package entities;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Window() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
