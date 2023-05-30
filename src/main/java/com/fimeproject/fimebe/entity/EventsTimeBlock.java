package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="events_timeblocks")
public class EventsTimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "event_id")
    private int eventId;

    public EventsTimeBlock() {}

    public EventsTimeBlock(Date startDate, Date endDate, int eventId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventId = eventId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
