package views.dashboard;

import controller.SystemController;
import views.BaseView;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends BaseView {
    public DashboardView(SystemController controller) { super(controller); }

    @Override
    protected void initComponents() {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        JLabel h = createLabel("Dashboard", 26, true);
        p.add(h, BorderLayout.NORTH);

        JTextArea t = new JTextArea("Welcome to the Dashboard. Use the navigation to explore.");
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.setEditable(false);
        t.setBackground(views.ViewConfig.CARD_BG);
        p.add(new JScrollPane(t), BorderLayout.CENTER);

        add(p, BorderLayout.CENTER);
    }

    @Override
    public void onShow() {
        // refresh data if needed
    }
}
