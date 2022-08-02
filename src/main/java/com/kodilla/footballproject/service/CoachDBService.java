package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.exception.CoachNotFoundException;
import com.kodilla.footballproject.repository.CoachRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.annotation.ServletSecurity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachDBService {

    private final CoachRepository coachRepository;

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Coach getCoachById(final Long coachId) throws CoachNotFoundException {
        return coachRepository.findById(coachId).orElseThrow(CoachNotFoundException::new);
    }

    public Coach saveCoach(final Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteCoach(final Long coachId) {
        coachRepository.deleteById(coachId);
    }
}
