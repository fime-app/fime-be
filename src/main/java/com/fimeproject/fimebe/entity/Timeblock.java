package com.fimeproject.fimebe.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="timeblocks")
public class Timeblock {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;


    @Column(name="name")
    private String name;

    public Timeblock() {}

    public Timeblock(Date startDate, Date endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Timeblock{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                '}';
    }
}
