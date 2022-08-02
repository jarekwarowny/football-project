package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.domain.TeamCoach;
import com.kodilla.footballproject.dto.TeamCoachDto;
import com.kodilla.footballproject.exception.CoachNotFoundException;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.service.CoachDBService;
import com.kodilla.footballproject.service.TeamDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCoachMapper {

    private final CoachDBService coachDBService;
    private final TeamDBService teamDBService;

    public TeamCoach mapToTeamCoach(final TeamCoachDto teamCoachDto) throws TeamNotFoundException, CoachNotFoundException {
        return new TeamCoach(
                teamCoachDto.getCoachId(),
                teamCoachDto.isCoachingNow(),
                teamCoachDto.getStartOfCoaching(),
                coachDBService.getCoachById(teamCoachDto.getCoachId()),
                teamDBService.getTeamById(teamCoachDto.getTeamId())
        );
    }

    public TeamCoachDto mapToTeamCoachDto(final TeamCoach teamCoach) throws TeamNotFoundException, CoachNotFoundException {
        return new TeamCoachDto(
                teamCoach.getId(),
                teamCoach.isCoachingNow(),
                teamCoach.getStartOfCoaching(),
                teamCoach.getCoach().getId(),
                teamCoach.getTeam().getId()
        );
    }

    public List<TeamCoachDto> mapToTeamCoachDtoList(List<TeamCoach> teamCoachList) {
        List<TeamCoachDto> collect = new ArrayList<>();
        for (TeamCoach teamCoach : teamCoachList) {
            TeamCoachDto teamCoachDto =  null;
            try {
                teamCoachDto = mapToTeamCoachDto(teamCoach);
            } catch (CoachNotFoundException | TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(teamCoachDto);
        }
        return collect;
    }

    public List<TeamCoach> mapToTeamCoachList(List<TeamCoachDto> teamCoachDtoList) {
        List<TeamCoach> collect = new ArrayList<>();
        for (TeamCoachDto teamCoachDto : teamCoachDtoList) {
            TeamCoach teamCoach = null;
            try {
                teamCoach = mapToTeamCoach(teamCoachDto);
            } catch (TeamNotFoundException | CoachNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(teamCoach);
        }
        return collect;
    }
}
