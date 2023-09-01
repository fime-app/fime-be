package com.fimeproject.fimebe.dto;

import java.util.List;

public class EventAvailabilityDTO {
        private List<AvailabilityTimeBlockDTO> users;

        private List<DateRangeDTO> totalAvailability;

        public EventAvailabilityDTO(List<AvailabilityTimeBlockDTO> users, List<DateRangeDTO> totalAvailability) {
                this.users = users;
                this.totalAvailability = totalAvailability;
        }

        public List<AvailabilityTimeBlockDTO> getUsers() {
                return users;
        }

        public void setUsers(List<AvailabilityTimeBlockDTO> users) {
                this.users = users;
        }

        public List<DateRangeDTO> getTotalAvailability() {
                return totalAvailability;
        }

        public void setTotalAvailability(List<DateRangeDTO> totalAvailability) {
                this.totalAvailability = totalAvailability;
        }

        @Override
        public String toString() {
                return "EventAvailabilityDTO{" +
                        "users=" + users +
                        ", totalAvailability=" + totalAvailability +
                        '}';
        }
}
