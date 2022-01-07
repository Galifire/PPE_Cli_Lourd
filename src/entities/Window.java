package entities;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel tableName;

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

    public JLabel getTableName() {
        return this.tableName;
    }

    public void setTableName(JLabel tableName) {
        this.tableName = tableName;
    }
}
