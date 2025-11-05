package models.sport;

import java.util.List;
import java.util.UUID;

import models.human.Athlete;
import models.human.Coach;

public class Team {
    private UUID id;
    private String name;
    private String sport;

    private List<Athlete> athletes;
    private Coach coach;

    public Team(String name, String sport, List<Athlete> athletes, Coach coach) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.sport = sport;
        this.athletes = athletes;
        this.coach = coach;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public List<Athlete> getAthletes() { return athletes; }
    public Coach getCoach() { return coach; } 

    public void setName(String name) { this.name = name; }
    public void setSport(String sport) { this.sport = sport; }
    public void setAthletes(List<Athlete> athletes) { this.athletes = athletes; }
    public void setCoach(Coach coach) { this.coach = coach; }
    
    @Override
    public String toString() {
        return String.format("Team{id=%s, name='%s', sport='%s', athletes=%s, coach=%s}", id, name, sport, athletes, coach);
    }
}
