package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private Long id;
    private LocalDate dateOfMatch;
    private String description;
    private Long team1Id;
    private Long team2Id;
}
