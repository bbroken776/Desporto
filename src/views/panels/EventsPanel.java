package views.panels;

import cache.CacheProvider;
import models.sport.Event;
import views.SimpleEntityPanel;

import java.util.List;
import java.util.stream.Collectors;

public class EventsPanel extends SimpleEntityPanel {
    public EventsPanel() {
        super("Eventos", () -> {
            List<Event> events = CacheProvider.get().getAllEvents();
            if (events == null) return java.util.Collections.emptyList();
            return events.stream().map(e -> e.getName() + " — " + e.getDate()).collect(Collectors.toList());
        }, "Add Event");
    }
}
