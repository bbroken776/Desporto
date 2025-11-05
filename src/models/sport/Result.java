package models.sport;

import java.util.List;

public class Result {
    private Object participant;
    private int position;
    private double score;
    private boolean moreThanOneParticipant;

    private List<String> observations;

    public Result(Object participant, int position, double score, boolean moreThanOneParticipant, List<String> observations) {
        this.participant = participant;
        this.position = position;
        this.score = score;
        this.moreThanOneParticipant = moreThanOneParticipant;
        this.observations = observations;
    }

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
        return String.format("Result{participant=%s, position=%d, score=%.2f, moreThanOneParticipant=%b, observations=%s}", 
                             participant, position, score, moreThanOneParticipant, observations);
    }
}
