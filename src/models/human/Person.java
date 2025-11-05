package models.human;

import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String bornDate;
    private String number;

    public Person(String name, String bornDate, String number) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bornDate = bornDate;
        this.number = number;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getBornDate() { return bornDate; }
    public String getNumber() { return number; }

    public void setName(String name) { this.name = name; }
    public void setBornDate(String bornDate) { this.bornDate = bornDate; }
    public void setNumber(String number) { this.number = number; }

    @Override
    public String toString() {
        return String.format("Person{id=%s, name='%s', bornDate='%s', number='%s'}", id, name, bornDate, number);
    }
}
