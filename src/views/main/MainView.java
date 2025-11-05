package views.main;

import views.ViewConfig;
import views.ViewHelper;
import views.BaseView;

import javax.swing.*;
import java.awt.*;

/**
 * MainView: top-level frame with a tabbed navbar in CENTER.
 */
public class MainView extends JFrame {
    private final JTabbedPane tabs = new JTabbedPane();
    public MainView() {
        super("Desporto");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(ViewConfig.PRIMARY_BG);

        // Build tabs
    views.dashboard.DashboardPanel dash = new views.dashboard.DashboardPanel();
    views.persons.PersonsPanel persons = new views.persons.PersonsPanel();
    views.teams.TeamsPanel teams = new views.teams.TeamsPanel();
    views.events.EventsPanel events = new views.events.EventsPanel();

    tabs.addTab("Dashboard", dash);
    tabs.addTab("Persons", persons);
    tabs.addTab("Teams", teams);
    tabs.addTab("Events", events);

    // set custom headers and style
    tabs.setTabComponentAt(0, ViewHelper.createTabHeader("Dashboard"));
    tabs.setTabComponentAt(1, ViewHelper.createTabHeader("Persons"));
    tabs.setTabComponentAt(2, ViewHelper.createTabHeader("Teams"));
    tabs.setTabComponentAt(3, ViewHelper.createTabHeader("Events"));
    ViewHelper.styleTabs(tabs);

    add(tabs, BorderLayout.CENTER);
    }
}
