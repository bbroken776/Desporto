package models.sport;

import java.util.List;
import java.util.UUID;

public class Result {
    private UUID id;
    private Object participant;
    private int position;
    private double score;
    private boolean moreThanOneParticipant;

    private List<String> observations;

    public Result(UUID id, Object participant, int position, double score, boolean moreThanOneParticipant, List<String> observations) {
        this.id = id;
        this.participant = participant;
        this.position = position;
        this.score = score;
        this.moreThanOneParticipant = moreThanOneParticipant;
        this.observations = observations;
    }

    public UUID getId() { return id; }
    public Object getParticipant() { return participant; }
    public int getPosition() { return position; }
    public double getScore() { return score; }
    public boolean isMoreThanOneParticipant() { return moreThanOneParticipant; }
    public List<String> getObservations() { return observations; }

    public void setParticipant(Object participant) { this.participant = participant; }
    public void setPosition(int position) { this.position = position; }
    public void setScore(double score) { this.score = score; }
    public void setMoreThanOneParticipant(boolean moreThanOneParticipant) { this.moreThanOneParticipant = moreThanOneParticipant; }
    public void setObservations(List<String> observations) { this.observations = observations; }

    @Override
    public String toString() {
        return String.format("Result{id=%s, participant=%s, position=%d, score=%.2f, moreThanOneParticipant=%b, observations=%s}", id, participant, position, score, moreThanOneParticipant, observations);
    }
}
