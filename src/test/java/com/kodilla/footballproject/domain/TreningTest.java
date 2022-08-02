package com.kodilla.footballproject.domain;

import com.kodilla.footballproject.repository.TeamRepository;
import com.kodilla.footballproject.repository.TreningRepository;
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
public class TreningTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TreningRepository treningRepository;

    @Test
    public void createTrening() {
        //Given
        Trening trening = new Trening(null, "Run", null);
        Team team = new Team("AJA", "AJAX");

        //When
        Trening saveTrening = treningRepository.save(trening);
        Long saveTreningId = saveTrening.getId();
        Team saveTeam = teamRepository.save(team);

        //Then
        Assertions.assertTrue(teamRepository.existsById(saveTeam.getId()));
        Assertions.assertTrue(treningRepository.existsById(saveTreningId));

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        treningRepository.deleteById(saveTreningId);
    }

    @Test
    public void readTrening() {
        //Given
        Trening trening = new Trening(null, "Run", null);
        Team team = new Team("AJA", "AJAX");

        //When
        Trening saveTrening = treningRepository.save(trening);
        Long saveTreningId = saveTrening.getId();
        Team saveTeam = teamRepository.save(team);

        Optional<Trening> readTrening = treningRepository.findById(saveTreningId);
        Optional<Team> readTeam = teamRepository.findById(saveTeam.getId());

        //Then
        Assertions.assertTrue(readTeam.isPresent());
        Assertions.assertTrue(readTrening.isPresent());

        //Clean
        teamRepository.deleteById(saveTeam.getId());
        treningRepository.deleteById(saveTreningId);
    }

    @Test
     public void deleteTrening() {
        //Given
        Trening trening = new Trening(null, "Run", null);
        Team team = new Team("AJA", "AJAX");

        //When
        Trening saveTrening = treningRepository.save(trening);
        Long saveTreningId = saveTrening.getId();
        Team saveTeam = teamRepository.save(team);

        teamRepository.deleteById(saveTeam.getId());
        treningRepository.deleteById(saveTreningId);

        //Then
        Assertions.assertFalse(teamRepository.existsById(saveTeam.getId()));
        Assertions.assertFalse(treningRepository.existsById(saveTreningId));
    }
}
