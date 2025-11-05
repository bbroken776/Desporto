package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

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
        JButton button = new JButton(text);
        button.setFont(ViewConfig.NORMAL_FONT);
        if (bgColor != null) button.setBackground(bgColor);
        if (fgColor != null) button.setForeground(fgColor);
        button.setPreferredSize(new Dimension(button.getPreferredSize().width, 35));
        button.setFocusPainted(false);
        return button;
    }

    public static JLabel createStyledLabel(String text, int fontSize, boolean bold) {
        JLabel label = new JLabel(text);
        Font base = bold ? ViewConfig.TITLE_FONT : ViewConfig.NORMAL_FONT;
        label.setFont(base != null ? base.deriveFont((float) fontSize) : new Font("SansSerif", Font.PLAIN, fontSize));
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
