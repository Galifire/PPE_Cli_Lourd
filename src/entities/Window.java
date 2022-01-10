package entities;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JLabel tableName;
    private JPanel tablePanel;
    private JTable dataTable;

    private JScrollPane dataScrolLPane;

    public Window() {
        setContentPane(contentPane);
        setModal(true);
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

    public JPanel getTablePanel() {
        return this.tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JScrollPane getDataScrolLPane() {
        return dataScrolLPane;
    }

}
