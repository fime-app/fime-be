package com.fimeproject.fimebe.dto;

import java.sql.Date;


public class DateRangeDTO {
    private Date startDate;
    private Date endDate;

    public DateRangeDTO(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public String toString() {
        return "DateRangeDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
