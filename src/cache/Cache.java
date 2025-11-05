package cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import models.human.Person;
import models.sport.Event;
import models.sport.Result;
import models.sport.Team;

public class Cache {
    private Map<UUID, Person> persons;
    private Map<UUID, Team> teams;
    private Map<UUID, Event> events;
    private Map<UUID, Result> results;

    public Cache() {
        this.persons = new java.util.HashMap<>();
        this.teams = new java.util.HashMap<>();
        this.events = new java.util.HashMap<>();
        this.results = new java.util.HashMap<>();
    }

    public Person getPerson(UUID id) { return persons.get(id); }
    public Team getTeam(UUID id) { return teams.get(id); }
    public Event getEvent(UUID id) { return events.get(id); }
    public Result getResult(UUID id) { return results.get(id); }

    public List<Person> getAllPersons() { return new ArrayList<>(persons.values()); }
    public List<Team> getAllTeams() { return new ArrayList<>(teams.values()); }
    public List<Event> getAllEvents() { return new ArrayList<>(events.values()); }
    public List<Result> getAllResults() { return new ArrayList<>(results.values()); }

    public void addPerson(Person person) { persons.put(person.getId(), person); }
    public void addTeam(Team team) { teams.put(team.getId(), team); }
    public void addEvent(Event event) { events.put(event.getId(), event); }
    public void addResult(Result result) { results.put(result.getId(), result); }

    public void removePerson(UUID id) { persons.remove(id); }
    public void removeTeam(UUID id) { teams.remove(id); }
    public void removeEvent(UUID id) { events.remove(id); }
    public void removeResult(UUID id) { results.remove(id); }

}