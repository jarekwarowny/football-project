package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachDto {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate bday;
    private String description;
    private Long teamId;
    private List<TeamCoachDto> teamCoachDtos;
}
