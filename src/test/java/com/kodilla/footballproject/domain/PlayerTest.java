package com.kodilla.footballproject.domain;

import com.kodilla.footballproject.repository.PlayerRepository;
import com.kodilla.footballproject.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void createPlayer() {
        //Given
        Player player = new Player("Leo", "Messi", null, "ST", null);
        Team team = new Team("BAR", "BARCELONA");

        //When
        Player savePlayer = playerRepository.save(player);
        Long savePlayerId = savePlayer.getId();
        Team saveTeam = teamRepository.save(team);

        //Then
        Assertions.assertTrue(teamRepository.existsById(saveTeam.getId()));
        Assertions.assertTrue(playerRepository.existsById(savePlayerId));

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        playerRepository.deleteById(savePlayerId);
    }

    @Test
    public void readPlayer() {
        //Given
        Player player = new Player("Leo", "Messi", null, "ST", null);
        Team team = new Team("BAR", "BARCELONA");

        //When
        Player savePlayer = playerRepository.save(player);
        Long savePlayerId = savePlayer.getId();
        Team saveTeam = teamRepository.save(team);

        Optional<Player> readPlayer = playerRepository.findById(savePlayerId);
        Optional<Team> readTeam = teamRepository.findById(saveTeam.getId());

        //Then
        Assertions.assertTrue(readTeam.isPresent());
        Assertions.assertTrue(readPlayer.isPresent());

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        playerRepository.deleteById(savePlayerId);
    }

    @Test
    public void deletePlayer() {
        //Given
        Player player = new Player("Leo", "Messi", null, "ST", null);
        Team team = new Team("BAR", "BARCELONA");

        //When
        Player savePlayer = playerRepository.save(player);
        Long savePlayerId = savePlayer.getId();
        Team saveTeam = teamRepository.save(team);

        teamRepository.deleteById(saveTeam.getId());
        playerRepository.deleteById(savePlayerId);

        //Then
        Assertions.assertFalse(playerRepository.existsById(savePlayerId));
        Assertions.assertFalse(teamRepository.existsById(saveTeam.getId()));
    }
}
