package views;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private final int radius;
    private final int elevation;

    public RoundedPanel(int radius) { this(radius, 4); }
    public RoundedPanel(int radius, int elevation) {
        this.radius = radius;
        this.elevation = elevation;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // draw soft shadow
        g2.setColor(ViewConfig.SHADOW);
        for (int i = 0; i < elevation; i++) {
            int alphaOffset = i * 2;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Math.max(0.06f, 0.12f - i*0.02f)));
            g2.fillRoundRect(2 + i, 2 + i, getWidth() - (4 + i*2), getHeight() - (4 + i*2), radius, radius);
        }

        // draw panel surface
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }
}
