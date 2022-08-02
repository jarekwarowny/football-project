package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate bday;
    private String position;
    private Long teamId;
    private List<TeamPlayerDto> teamPlayerDtos;
}
