package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

@Entity
@Table(name="availability")
public class Availability  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="event_id")
    private int eventId;

    public Availability() {}

    public Availability(String username, int eventId) {
        this.username = username;
        this.eventId = eventId;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", name='" + username + '\'' +
                ", eventId=" + eventId +
                '}';
    }

}
