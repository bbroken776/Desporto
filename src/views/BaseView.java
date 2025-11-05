package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Simple BaseView that doesn't force a controller — views should call CacheProvider directly.
 */
public abstract class BaseView extends JPanel {
    protected BaseView() {
        initialize();
        // NOTE: Do NOT call initComponents() here — subclasses must call it from their constructors
        // after their fields have been initialized to avoid NPEs when overridden methods use fields.
    }

    private void initialize() {
        setLayout(new BorderLayout());
        setBackground(ViewConfig.CARD_BG != null ? ViewConfig.CARD_BG : Color.WHITE);
        setBorder(new EmptyBorder(12, 12, 12, 12));
    }

    protected abstract void initComponents();

    public void onShow() { }
}
