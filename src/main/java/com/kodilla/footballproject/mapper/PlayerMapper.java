package com.kodilla.footballproject.mapper;


import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.service.TeamDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerMapper {

    private final TeamDBService teamDBService;
    private final TeamPlayerMapper teamPlayerMapper;

    public Player mapToPlayer(final PlayerDto playerDto) throws TeamNotFoundException {
        return new Player(
                playerDto.getId(),
                playerDto.getFirstname(),
                playerDto.getLastname(),
                playerDto.getBday(),
                playerDto.getPosition(),
                teamDBService.getTeamById(playerDto.getTeamId()),
                teamPlayerMapper.mapToTeamPlayerList(playerDto.getTeamPlayerDtos())
        );
    }

    public PlayerDto mapToPlayerDto(final Player player) throws TeamNotFoundException {
        return new PlayerDto(
                player.getId(),
                player.getFirstname(),
                player.getLastname(),
                player.getBday(),
                player.getPosition(),
                player.getTeam().getId(),
                teamPlayerMapper.mapToTeamPlayerDtoList(player.getTeamPlayers())
        );
    }

    public List<PlayerDto> mapToPlayerDtoList(List<Player> playerList) {
        List<PlayerDto> collect = new ArrayList<>();
        for (Player player : playerList) {
            PlayerDto playerDto = null;
            try {
                playerDto = mapToPlayerDto(player);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(playerDto);
        }
        return collect;
    }

    public List<Player> mapToPlayerList(List<PlayerDto>  playerDtoList) {
        List<Player> collect = new ArrayList<>();
        for (PlayerDto playerDto : playerDtoList) {
            Player player = null;
            try {
                player = mapToPlayer(playerDto);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(player);
        }
        return collect;
    }
}
