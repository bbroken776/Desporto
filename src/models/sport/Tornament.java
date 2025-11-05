package models.sport;

import java.util.List;

public class Tornament extends Event {
    private List<Team> teams;
    private int numberOfRounds;
    private Team winner;

    public Tornament(String name, String sport, String local, String date, List<Team> teams, int numberOfRounds, Team winner) {
        super(name, sport, local, date, null);
        this.teams = teams;
        this.numberOfRounds = numberOfRounds;
        this.winner = winner;
    }

    public List<Team> getTeams() { return teams; }
    public int getNumberOfRounds() { return numberOfRounds; }
    public Team getWinner() { return winner; }

    public void setTeams(List<Team> teams) { this.teams = teams; }
    public void setNumberOfRounds(int numberOfRounds) { this.numberOfRounds = numberOfRounds; }
    public void setWinner(Team winner) { this.winner = winner; }

    @Override
    public String toString() {
        return String.format("Tornament{%s, teams=%s, numberOfRounds=%d, winner=%s}", super.toString(), teams, numberOfRounds, winner);
    }
}
