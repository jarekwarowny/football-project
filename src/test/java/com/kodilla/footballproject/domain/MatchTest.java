package com.kodilla.footballproject.domain;

import com.kodilla.footballproject.repository.MatchRepository;
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
public class MatchTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Test
    public void createMatch() {
        //Given
        Match match = new Match(null, "FCB vs ARS", null,  null);
        Team team1 = new Team("FCB", "BAYER");
        Team team2 = new Team("ARS", "ARSENAL");

        //When
        Match saveMatch = matchRepository.save(match);
        Long saveMatchId = saveMatch.getId();
        Team saveTeam1 = teamRepository.save(team1);
        Team saveTeam2 = teamRepository.save(team2);

        //Then
        Assertions.assertTrue(teamRepository.existsById(saveTeam1.getId()));
        Assertions.assertTrue(teamRepository.existsById(saveTeam2.getId()));
        Assertions.assertTrue(matchRepository.existsById(saveMatchId));

        //Clean
        teamRepository.deleteById(saveTeam1.getId());
        teamRepository.deleteById(saveTeam2.getId());
        matchRepository.deleteById(saveMatchId);
    }

    @Test
    public void readMatch() {
        //Given
        Match match = new Match(null, "FCB vs ARS", null,  null);
        Team team1 = new Team("FCB", "BAYER");
        Team team2 = new Team("ARS", "ARSENAL");

        //When
        Match saveMatch = matchRepository.save(match);
        Long saveMatchId = saveMatch.getId();
        Team saveTeam1 = teamRepository.save(team1);
        Team saveTeam2 = teamRepository.save(team2);

        Optional<Match> readMatch = matchRepository.findById(saveMatchId);
        Optional<Team> readTeam1 = teamRepository.findById(saveTeam1.getId());
        Optional<Team> readTeam2 = teamRepository.findById(saveTeam2.getId());

        //Then
        Assertions.assertTrue(readMatch.isPresent());
        Assertions.assertTrue(readTeam1.isPresent());
        Assertions.assertTrue(readTeam2.isPresent());

        //Clean
        teamRepository.deleteById(saveTeam1.getId());
        teamRepository.deleteById(saveTeam2.getId());
        matchRepository.deleteById(saveMatchId);
    }

    @Test
    public void deleteMatch() {
        //Given
        Match match = new Match(null, "FCB vs ARS", null,  null);
        Team team1 = new Team("FCB", "BAYER");
        Team team2 = new Team("ARS", "ARSENAL");

        //When
        Match saveMatch = matchRepository.save(match);
        Long saveMatchId = saveMatch.getId();
        Team saveTeam1 = teamRepository.save(team1);
        Team saveTeam2 = teamRepository.save(team2);

        teamRepository.deleteById(saveTeam1.getId());
        teamRepository.deleteById(saveTeam2.getId());
        matchRepository.deleteById(saveMatchId);

        //Then
        Assertions.assertFalse(teamRepository.existsById(saveTeam1.getId()));
        Assertions.assertFalse(teamRepository.existsById(saveTeam2.getId()));
        Assertions.assertFalse(matchRepository.existsById(saveMatchId));
    }
}
