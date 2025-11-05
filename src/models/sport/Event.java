package models.sport;

import java.util.UUID;

import models.human.Referee;

public class Event {
    private UUID id;
    private String name;
    private String sport;
    private String local;
    private String date;
    private Referee referee;

    public Event(String name, String sport, String local, String date, Referee referee) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.sport = sport;
        this.local = local;
        this.date = date;
        this.referee = referee;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public String getLocal() { return local; }
    public String getDate() { return date; }
    public Referee getReferee() { return referee; }

    public void setName(String name) { this.name = name; }
    public void setSport(String sport) { this.sport = sport; }
    public void setLocal(String local) { this.local = local; }
    public void setDate(String date) { this.date = date; }
    public void setReferee(Referee referee) { this.referee = referee; } 

    @Override
    public String toString() {
        return String.format("Event{id=%s, name='%s', sport='%s', local='%s', date='%s', referee=%s}", id, name, sport, local, date, referee);
    }
}
