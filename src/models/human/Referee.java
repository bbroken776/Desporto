package models.human;

public class Referee extends Person {
    private String sport;
    private String certificateLevel;

    public Referee(String name, String bornDate, String number, String sport, String certificateLevel) {
        super(name, bornDate, number);
        this.sport = sport;
        this.certificateLevel = certificateLevel;
    }

    public String getSport() { return sport; }
    public String getCertificateLevel() { return certificateLevel; }

    public void setSport(String sport) { this.sport = sport; }
    public void setCertificateLevel(String certificateLevel) { this.certificateLevel = certificateLevel; }


    @Override
    public String toString() {
        return String.format("Referee{%s, sport='%s', certificateLevel='%s'}", super.toString(), sport, certificateLevel);
    }
}
