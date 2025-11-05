package views;

import java.awt.Color;
import java.awt.Font;

public final class ViewConfig {
    // Use a clean UI font family where available
    public static final String FONT_FAMILY = "Segoe UI";
    public static final Font TITLE_FONT = new Font(FONT_FAMILY, Font.BOLD, 20);
    public static final Font NORMAL_FONT = new Font(FONT_FAMILY, Font.PLAIN, 14);
    // Material-like palette
    public static final Color PRIMARY_BG = new Color(250, 250, 250); // background surface
    public static final Color SURFACE = Color.WHITE;
    public static final Color SURFACE_ALT = new Color(245, 247, 250);
    public static final Color ACCENT = new Color(25, 118, 210); // blue 700
    public static final Color ACCENT_SOFT = new Color(227, 242, 253);
    public static final Color NAV_BG = ACCENT;
    public static final Color NAV_FG = Color.WHITE;
    public static final Color CARD_BG = SURFACE;
    public static final Color TEXT_PRIMARY = new Color(33, 33, 33);
    public static final Color TEXT_SECONDARY = new Color(97, 97, 97);
    // card sizing for stat cards
    public static final int CARD_WIDTH = 260;
    public static final int CARD_HEIGHT = 140;
    public static final Color CARD_BORDER = new Color(220, 220, 220);
    // subtle shadow color used by RoundedPanel
    public static final Color SHADOW = new Color(0, 0, 0, 40);
    // elevation sizes (used for drop shadows)
    public static final int ELEVATION = 6;

    private ViewConfig() {}
}