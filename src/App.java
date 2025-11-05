import cache.Cache;
import cache.CacheProvider;
import views.MainView;
import views.dashboard.DashboardView;
import views.persons.PlaceholderListView;
import controller.SystemController;
import javax.swing.SwingUtilities;

public class App {
    private static Cache cache;

    public static void main(String[] args) throws Exception {
        // create cache singleton used across the app
        cache = CacheProvider.get();

        SwingUtilities.invokeLater(() -> {
            SystemController controller = new SystemController(cache);
            MainView mf = new MainView("Desporto", controller);
            // register views
            DashboardView dv = new DashboardView(controller);
            PlaceholderListView lv = new PlaceholderListView(controller);
            mf.registerView(dv, "Dashboard");
            mf.registerView(lv, "Persons");
            mf.setVisible(true);
            mf.showView(dv.viewKey());
        });
    }

    public static Cache getCache() { return cache; }
}
