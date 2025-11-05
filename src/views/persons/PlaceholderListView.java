package views.persons;

import controller.SystemController;
import views.BaseView;

import javax.swing.*;
import java.awt.*;

public class PlaceholderListView extends BaseView {
    public PlaceholderListView(SystemController controller) { super(controller); }

    @Override
    protected void initComponents() {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        JLabel h = createLabel("Persons", 22, true);
        p.add(h, BorderLayout.NORTH);

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Person 1");
        model.addElement("Person 2");
        model.addElement("Person 3");
        JList<String> list = new JList<>(model);
        p.add(new JScrollPane(list), BorderLayout.CENTER);

        add(p, BorderLayout.CENTER);
    }
}
