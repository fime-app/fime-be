package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="availability_timeblocks")
public class AvailabilityTimeBlocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "availability_id")
    private int availabilityId;

    public AvailabilityTimeBlocks() {}

    public AvailabilityTimeBlocks(Date startDate, Date endDate, int availabilityId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.availabilityId = availabilityId;
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
