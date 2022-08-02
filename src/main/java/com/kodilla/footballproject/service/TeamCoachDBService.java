package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.TeamCoach;
import com.kodilla.footballproject.exception.TeamCoachNotFoundException;
import com.kodilla.footballproject.repository.TeamCoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCoachDBService {

    private final TeamCoachRepository teamCoachRepository;

    public List<TeamCoach> getAllTeamCoaches() {
        return teamCoachRepository.findAll();
    }

    public TeamCoach getTeamCoach(final Long teamCoachId) throws TeamCoachNotFoundException {
        return teamCoachRepository.findById(teamCoachId).orElseThrow(TeamCoachNotFoundException::new);
    }

    public TeamCoach saveTeamCoach(final TeamCoach teamCoach) {
        return teamCoachRepository.save(teamCoach);
    }

    public void deleteTeamCoach(final Long teamCoachId) {
        teamCoachRepository.deleteById(teamCoachId);
    }
}
