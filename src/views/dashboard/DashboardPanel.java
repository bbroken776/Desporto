package views.dashboard;

import cache.CacheProvider;
import models.human.Person;
import models.sport.Team;
import models.sport.Event;
import views.ViewConfig;
import views.ViewHelper;
import views.BaseView;
import views.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardPanel extends BaseView {
    private final JLabel personsCount = new JLabel();
    private final JLabel teamsCount = new JLabel();
    private final JLabel eventsCount = new JLabel();

    public DashboardPanel() { super(); initComponents(); }

    @Override
    protected void initComponents() {
        // Title
        JLabel title = ViewHelper.createStyledLabel("Dashboard Principal", 22, true);
        title.setBorder(BorderFactory.createEmptyBorder(12, 12, 18, 12));
        add(title, BorderLayout.NORTH);

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.LEFT, 18, 18));
        wrapper.setOpaque(false);

        JPanel p1 = ViewHelper.createStatCard("Total de Eventos", personsCount);
        JPanel p2 = ViewHelper.createStatCard("Atletas Registrados", teamsCount);
        JPanel p3 = ViewHelper.createStatCard("Árbitros Ativos", eventsCount);

        wrapper.add(p1);
        wrapper.add(p2);
        wrapper.add(p3);

        RoundedPanel card = new RoundedPanel(14, ViewConfig.ELEVATION);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(18,18,18,18));
        card.setBackground(ViewConfig.PRIMARY_BG);
        card.add(wrapper, BorderLayout.CENTER);

        JPanel main = new JPanel(new BorderLayout());
        main.setOpaque(false);
        main.add(card, BorderLayout.NORTH);

        add(main, BorderLayout.CENTER);
        refreshStats();
    }

    // unused, kept for reference
    private JPanel makeCard(String title, JLabel value) { return ViewHelper.createStatCard(title, value); }

    private void refreshStats() {
        // pull from cache
    List<Person> persons = CacheProvider.get().getAllPersons();
    List<Team> teams = CacheProvider.get().getAllTeams();
    List<Event> events = CacheProvider.get().getAllEvents();

        personsCount.setText(String.valueOf(persons != null ? persons.size() : 0));
        teamsCount.setText(String.valueOf(teams != null ? teams.size() : 0));
        eventsCount.setText(String.valueOf(events != null ? events.size() : 0));
    }

    @Override
    public void onShow() { refreshStats(); }
}
