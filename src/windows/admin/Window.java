package windows.admin;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JComboBox tableBox;
    private JScrollPane dataScrollPane;
    private JButton logoutButton;
    private JPanel tablePanel;
    private JPanel headerPanel;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public Window() {
        setContentPane(contentPane);
        setModal(true);
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

    public JButton getLogoutButton() {
        return this.logoutButton;
    }

    public JPanel getHeaderPanel() {
        return this.headerPanel;
    }

    public JButton getAddButton() {
        return this.addButton;
    }

    public JButton getEditButton() {
        return this.editButton;
    }

    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    public static void main(String[] args) {
        Window dialog = new Window();
        dialog.pack();
        dialog.setSize(1600,900);
        dialog.setVisible(true);
        System.exit(0);
    }
}
