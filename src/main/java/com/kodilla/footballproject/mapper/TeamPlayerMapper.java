package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.TeamPlayer;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.dto.TeamPlayerDto;
import com.kodilla.footballproject.exception.PlayerNotFoundException;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.service.PlayerDBService;
import com.kodilla.footballproject.service.TeamDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamPlayerMapper {

    private final PlayerDBService playerDBService;
    private final TeamDBService teamDBService;

    public TeamPlayer mapToTeamPlayer(final TeamPlayerDto teamPlayerDto) throws PlayerNotFoundException, TeamNotFoundException {
        return new TeamPlayer(
                teamPlayerDto.getId(),
                teamPlayerDto.isPlayingNow(),
                teamPlayerDto.getStartOfPlaying(),
                playerDBService.getPlayerById(teamPlayerDto.getPlayerId()),
                teamDBService.getTeamById(teamPlayerDto.getTeamId())
        );
    }

    public TeamPlayerDto mapToTeamPlayerDto(final TeamPlayer teamPlayer) throws PlayerNotFoundException, TeamNotFoundException {
        return new TeamPlayerDto(
                teamPlayer.getId(),
                teamPlayer.isPlayingNow(),
                teamPlayer.getStartOfPlaying(),
                teamPlayer.getPlayer().getId(),
                teamPlayer.getTeam().getId()
        );
    }

    public List<TeamPlayerDto> mapToTeamPlayerDtoList(List<TeamPlayer> teamPlayerList) {
        List<TeamPlayerDto> collect = new ArrayList<>();
        for (TeamPlayer teamPlayer : teamPlayerList) {
            TeamPlayerDto teamPlayerDto = null;
            try {
                teamPlayerDto = mapToTeamPlayerDto(teamPlayer);
            } catch (PlayerNotFoundException | TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(teamPlayerDto);
        }
        return collect;
    }

    public List<TeamPlayer> mapToTeamPlayerList(List<TeamPlayerDto> teamPlayerDtosList) {
        List<TeamPlayer> collect = new ArrayList<>();
        for (TeamPlayerDto teamPlayerDto : teamPlayerDtosList) {
            TeamPlayer teamPlayer = null;
            try {
                teamPlayer = mapToTeamPlayer(teamPlayerDto);
            } catch (PlayerNotFoundException | TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(teamPlayer);
        }
        return collect;
    }
}
