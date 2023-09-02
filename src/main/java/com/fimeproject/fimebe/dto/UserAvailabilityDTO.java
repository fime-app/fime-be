package com.fimeproject.fimebe.dto;

import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;

import java.util.List;

public class UserAvailabilityDTO {
    private String username;

    private List<AvailabilityTimeBlock> availableDateRanges;

    public UserAvailabilityDTO(String username, List<AvailabilityTimeBlock> availableDateRanges) {
        this.username = username;
        this.availableDateRanges = availableDateRanges;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AvailabilityTimeBlock> getAvailableDateRanges() {
        return availableDateRanges;
    }

    public void setAvailableDateRanges(List<AvailabilityTimeBlock> availableDateRanges) {
        this.availableDateRanges = availableDateRanges;
    }

    @Override
    public String toString() {
        return "UserAvailabilityDTO{" +
                "username='" + username + '\'' +
                ", availableDateRanges=" + availableDateRanges +
                '}';
    }
}
