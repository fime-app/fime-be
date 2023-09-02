package com.fimeproject.fimebe.rest;

import com.fimeproject.fimebe.dto.*;
import com.fimeproject.fimebe.entity.Availability;
import com.fimeproject.fimebe.entity.AvailabilityTimeBlock;
import com.fimeproject.fimebe.service.AvailabilityService;
import com.fimeproject.fimebe.service.AvailabilityTimeBlockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AvailabilityRestController {
    private AvailabilityService availabilityService;

    private AvailabilityTimeBlockService availabilityTimeblockService;

    public AvailabilityRestController(AvailabilityService availabilityService, AvailabilityTimeBlockService availabilityTimeblockService) {
        this.availabilityService = availabilityService;
        this.availabilityTimeblockService = availabilityTimeblockService;
    }


    public List<DateRangeDTO> calculateCommonFreeTimeRanges(List<AvailabilityTimeBlockDTO> availabilityList) {
        // Get the time blocks for the first participant
        List<DateRangeDTO> commonDateRanges = new ArrayList<>(availabilityList.get(0).getAvailableDates());

        // Iterate over the remaining participants
        for (int i = 1; i < availabilityList.size(); i++) {
            List<DateRangeDTO> participantTimeBlocks = availabilityList.get(i).getAvailableDates();
            List<DateRangeDTO> overlappingRanges = new ArrayList<>();

            // Compare each time block of the current participant with the commonDateRanges
            for (DateRangeDTO commonRange : commonDateRanges) {
                for (DateRangeDTO participantRange : participantTimeBlocks) {
                    LocalDateTime commonStart = commonRange.getStartDate().toLocalDateTime();
                    LocalDateTime commonEnd = commonRange.getEndDate().toLocalDateTime();
                    LocalDateTime participantStart = participantRange.getStartDate().toLocalDateTime();
                    LocalDateTime participantEnd = participantRange.getEndDate().toLocalDateTime();

                    // Check if the time slots overlap
                    if (commonStart.isBefore(participantEnd) && commonEnd.isAfter(participantStart)) {
                        LocalDateTime overlapStart = commonStart.isAfter(participantStart) ? commonStart : participantStart;
                        LocalDateTime overlapEnd = commonEnd.isBefore(participantEnd) ? commonEnd : participantEnd;

                        // Add overlapping range to overlappingRanges if it doesn't already exist
                        DateRangeDTO overlappingRange = new DateRangeDTO(Timestamp.valueOf(overlapStart), Timestamp.valueOf(overlapEnd));
                        if (!overlappingRanges.contains(overlappingRange)) {
                            overlappingRanges.add(overlappingRange);
                        }
                    }
                }
            }

            // Update the commonDateRanges with the overlappingRanges
            commonDateRanges = overlappingRanges;
        }

        return commonDateRanges;
    }

    public static List<DateRangeDTO> removeDuplicateDateRanges(List<DateRangeDTO> dateRanges) {
        Set<String> uniqueDateRanges = new HashSet<>();
        for (DateRangeDTO dateRange : dateRanges) {
            // Check if the set already contains a DateRangeDTO with the same start and end dates
            String s = dateRange.getStartDate().toString() + "\n" + dateRange.getEndDate().toString();
            if (!uniqueDateRanges.contains(dateRange)) {
                uniqueDateRanges.add(s);
            }
        }

        List<DateRangeDTO> noDups = new ArrayList<>();

        for (String s : uniqueDateRanges) {
            Timestamp start = Timestamp.valueOf(s.split("\n")[0]);
            Timestamp end = Timestamp.valueOf(s.split("\n")[1]);
            DateRangeDTO drt = new DateRangeDTO(start, end);
            noDups.add(drt);
        }
        return noDups;
    }


    @GetMapping("/event/{id}")
    public EventAvailabilityDTO getAllById(@PathVariable int id) {
        List<AvailabilityTimeBlockDTO> availabilityTimeBlockDTOList = new ArrayList<>();
        List<Availability> availability = availabilityService.findByEventId(id);
        List<DateRangeDTO> allDateRanges = new ArrayList<>();
        for (Availability a : availability) {
            List<DateRangeDTO> dateRanges = new ArrayList<>();
            List<AvailabilityTimeBlock> availabilityTimeBlockList = availabilityTimeblockService.findTimeBlockByAvailabilityId(a.getId());
            for (AvailabilityTimeBlock atb : availabilityTimeBlockList){
                dateRanges.add(new DateRangeDTO(atb.getStartDate(), atb.getEndDate()));
                allDateRanges.add(new DateRangeDTO(atb.getStartDate(), atb.getEndDate()));
            }
            availabilityTimeBlockDTOList.add(new AvailabilityTimeBlockDTO(a.getUsername(), dateRanges));
        }

        List<DateRangeDTO> availabilityRanges = calculateCommonFreeTimeRanges(availabilityTimeBlockDTOList);
        List<DateRangeDTO> noDupAvailabilityRanges = removeDuplicateDateRanges(availabilityRanges);
        EventAvailabilityDTO result = new EventAvailabilityDTO(availabilityTimeBlockDTOList, noDupAvailabilityRanges);
        return result;
    }

    @PostMapping("/create-availability/{id}")
    public ResponseEntity<UserAvailabilityDTO> createAvailability(@RequestBody UserAvailabilityDTO userAvailabilityDTO, @PathVariable int id) {
        Availability createdAvailability = availabilityService.createAvailability(new Availability(userAvailabilityDTO.getUsername(), id));

        List<AvailabilityTimeBlock> dateRanges = new ArrayList<>();

        for (AvailabilityTimeBlock dr : userAvailabilityDTO.getAvailableDateRanges()) {
            AvailabilityTimeBlock createdAvailabilityTimeBlock = availabilityTimeblockService.createAvailabilityTimeBlock(new AvailabilityTimeBlock(dr.getStartDate(), dr.getEndDate(), createdAvailability.getId()));
            dateRanges.add(createdAvailabilityTimeBlock);
        }

        return new ResponseEntity<>(new UserAvailabilityDTO(userAvailabilityDTO.getUsername(), dateRanges), HttpStatus.CREATED);
    }
}
