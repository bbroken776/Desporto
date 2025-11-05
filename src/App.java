import cache.Cache;
import cache.CacheProvider;
import views.main.MainView;
import javax.swing.SwingUtilities;

public class App {
    private static Cache cache;

    public static void main(String[] args) throws Exception {
        cache = CacheProvider.get();

        // seed sample data
        seedSampleData();

        SwingUtilities.invokeLater(() -> {
            MainView main = new MainView();
            main.setVisible(true);
        });
    }

    private static void seedSampleData() {
        // create a few persons
        models.human.Athlete a1 = new models.human.Athlete("Alice Silva", "1990-05-12", "A001", "Swimming", null, null);
        models.human.Athlete a2 = new models.human.Athlete("Bruno Costa", "1992-09-03", "A002", "Running", null, null);
        models.human.Coach c1 = new models.human.Coach("Carla Gomes", "1980-02-28", "C001", "Swimming", null, 12);
        models.human.Referee r1 = new models.human.Referee("Daniel Ref", "1975-11-11", "R001", "Running", "Level A");

        cache.addPerson(a1);
        cache.addPerson(a2);
        cache.addPerson(c1);
        cache.addPerson(r1);

        // create a team
        models.sport.Team t1 = new models.sport.Team("Blue Sharks", "Swimming", java.util.Arrays.asList(a1), c1);
        cache.addTeam(t1);

        // create an event
        models.sport.Event e1 = new models.sport.Event("City Marathon", "Running", "Central Park", "2025-06-21", r1);
        cache.addEvent(e1);
    }

    public static Cache getCache() { return cache; }
}
