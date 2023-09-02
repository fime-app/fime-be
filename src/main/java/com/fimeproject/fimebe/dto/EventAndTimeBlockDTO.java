package com.fimeproject.fimebe.dto;

import java.util.List;

public class EventAndTimeBlockDTO {

    private int id;
    private String name;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<DateRangeDTO> dateRanges;

    public EventAndTimeBlockDTO(int id, String name, String description, List<DateRangeDTO> dateRanges) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateRanges = dateRanges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "name='" + name + '\'' +
                ", dateRanges=" + dateRanges +
                '}';
    }
}
