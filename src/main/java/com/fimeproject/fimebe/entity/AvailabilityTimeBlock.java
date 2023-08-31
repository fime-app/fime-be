package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name="availability_timeblocks")
public class AvailabilityTimeBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "availability_id")
    private int availabilityId;

    public AvailabilityTimeBlock() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AvailabilityTimeBlock(Timestamp startDate, Timestamp endDate, int availabilityId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.availabilityId = availabilityId;
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

    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
    }

    @Override
    public String toString() {
        return "AvailabilityTimeBlocks{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", availabilityId=" + availabilityId +
                '}';
    }
}
