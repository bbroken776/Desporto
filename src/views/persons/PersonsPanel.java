package views.persons;

import cache.CacheProvider;
import models.human.Person;
import views.ViewConfig;
import views.ViewHelper;
import views.BaseView;
import views.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PersonsPanel extends BaseView {
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> list = new JList<>(model);

    public PersonsPanel() { super(); initComponents(); }

    @Override
    protected void initComponents() {
        setLayout(new BorderLayout(12,12));
        JLabel h = ViewHelper.createStyledLabel("Pessoas", 22, true);
        h.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        add(h, BorderLayout.NORTH);

        RoundedPanel card = new RoundedPanel(12, ViewConfig.ELEVATION);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        card.setBackground(ViewConfig.SURFACE);
        list.setFont(ViewConfig.NORMAL_FONT);
        list.setCellRenderer(new views.SimpleListCellRenderer());
        JScrollPane sp = new JScrollPane(list);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setBackground(ViewConfig.PRIMARY_BG);
        card.add(sp, BorderLayout.CENTER);
        add(card, BorderLayout.CENTER);
        refreshList();
    }

    private void refreshList() {
        model.clear();
    List<Person> persons = CacheProvider.get().getAllPersons();
        if (persons != null) {
            for (Person p : persons) model.addElement(p.getName());
        }
    }

    @Override
    public void onShow() { refreshList(); }
}
