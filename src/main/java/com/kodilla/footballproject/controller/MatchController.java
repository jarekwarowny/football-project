package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Match;
import com.kodilla.footballproject.dto.CoachDto;
import com.kodilla.footballproject.dto.MatchDto;
import com.kodilla.footballproject.exception.MatchNotFoundException;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.mapper.MatchMapper;
import com.kodilla.footballproject.service.MatchDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchMapper matchMapper;
    private final MatchDBService matchDBService;

    @GetMapping
    public ResponseEntity<List<MatchDto>> getMatches() {
        List<Match> matches = matchDBService.getAllMetches();
        return ResponseEntity.ok(matchMapper.mapToMatchDtoList(matches));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createMatch(@RequestBody MatchDto matchDto) {
        Match match = matchMapper.mapToMatch(matchDto);
        matchDBService.saveMatch(match);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{matchId}")
    public ResponseEntity<MatchDto> getMatch(@PathVariable Long matchId) throws MatchNotFoundException {
        return ResponseEntity.ok(matchMapper.mapToMatchDto(matchDBService.getMatchById(matchId)));
    }

    @PutMapping
    public ResponseEntity<MatchDto> updateMatch(@RequestBody MatchDto matchDto) {
        Match match = matchMapper.mapToMatch(matchDto);
        Match savedMatch = matchDBService.saveMatch(match);
        return ResponseEntity.ok(matchMapper.mapToMatchDto(savedMatch));
    }

    @DeleteMapping(value = "{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long matchId) {
        matchDBService.deleteMatch(matchId);
        return ResponseEntity.ok().build();
    }
}
