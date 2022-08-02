package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.Match;
import com.kodilla.footballproject.exception.MatchNotFoundException;
import com.kodilla.footballproject.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchDBService {

    private final MatchRepository matchRepository;

    public List<Match> getAllMetches() {
        return matchRepository.findAll();
    }

    public Match getMatchById(final Long matchId) throws MatchNotFoundException {
        return matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);
    }

    public Match saveMatch(final Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(final Long matchId) {
        matchRepository.deleteById(matchId);
    }
}
