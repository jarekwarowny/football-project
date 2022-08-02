package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private String description;
    private List<PlayerDto> playerDtos;
    private List<CoachDto> coachDtos;
    private List<TreningDto> treningDtos;
    private List<MatchDto> matchDtosAs1;
    private List<MatchDto> matchDtosAs2;
    private List<TeamPlayerDto> teamPlayerDtos;
    private List<TeamCoachDto> teamCoachDtos;
}
