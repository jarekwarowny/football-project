package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamCoachDto {

    private Long id;
    private boolean isCoachingNow;
    private LocalDate startOfCoaching;
    private Long coachId;
    private Long teamId;
}
