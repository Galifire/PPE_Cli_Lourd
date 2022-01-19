package windows.admin;

import javax.swing.*;

public class Window extends JDialog {
    private JPanel contentPane;
    private JComboBox tableBox;
    private JScrollPane dataScrollPane;
    private JButton logoutButton;
    private JPanel tablePanel;
    private JPanel headerPanel;

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
        return headerPanel;
    }
}
