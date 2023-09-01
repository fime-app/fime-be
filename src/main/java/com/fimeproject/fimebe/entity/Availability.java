package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

@Entity
@Table(name="availability")
public class Availability  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="event_id")
    private int eventId;

    public Availability() {}

    public Availability(String name, int eventId) {
        this.name = name;
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Availability{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventId=" + eventId +
                '}';
    }

}
