package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Simple material-like rounded button with hover and press visuals.
 */
public class MaterialButton extends JButton {
    private int borderRadius = 8;
    private Insets padding = new Insets(6, 12, 6, 12);
    private boolean hover = false;
    private boolean pressed = false;

    public MaterialButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(ViewConfig.NAV_FG);
        setBackground(ViewConfig.ACCENT);
        setFont(ViewConfig.NORMAL_FONT);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { hover = true; repaint(); }
            @Override
            public void mouseExited(MouseEvent e) { hover = false; pressed = false; repaint(); }
            @Override
            public void mousePressed(MouseEvent e) { pressed = true; repaint(); }
            @Override
            public void mouseReleased(MouseEvent e) { pressed = false; repaint(); }
        });
    }

    public void setBorderRadius(int r) { this.borderRadius = r; repaint(); }
    public void setPadding(int top, int left, int bottom, int right) { this.padding = new Insets(top,left,bottom,right); revalidate(); repaint(); }

    @Override
    public Dimension getPreferredSize() {
        FontMetrics fm = getFontMetrics(getFont());
        int w = fm.stringWidth(getText()) + padding.left + padding.right;
        int h = fm.getHeight() + padding.top + padding.bottom;
        return new Dimension(Math.max(64, w), Math.max(28, h));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color base = getBackground();
        if (pressed) base = base.darker();
        else if (hover) base = base.brighter();

        g2.setColor(base);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);

        // text
        FontMetrics fm = g2.getFontMetrics(getFont());
        int tx = (getWidth() - fm.stringWidth(getText())) / 2;
        int ty = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(getText(), tx, ty);

        g2.dispose();
    }
}
