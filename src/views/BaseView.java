package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Common base for all application views.
 * - Use a single MainFrame and swap BaseView subclasses with CardLayout.
 * - Implement initComponents() to build UI.
 * - Override onShow() to refresh data when the view is displayed.
 */
public abstract class BaseView extends JPanel {

    public BaseView() {
        initialize();
        initComponents();
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(ViewConfig.CARD_BG != null ? ViewConfig.CARD_BG : Color.WHITE);
        setBorder(new EmptyBorder(12, 12, 12, 12));
    }

    /**
     * Build UI components here (called from constructor). Do not perform long-running work.
     */
    protected abstract void initComponents();

    /**
     * Called by the container when this view becomes visible.
     * Use to refresh data from controllers/cache.
     */
    public void onShow() { /* optional override */ }

    // Delegation helpers that use ViewHelper factories (keeps creation centralized)
    protected JButton createButton(String text) {
        return ViewHelper.createStyledButton(text, null, null);
    }

    protected JButton createButton(String text, Color bg, Color fg) {
        return ViewHelper.createStyledButton(text, bg, fg);
    }

    protected JLabel createLabel(String text, int fontSize, boolean bold) {
        return ViewHelper.createStyledLabel(text, fontSize, bold);
    }

    protected JFrame createFrame(String title, int w, int h) {
        return ViewHelper.createFrame(title, w, h);
    }

    protected void runOnUiThread(Runnable r) {
        ViewHelper.runOnUi(r);
    }

    protected void showInfo(String title, String msg) {
        runOnUiThread(() -> JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE));
    }

    protected void showError(String title, String msg) {
        runOnUiThread(() -> JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE));
    }

    public String viewKey() { return getClass().getSimpleName(); }
}
