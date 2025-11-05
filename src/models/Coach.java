package models;

public class Coach extends Person {
    private String sport;
    private String team;
    private int experienceYears;

    public Coach(String name, String bornDate, String number, String sport, String team, int experienceYears) {
        super(name, bornDate, number);
        this.sport = sport;
        this.team = team;
        this.experienceYears = experienceYears;
    }

    public String getSport() { return sport; }
    public String getTeam() { return team; }
    public int getExperienceYears() { return experienceYears; }

    public void setSport(String sport) { this.sport = sport; }
    public void setTeam(String team) { this.team = team; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }


    @Override
    public String toString() {
        return String.format("Trainer{%s, sport='%s', team='%s', experienceYears=%d}", super.toString(), sport, team, experienceYears);
    }
}
