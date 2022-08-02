package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.Team;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamDBService {

    private final TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(final Long teamId) throws TeamNotFoundException {
        return teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    }

    public Team saveTeam(final Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(final Long teamId) {
        teamRepository.deleteById(teamId);
    }
}
