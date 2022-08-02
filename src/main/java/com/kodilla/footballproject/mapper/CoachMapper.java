package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.dto.CoachDto;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.service.TeamDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoachMapper {

    private final TeamDBService teamDBService;
    private final TeamCoachMapper teamCoachMapper;

    public Coach mapToCoach(final CoachDto coachDto) throws TeamNotFoundException {
        return new Coach(
                coachDto.getId(),
                coachDto.getFirstname(),
                coachDto.getLastname(),
                coachDto.getBday(),
                coachDto.getDescription(),
                teamDBService.getTeamById(coachDto.getTeamId()),
                teamCoachMapper.mapToTeamCoachList(coachDto.getTeamCoachDtos())
        );
    }

    public CoachDto mapToCoachDto(final Coach coach) throws TeamNotFoundException {
        return new CoachDto(
                coach.getId(),
                coach.getFirstname(),
                coach.getLastname(),
                coach.getBday(),
                coach.getDescription(),
                coach.getTeam().getId(),
                teamCoachMapper.mapToTeamCoachDtoList(coach.getTeamCoaches())
        );
    }

    public List<CoachDto> mapToCoachDtoList(List<Coach> coachList) {
        List<CoachDto> collect = new ArrayList<>();
        for (Coach coach : coachList) {
            CoachDto coachDto = null;
            try {
                coachDto = mapToCoachDto(coach);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(coachDto);
        }
        return collect;
    }

    public List<Coach> mapToCoachList(List<CoachDto> coachDtoList) {
        List<Coach> collect = new ArrayList<>();
        for (CoachDto coachDto : coachDtoList) {
            Coach coach = null;
            try {
                coach = mapToCoach(coachDto);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(coach);
        }
        return collect;
    }
}
