package com.fimeproject.fimebe.dto;

import java.util.List;

public class AvailabilityTimeBlockDTO {
    private String name;

    private List<DateRangeDTO> availableDates;

    public AvailabilityTimeBlockDTO(String name, List<DateRangeDTO> availableDates) {
        this.name = name;
        this.availableDates = availableDates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DateRangeDTO> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<DateRangeDTO> availableDates) {
        this.availableDates = availableDates;
    }

    @Override
    public String toString() {
        return "AvailabilityTimeBlockDTO{" +
                "name='" + name + '\'' +
                ", availableDates=" + availableDates +
                '}';
    }
}
