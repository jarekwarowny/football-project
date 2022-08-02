package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.exception.PlayerNotFoundException;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.mapper.PlayerMapper;
import com.kodilla.footballproject.service.PlayerDBService;
import lombok.RequiredArgsConstructor;
import org.atmosphere.config.service.Get;
import org.atmosphere.config.service.Put;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerMapper playerMapper;
    private final PlayerDBService playerDBService;

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getPlayers() {
        List<Player> players = playerDBService.getAllPlayers();
        return ResponseEntity.ok(playerMapper.mapToPlayerDtoList(players));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlayer(@RequestBody PlayerDto playerDto) throws TeamNotFoundException {
        Player player = playerMapper.mapToPlayer(playerDto);
        playerDBService.savePlayer(player);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{playerId}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable Long playerId) throws PlayerNotFoundException, TeamNotFoundException {
        return ResponseEntity.ok(playerMapper.mapToPlayerDto(playerDBService.getPlayerById(playerId)));
    }

    @PutMapping
    public ResponseEntity<PlayerDto> updatePlayer(@RequestBody PlayerDto playerDto) throws TeamNotFoundException {
        Player player = playerMapper.mapToPlayer(playerDto);
        Player savedPlayer = playerDBService.savePlayer(player);
        return ResponseEntity.ok(playerMapper.mapToPlayerDto(savedPlayer));
    }

    @DeleteMapping(value = "{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerDBService.deletePlayer(playerId);
        return ResponseEntity.ok().build();
    }
}
