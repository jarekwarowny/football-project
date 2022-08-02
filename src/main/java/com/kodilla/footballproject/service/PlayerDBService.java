package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.exception.PlayerNotFoundException;
import com.kodilla.footballproject.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerDBService {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(final Long playerId) throws PlayerNotFoundException {
        return playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
    }

    public Player savePlayer(final Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(final Long playerId) {
        playerRepository.deleteById(playerId);
    }
}
