package com.fimeproject.fimebe.dto;

import java.util.List;

public class EventAndTimeBlockDTO {
    private int id;
    private String name;
    private List<DateRangeDTO> dateRanges;

    public EventAndTimeBlockDTO(int id, String name, List<DateRangeDTO> dateRanges) {
        this.id = id;
        this.name = name;
        this.dateRanges = dateRanges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DateRangeDTO> getDateRanges() {
        return dateRanges;
    }

    public void setDateRanges(List<DateRangeDTO> dateRanges) {
        this.dateRanges = dateRanges;
    }

    @Override
    public String toString() {
        return "EventAndTimeBlockDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateRanges=" + dateRanges +
                '}';
    }
}
