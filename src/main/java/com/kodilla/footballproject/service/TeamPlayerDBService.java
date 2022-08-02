package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.TeamPlayer;
import com.kodilla.footballproject.exception.TeamPlayerNotFoundException;
import com.kodilla.footballproject.repository.TeamPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamPlayerDBService {

    public final TeamPlayerRepository teamPlayerRepository;

    public List<TeamPlayer> getAllTeamPlayers() {
        return teamPlayerRepository.findAll();
    }

    public TeamPlayer getTeamPlayer(final Long teamPlayerId) throws TeamPlayerNotFoundException {
        return teamPlayerRepository.findById(teamPlayerId).orElseThrow(TeamPlayerNotFoundException::new);
    }

    public TeamPlayer saveTeamPlayer(final TeamPlayer teamPlayer) {
        return teamPlayerRepository.save(teamPlayer);
    }

    public void deleteTeamPlayer(final Long teamPlayerId) {
        teamPlayerRepository.deleteById(teamPlayerId);
    }
}
