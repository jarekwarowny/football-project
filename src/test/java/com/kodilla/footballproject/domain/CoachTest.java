package com.kodilla.footballproject.domain;

import com.kodilla.footballproject.repository.CoachRepository;
import com.kodilla.footballproject.repository.TeamCoachRepository;
import com.kodilla.footballproject.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoachTest {

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void createCoach() {
        //Given
        Coach coach = new Coach("Piotr", "Bak", null, "Main coach", null);
        Team team = new Team("FCB", "Football Club Bayer");

        //When
        Coach saveCoach = coachRepository.save(coach);
        saveCoach.getTeam();
        Long saveCoachId = saveCoach.getId();
        Team saveTeam = teamRepository.save(team);

        //Then
        Assertions.assertTrue(teamRepository.existsById(saveTeam.getId()));
        Assertions.assertTrue(coachRepository.existsById(saveCoachId));

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        coachRepository.deleteById(saveCoachId);
    }

    @Test
    public void readCoach() {
        //Given
        Coach coach = new Coach("Piotr", "Bak", null, "Main coach", null);
        Team team = new Team("FCB", "Football Club Bayer");

        //When
        Coach saveCoach = coachRepository.save(coach);
        saveCoach.getTeam();
        Long saveCoachId = saveCoach.getId();
        Team saveTeam = teamRepository.save(team);

        Optional<Coach> readCoach = coachRepository.findById(saveCoachId);
        Optional<Team> readTeam = teamRepository.findById(saveTeam.getId());

        //Then
        Assertions.assertTrue(readCoach.isPresent());
        Assertions.assertTrue(readTeam.isPresent());

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        coachRepository.deleteById(saveCoachId);
    }

    @Test
    public void deleteCoach() {
        //Given
        Coach coach = new Coach("Piotr", "Bak", null, "Main coach", null);
        Team team = new Team("FCB", "Football Club Bayer");

        //When
        Coach saveCoach = coachRepository.save(coach);
        saveCoach.getTeam();
        Long saveCoachId = saveCoach.getId();
        Team saveTeam = teamRepository.save(team);

        teamRepository.deleteById(saveTeam.getId());
        coachRepository.deleteById(saveCoachId);

        //Then
        Assertions.assertFalse(coachRepository.existsById(saveCoachId));
        Assertions.assertFalse(teamRepository.existsById(saveTeam.getId()));
    }
}
