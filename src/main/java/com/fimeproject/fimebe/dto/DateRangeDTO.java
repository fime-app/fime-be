package com.fimeproject.fimebe.dto;

import java.sql.Timestamp;


public class DateRangeDTO {
    private Timestamp startDate;
    private Timestamp endDate;

    public DateRangeDTO(Timestamp startDate, Timestamp endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "DateRangeDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
