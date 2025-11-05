package models.sport;

import java.util.List;
import java.util.Map;

import models.human.Athlete;

public class Individual extends Event {
    private List<Athlete> athletes;
    private Map<Athlete, Result> results;

    public Individual(String name, String sport, String local, String date, List<Athlete> athletes, Map<Athlete, Result> results) {
        super(name, sport, local, date, null);
        this.athletes = athletes;
        this.results = results;
    }

    public List<Athlete> getAthletes() { return athletes; }
    public Map<Athlete, Result> getResults() { return results; }

    public void setAthletes(List<Athlete> athletes) { this.athletes = athletes; }
    public void setResults(Map<Athlete, Result> results) { this.results = results; }

    @Override
    public String toString() {
        return String.format("Individual{%s, athletes=%s, results=%s}", super.toString(), athletes, results);
    }
}
