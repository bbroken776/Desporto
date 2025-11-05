package views;

import javax.swing.*;
import java.awt.*;

/**
 * Material-like list cell renderer: renders each item as a rounded card with title and optional subtitle.
 */
public class SimpleListCellRenderer extends JPanel implements ListCellRenderer<Object> {
    private final JLabel title = new JLabel();
    private final JLabel subtitle = new JLabel();
    private final JLabel trailing = new JLabel();

    public SimpleListCellRenderer() {
        setLayout(new BorderLayout(6, 2));
        setOpaque(false);
        title.setFont(new Font(ViewConfig.FONT_FAMILY, Font.BOLD, 14));
        subtitle.setFont(new Font(ViewConfig.FONT_FAMILY, Font.PLAIN, 12));
        subtitle.setForeground(ViewConfig.TEXT_SECONDARY);
        title.setForeground(ViewConfig.TEXT_PRIMARY);
        JPanel content = new JPanel(new BorderLayout());
        content.setOpaque(false);
        content.add(title, BorderLayout.NORTH);
        content.add(subtitle, BorderLayout.SOUTH);
        content.setBorder(BorderFactory.createEmptyBorder(8,10,8,10));
        add(content, BorderLayout.CENTER);

        trailing.setFont(new Font(ViewConfig.FONT_FAMILY, Font.BOLD, 13));
        trailing.setForeground(ViewConfig.ACCENT);
        trailing.setBorder(BorderFactory.createEmptyBorder(0,8,0,12));
        add(trailing, BorderLayout.EAST);
        setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = 12;
        // background card
        Color bg = getBackground() != null ? getBackground() : ViewConfig.SURFACE;
        g2.setColor(bg);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        // subtle border
        g2.setColor(ViewConfig.CARD_BORDER);
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);

        // small accent corner on the top-right
        int stripeW = 40;
        int stripeH = 10;
        g2.setColor(ViewConfig.ACCENT);
        g2.fillRoundRect(getWidth() - stripeW - 8, 6, stripeW, stripeH, 6, 6);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        String text = String.valueOf(value == null ? "" : value.toString());
        // support a simple convention: "Title :: 12 Eventos" where trailing part is shown on right
        if (text.contains("::")) {
            String[] parts = text.split("::");
            title.setText(parts[0].trim());
            trailing.setText(parts.length > 1 ? parts[1].trim() : "");
        } else {
            title.setText(text);
            trailing.setText("");
        }
        subtitle.setText("");
        setOpaque(false);
        if (isSelected) {
            setBackground(ViewConfig.ACCENT_SOFT);
            title.setForeground(ViewConfig.ACCENT.darker());
        } else {
            setBackground(ViewConfig.SURFACE);
            title.setForeground(ViewConfig.TEXT_PRIMARY);
        }
        return this;
    }
}

