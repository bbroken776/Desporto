package views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

/**
 * Generic simple list panel used by Persons/Teams/Events to avoid duplicated UI code.
 * The panel shows a title, a search field (non-functional placeholder), Add/Edit/Delete buttons
 * and a rounded card containing a JList rendered with SimpleListCellRenderer.
 */
public class SimpleEntityPanel extends BaseView {
    private final Supplier<List<String>> dataSupplier;
    private final String titleText;
    private final String addButtonText;

    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final JList<String> list = new JList<>(model);

    public SimpleEntityPanel(String titleText, Supplier<List<String>> dataSupplier, String addButtonText) {
        super();
        this.titleText = titleText;
        this.dataSupplier = dataSupplier;
        this.addButtonText = addButtonText;
        initComponents();
    }

    @Override
    protected void initComponents() {
        setLayout(new BorderLayout(12,12));

        // Header with title, search and action buttons
        JPanel top = new JPanel(new BorderLayout(8,8));
        top.setOpaque(false);
        JLabel h = ViewHelper.createStyledLabel(titleText, 22, true);
        h.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        top.add(h, BorderLayout.WEST);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 8));
        actions.setOpaque(false);
        JTextField search = new JTextField();
        search.setPreferredSize(new Dimension(220, 32));
        search.setFont(ViewConfig.NORMAL_FONT);
        search.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(ViewConfig.CARD_BORDER), BorderFactory.createEmptyBorder(4,8,4,8)));
        actions.add(search);
        actions.add(ViewHelper.createStyledButton(addButtonText, ViewConfig.ACCENT, ViewConfig.NAV_FG));
        actions.add(ViewHelper.createStyledButton("Edit", ViewConfig.SURFACE_ALT, ViewConfig.TEXT_PRIMARY));
        actions.add(ViewHelper.createStyledButton("Delete", ViewConfig.SURFACE_ALT, ViewConfig.TEXT_PRIMARY));
        top.add(actions, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        // List card
        list.setFont(ViewConfig.NORMAL_FONT);
        list.setCellRenderer(new SimpleListCellRenderer());

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

    protected void refreshList() {
        model.clear();
        List<String> items = dataSupplier != null ? dataSupplier.get() : null;
        if (items != null) for (String s : items) model.addElement(s);
    }

    @Override
    public void onShow() { refreshList(); }
}
