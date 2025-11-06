package views.panels;

import cache.CacheProvider;
import models.sport.Team;
import views.SimpleEntityPanel;

import java.util.List;
import java.util.stream.Collectors;

public class TeamsPanel extends SimpleEntityPanel {
    public TeamsPanel() {
        super("Equipas", () -> {
            List<Team> teams = CacheProvider.get().getAllTeams();
            if (teams == null) return java.util.Collections.emptyList();
            return teams.stream().map(Team::getName).collect(Collectors.toList());
        }, "Add Team");
    }
}
