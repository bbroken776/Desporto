package views.panels;

import cache.CacheProvider;
import models.human.Person;
import views.SimpleEntityPanel;

import java.util.List;
import java.util.stream.Collectors;

public class PersonsPanel extends SimpleEntityPanel {
    public PersonsPanel() {
        super("Pessoas", () -> {
            List<Person> persons = CacheProvider.get().getAllPersons();
            if (persons == null) return java.util.Collections.emptyList();
            return persons.stream().map(Person::getName).collect(Collectors.toList());
        }, "Add Person");
    }
}
