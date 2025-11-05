package views;

import javax.swing.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Main application frame. Holds a navbar at the top, a card container for views and a stats strip below the navbar.
 */
public class MainView extends JFrame {
    private final JTabbedPane tabbed = new JTabbedPane();
    private final views.dashboard.StatsPanel statsPanel = new views.dashboard.StatsPanel();
    private final JPanel navBar;
    private final Map<String, BaseView> registered = new HashMap<>();
    private final controller.SystemController controller;

    public MainView(String title, controller.SystemController controller) {
        super(title);
        this.controller = controller;
        init();
        navBar = buildNavBar();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(navBar, BorderLayout.NORTH);
        getContentPane().add(tabbed, BorderLayout.CENTER);
        getContentPane().add(statsPanel, BorderLayout.SOUTH);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        getContentPane().setBackground(ViewConfig.PRIMARY_BG);
    }

    private JPanel buildNavBar() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(ViewConfig.NAV_BG);
        p.setPreferredSize(new Dimension(1000, 60));

        JLabel title = ViewHelper.createStyledLabel(getTitle(), 20, true);
        title.setForeground(ViewConfig.NAV_FG);
        title.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
        left.setOpaque(false);
        left.add(title);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setOpaque(false);

        // Example nav buttons (can be extended)
        JButton dash = ViewHelper.createStyledButton("Dashboard", ViewConfig.NAV_BG, ViewConfig.NAV_FG);
        dash.addActionListener(e -> showView("DashboardView"));
        JButton list = ViewHelper.createStyledButton("List", ViewConfig.NAV_BG, ViewConfig.NAV_FG);
        list.addActionListener(e -> showView("PlaceholderListView"));
        right.add(dash);
        right.add(list);

        p.add(left, BorderLayout.WEST);
        p.add(right, BorderLayout.EAST);
        return p;
    }

    public void registerView(BaseView view, String title) {
        String key = view.viewKey();
        registered.put(key, view);
        tabbed.add(title, view);
    }

    public void showView(String key) {
        BaseView v = registered.get(key);
        if (v != null) {
            int idx = tabbed.indexOfComponent(v);
            if (idx >= 0) tabbed.setSelectedIndex(idx);
            v.onShow();
        }
        statsPanel.refresh();
    }

}
