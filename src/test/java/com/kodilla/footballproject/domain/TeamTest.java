package com.kodilla.footballproject.domain;

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
public class TeamTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void createTeam() {
        //Given
        Team team = new Team("CHE", "CHELSEA");

        //When
        Team saveTeam = teamRepository.save(team);
        Long saveTeamId = saveTeam.getId();

        //Then
        Assertions.assertTrue(teamRepository.existsById(saveTeamId));

        //Clean
        teamRepository.deleteById(saveTeamId);
    }

    @Test
    public void readTeam() {
        //Given
        Team team = new Team("CHE", "CHELSEA");

        //When
        Team saveTeam = teamRepository.save(team);
        Long saveTeamId = saveTeam.getId();

        Optional<Team> readTeam = teamRepository.findById(saveTeamId);

        //Then
        Assertions.assertTrue(readTeam.isPresent());

        //Clean
        teamRepository.deleteById(saveTeamId);
    }
}
