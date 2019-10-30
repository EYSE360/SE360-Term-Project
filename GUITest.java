import models.Category;
import models.Table;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GUITest {
    static Connection conn = null;

    private JFrame mainFrame;
    private JPanel tablePanel;
    private JPanel menuPanel;

    private GUITest() {
        mainFrame = new JFrame();
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setTabPlacement(JTabbedPane.LEFT);

                tablePanel = new JPanel();
                tablePanel.setLayout(new GridLayout(4, 4, 3, 3));

                List<Table> tableList = getAllTables();
                for (Table t : tableList) {
                    JLabel label = new JLabel(t.getShortcode());
                    label.setHorizontalAlignment(SwingConstants.CENTER);

                    Border border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
                    label.setBorder(border);
                    tablePanel.add(label);
                }
            tabbedPane.addTab("Tables", tablePanel);

//                menuPanel.setLayout();
                    JTabbedPane menuTabbedPane = new JTabbedPane();
                        JPanel categoryPanel = new JPanel();
                            JButton b = new JButton("categories");
                            categoryPanel.add(b);
                    menuTabbedPane.addTab("Categories", categoryPanel);

                        JPanel productPanel = new JPanel();
                            JButton b2 = new JButton("products");
                            productPanel.add(b2);
                    menuTabbedPane.addTab("Products", productPanel);

            menuPanel = new JPanel();
                menuPanel.add(menuTabbedPane);

            tabbedPane.addTab("Menu", menuPanel);

        mainFrame.getContentPane().add(tabbedPane);
        mainFrame.setSize(700, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        conn = DBConnection.getConnection();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUITest();
            }
        });
    }

    private List<Table> getAllTables() {
        conn = DBConnection.getConnection();
        List<Table> tableList = new ArrayList<>();
        String query = "SELECT * FROM tables";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Table t = new Table();
                t.setId(resultSet.getInt("id"));
                t.setName(resultSet.getString("name"));
                t.setShortcode(resultSet.getString("shortcode"));
                tableList.add(t);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableList;
    }

    private List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        String query = "SELECT * FROM categories";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category c = new Category();
                c.setId(resultSet.getInt("id"));
                c.setName(resultSet.getString("name"));
                categoryList.add(c);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoryList;
    }
}
