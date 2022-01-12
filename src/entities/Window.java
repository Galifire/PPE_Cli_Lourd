package entities;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JLabel tableName;
    private JComboBox tableBox;
    private JScrollPane dataScrollPane;
    private JLabel loggedLabel;
    private JPanel tablePanel;

    public Window() {
        setContentPane(contentPane);
        setModal(true);
    }

    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setSize(1600,900);
        dialog.setVisible(true);
        System.exit(0);
    }

    public JLabel getTableName() {
        return this.tableName;
    }

    public void setTableName(JLabel tableName) {
        this.tableName = tableName;
    }

    public JPanel getTablePanel() {
        return this.tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JScrollPane getDataScrolLPane() {
        return dataScrollPane;
    }

    public JComboBox getTableBox() {
        return this.tableBox;
    }

    public JLabel getLoggedLabel() {
        return this.loggedLabel;
    }
}
