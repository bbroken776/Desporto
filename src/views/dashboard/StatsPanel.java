package views.dashboard;

import cache.Cache;
import cache.CacheProvider;
import models.human.Person;
import models.sport.Event;
import models.sport.Result;
import models.sport.Team;
import views.ViewConfig;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Simple stats panel that shows counts for the main entities.
 * It reads from the cache on demand (via refresh()).
 */
public class StatsPanel extends JPanel {
    private final JLabel personsLabel = new JLabel();
    private final JLabel teamsLabel = new JLabel();
    private final JLabel eventsLabel = new JLabel();
    private final JLabel resultsLabel = new JLabel();

    public StatsPanel() {
        setLayout(new GridLayout(1, 4, 12, 0));
        setBackground(ViewConfig.PRIMARY_BG);
        personsLabel.setFont(ViewConfig.NORMAL_FONT);
        teamsLabel.setFont(ViewConfig.NORMAL_FONT);
        eventsLabel.setFont(ViewConfig.NORMAL_FONT);
        resultsLabel.setFont(ViewConfig.NORMAL_FONT);

        add(personsLabel);
        add(teamsLabel);
        add(eventsLabel);
        add(resultsLabel);

        refresh();
    }

    public void refresh() {
        // guard for missing cache
        Cache cache = CacheProvider.get();
        if (cache == null) return;

        List<Person> persons = cache.getAllPersons();
        List<Team> teams = cache.getAllTeams();
        List<Event> events = cache.getAllEvents();
        List<Result> results = cache.getAllResults();

        personsLabel.setText("Persons: " + (persons != null ? persons.size() : 0));
        teamsLabel.setText("Teams: " + (teams != null ? teams.size() : 0));
        eventsLabel.setText("Events: " + (events != null ? events.size() : 0));
        resultsLabel.setText("Results: " + (results != null ? results.size() : 0));
    }
}
