package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Trening;
import com.kodilla.footballproject.dto.TeamDto;
import com.kodilla.footballproject.dto.TreningDto;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.exception.TreningNotFoundException;
import com.kodilla.footballproject.mapper.TreningMapper;
import com.kodilla.footballproject.service.TreningDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trenings")
@RequiredArgsConstructor
public class TreningController {

    private final TreningMapper treningMapper;
    private final TreningDBService treningDBService;

    @GetMapping
    public ResponseEntity<List<TreningDto>> getTrenings() {
        List<Trening> trenings = treningDBService.getTrenings();
        return ResponseEntity.ok(treningMapper.mapToTreningDtoList(trenings));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTrening(@RequestBody TreningDto treningDto) throws TeamNotFoundException {
        Trening trening = treningMapper.mapToTrening(treningDto);
        treningDBService.saveTrening(trening);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{treningId}")
    public ResponseEntity<TreningDto> getTrening(@PathVariable Long treningId) throws TreningNotFoundException, TeamNotFoundException {
        return ResponseEntity.ok(treningMapper.mapToTreningDto(treningDBService.getTrening(treningId)));
    }

    @PutMapping
    private ResponseEntity<TreningDto> updateTrening(@RequestBody TreningDto treningDto) throws TeamNotFoundException {
        Trening trening = treningMapper.mapToTrening(treningDto);
        Trening savedTrening = treningDBService.saveTrening(trening);
        return ResponseEntity.ok(treningMapper.mapToTreningDto(savedTrening));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTrening(@PathVariable Long treningId) {
        treningDBService.deleteTrening(treningId);
        return ResponseEntity.ok().build();
    }
}
