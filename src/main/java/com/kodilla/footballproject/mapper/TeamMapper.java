package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.Team;
import com.kodilla.footballproject.dto.TeamDto;
import com.kodilla.footballproject.exception.*;
import com.kodilla.footballproject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMapper {

    private final PlayerMapper playerMapper;
    private final CoachMapper coachMapper;
    private final TreningMapper treningMapper;
    private final MatchMapper matchMapper;
    private final TeamPlayerMapper teamPlayerMapper;
    private final TeamCoachMapper teamCoachMapper;

    public TeamDto mapToTeamDto(Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getDescription(),
                playerMapper.mapToPlayerDtoList(team.getPlayers()),
                coachMapper.mapToCoachDtoList(team.getCoaches()),
                treningMapper.mapToTreningDtoList(team.getTrenings()),
                matchMapper.mapToMatchDtoList(team.getMatchesAs1()),
                matchMapper.mapToMatchDtoList(team.getMatchesAs2()),
                teamPlayerMapper.mapToTeamPlayerDtoList(team.getTeamPlayers()),
                teamCoachMapper.mapToTeamCoachDtoList(team.getTeamCoaches())
        );
    }

    public Team mapToTeam(TeamDto teamDto) {
        return new Team(
                teamDto.getId(),
                teamDto.getName(),
                teamDto.getDescription(),
                playerMapper.mapToPlayerList(teamDto.getPlayerDtos()),
                coachMapper.mapToCoachList(teamDto.getCoachDtos()),
                treningMapper.mapToTreningList(teamDto.getTreningDtos()),
                teamDto.getMatchDtosAs1().stream().map(matchMapper::mapToMatch).collect(Collectors.toList()),
                teamDto.getMatchDtosAs2().stream().map(matchMapper::mapToMatch).collect(Collectors.toList()),
                teamPlayerMapper.mapToTeamPlayerList(teamDto.getTeamPlayerDtos()),
                teamCoachMapper.mapToTeamCoachList(teamDto.getTeamCoachDtos())
        );
    }
}
