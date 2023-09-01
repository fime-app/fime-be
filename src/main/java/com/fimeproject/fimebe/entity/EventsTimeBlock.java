package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="events_timeblocks")
public class EventsTimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "event_id")
    private int eventId;

    public EventsTimeBlock() {}

    public EventsTimeBlock(Timestamp startDate, Timestamp endDate, int eventId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventId = eventId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "EventTimeBlocks{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", eventId=" + eventId +
                '}';
    }
}
