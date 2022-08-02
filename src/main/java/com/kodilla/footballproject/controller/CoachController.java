package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.dto.CoachDto;
import com.kodilla.footballproject.exception.CoachNotFoundException;
import com.kodilla.footballproject.exception.TeamCoachNotFoundException;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.mapper.CoachMapper;
import com.kodilla.footballproject.service.CoachDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("v1/coaches")
@RequiredArgsConstructor
public class CoachController {

    private final CoachDBService coachDBService;
    private final CoachMapper coachMapper;

    @GetMapping
    public ResponseEntity<List<CoachDto>> getCoaches() {
        List<Coach> coaches = coachDBService.getAllCoaches();
        return ResponseEntity.ok(coachMapper.mapToCoachDtoList(coaches));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCoach(@RequestBody CoachDto coachDto) throws TeamNotFoundException {
        Coach coach = coachMapper.mapToCoach(coachDto);
        coachDBService.saveCoach(coach);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{coachId}")
    public ResponseEntity<CoachDto> getCoach(@PathVariable Long coachId) throws TeamNotFoundException, CoachNotFoundException {
        return ResponseEntity.ok(coachMapper.mapToCoachDto(coachDBService.getCoachById(coachId)));
    }

    @PutMapping
    public ResponseEntity<CoachDto> updateCoach(@RequestBody CoachDto coachDto) throws TeamNotFoundException {
        Coach coach = coachMapper.mapToCoach(coachDto);
        Coach savedCoach = coachDBService.saveCoach(coach);
        return ResponseEntity.ok(coachMapper.mapToCoachDto(savedCoach));
    }

    @DeleteMapping(value = "{coachId}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long coachId) {
        coachDBService.deleteCoach(coachId);
        return ResponseEntity.ok().build();
    }
}
