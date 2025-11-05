package views.teams;

import cache.CacheProvider;
import models.sport.Team;
import views.ViewConfig;
import views.ViewHelper;
import views.BaseView;
import views.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TeamsPanel extends BaseView {
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> list = new JList<>(model);

    public TeamsPanel() { super(); initComponents(); }

    @Override
    protected void initComponents() {
        setLayout(new BorderLayout(12,12));
        JLabel h = ViewHelper.createStyledLabel("Equipas", 22, true);
        h.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(h, BorderLayout.NORTH);
        list.setFont(ViewConfig.NORMAL_FONT);
        list.setCellRenderer(new views.SimpleListCellRenderer());
        RoundedPanel card = new RoundedPanel(12, ViewConfig.ELEVATION);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        card.setBackground(ViewConfig.SURFACE);
        JScrollPane sp = new JScrollPane(list);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setBackground(ViewConfig.PRIMARY_BG);
        card.add(sp, BorderLayout.CENTER);
        add(card, BorderLayout.CENTER);
        refreshList();
    }

    private void refreshList() {
        model.clear();
        List<Team> teams = CacheProvider.get().getAllTeams();
        if (teams != null) for (Team t : teams) model.addElement(t.getName());
    }

    @Override
    public void onShow() { refreshList(); }
}
