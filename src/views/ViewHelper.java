package views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.FlowLayout;
import java.awt.Component;

/**
 * UI factory helpers. Static API so any view can call factories without needing an instance.
 */
public final class ViewHelper {
    private ViewHelper() {}

    public static JFrame createFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setFont(ViewConfig.TITLE_FONT != null ? ViewConfig.TITLE_FONT : new Font("SansSerif", Font.BOLD, 18));
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        // set content pane background so it is visible
        if (frame.getContentPane() != null) {
            frame.getContentPane().setBackground(ViewConfig.PRIMARY_BG);
        } else {
            frame.setBackground(ViewConfig.PRIMARY_BG);
        }
        return frame;
    }

    public static JButton createStyledButton(String text, Color bgColor, Color fgColor) {
        MaterialButton button = new MaterialButton(text);
        button.setFont(ViewConfig.NORMAL_FONT);
        Color bg = bgColor != null ? bgColor : ViewConfig.ACCENT;
        Color fg = fgColor != null ? fgColor : ViewConfig.NAV_FG;
        button.setBackground(bg);
        button.setForeground(fg);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(96, 36));
        button.setBorderRadius(8);
        button.setPadding(8,12,8,12);
        return button;
    }

    public static JPanel createStatCard(String title, JLabel value) {
        RoundedPanel card = new RoundedPanel(12, ViewConfig.ELEVATION);
        card.setPreferredSize(new Dimension(ViewConfig.CARD_WIDTH, ViewConfig.CARD_HEIGHT));
        card.setBackground(ViewConfig.SURFACE);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));

        // title (small)
        JLabel t = createStyledLabel(title, 12, false);
        t.setForeground(ViewConfig.TEXT_SECONDARY);
        t.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        card.add(t, BorderLayout.NORTH);

        // value centered with larger font
        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        value.setFont(new Font(ViewConfig.FONT_FAMILY, Font.BOLD, 28));
        value.setForeground(ViewConfig.TEXT_PRIMARY);
        center.add(value, BorderLayout.CENTER);
        card.add(center, BorderLayout.CENTER);

        return card;
    }

    /**
     * Create a custom tab header component (used with JTabbedPane#setTabComponentAt).
     * The header appearance is updated by {@link #styleTabs(JTabbedPane)}.
     */
    public static JPanel createTabHeader(String title) {
        // header panel that will be placed into the tab area. We keep it lightweight
        JPanel p = new RoundedPanel(8, 0);
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 6));
        p.setOpaque(false);
        JLabel l = new JLabel(title);
        l.setFont(new Font(ViewConfig.FONT_FAMILY, Font.PLAIN, 14));
        l.setForeground(ViewConfig.TEXT_SECONDARY);
        p.add(l);
        p.setBorder(BorderFactory.createEmptyBorder(6,12,6,12));
        return p;
    }

    /**
     * Apply style behavior to a tabbed pane: swap header backgrounds on selection to mimic material tabs.
     */
    public static void styleTabs(JTabbedPane tabs) {
        // Make the tabbed pane blend with the application background
        tabs.setOpaque(true);
        tabs.setBackground(ViewConfig.PRIMARY_BG);
        tabs.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tabs.setFocusable(false);

        // remove default content border so tabs appear to sit on the same surface
        tabs.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected void installDefaults() {
                super.installDefaults();
                tabs.setOpaque(true);
                highlight = ViewConfig.PRIMARY_BG;
                lightHighlight = ViewConfig.PRIMARY_BG;
                shadow = ViewConfig.PRIMARY_BG;
                darkShadow = ViewConfig.PRIMARY_BG;
                contentBorderInsets = new java.awt.Insets(0,0,0,0);
            }

            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
                // intentionally empty to remove the default border
            }
        });

        tabs.addChangeListener(e -> applyTabStyles(tabs));
        // apply styles once immediately so initial UI matches the styled appearance
        applyTabStyles(tabs);
    }

    // Apply styling to each tab header based on which tab is currently selected.
    private static void applyTabStyles(JTabbedPane tabs) {
        int sel = tabs.getSelectedIndex();
        for (int i = 0; i < tabs.getTabCount(); i++) {
            Component comp = tabs.getTabComponentAt(i);
            if (comp instanceof JPanel) {
                JPanel p = (JPanel) comp;
                // first component is our label
                Component c0 = p.getComponentCount() > 0 ? p.getComponent(0) : null;
                if (c0 instanceof JLabel) {
                    JLabel lbl = (JLabel) c0;
                    if (i == sel) {
                        p.setOpaque(true);
                        p.setBackground(ViewConfig.SURFACE);
                        lbl.setForeground(ViewConfig.TEXT_PRIMARY);
                        lbl.setFont(new Font(ViewConfig.FONT_FAMILY, Font.BOLD, 14));
                        // add a small accent underline by setting a bottom border
                        p.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0,0,3,0, ViewConfig.ACCENT),
                            BorderFactory.createEmptyBorder(6,12,3,12)
                        ));
                    } else {
                        p.setOpaque(false);
                        p.setBackground(new Color(0,0,0,0));
                        lbl.setForeground(ViewConfig.TEXT_SECONDARY);
                        lbl.setFont(new Font(ViewConfig.FONT_FAMILY, Font.PLAIN, 14));
                        p.setBorder(BorderFactory.createEmptyBorder(6,12,6,12));
                    }
                }
            }
        }
        tabs.revalidate();
        tabs.repaint();
    }

    public static JLabel createStyledLabel(String text, int fontSize, boolean bold) {
        JLabel label = new JLabel(text);
        Font base = bold ? ViewConfig.TITLE_FONT : ViewConfig.NORMAL_FONT;
        label.setFont(base != null ? base.deriveFont((float) fontSize) : new Font("SansSerif", Font.PLAIN, fontSize));
        label.setForeground(ViewConfig.TEXT_PRIMARY);
        return label;
    }

    /**
     * Utility to run tasks on EDT from anywhere.
     */
    public static void runOnUi(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) r.run();
        else SwingUtilities.invokeLater(r);
    }

    // Dialog helpers (centralized) — prefer these over direct JOptionPane usage in views
    public static void showInfo(java.awt.Component parent, String title, String message) {
        runOnUi(() -> JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE));
    }

    public static void showError(java.awt.Component parent, String title, String message) {
        runOnUi(() -> JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE));
    }

    // Small validation helper
    public static boolean validateNotEmpty(java.awt.Component parent, String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            showError(parent, "Validation", fieldName + " não pode ser vazio.");
            return false;
        }
        return true;
    }
}
