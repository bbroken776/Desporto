package models.human;

import java.util.List;

import models.sport.Result;

public class Athlete extends Person{
    private String sport;
    private String team;
    private List<Result> results;

    public Athlete(String name, String bornDate, String number, String sport, String team, List<Result> results) {
        super(name, bornDate, number);
        this.sport = sport;
        this.team = team;
        this.results = results;
    }

    public String getSport() { return sport; }
    public String getTeam() { return team; }
    public List<Result> getResults() { return results; }

    public void setSport(String sport) { this.sport = sport; }
    public void setTeam(String team) { this.team = team; }
    public void setResults(List<Result> results) { this.results = results; }

    
    @Override
    public String toString() {
        return String.format("Atlete{%s, sport='%s', team='%s', results=%s}", super.toString(), sport, team, results);
    }   
}
