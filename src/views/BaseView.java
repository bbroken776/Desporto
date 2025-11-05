package views;

import controller.SystemController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * BaseView for all functional panels. Each view receives a SystemController instance
 * to access business logic. Views should not access data layers directly.
 */
public abstract class BaseView extends JPanel {
    protected final SystemController controller;

    protected BaseView(SystemController controller) {
        this.controller = controller;
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
     * Called by the container when this view becomes visible. Use to refresh data.
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
        ViewHelper.showInfo(this, title, msg);
    }

    protected void showError(String title, String msg) {
        ViewHelper.showError(this, title, msg);
    }

    public String viewKey() { return getClass().getSimpleName(); }
}
