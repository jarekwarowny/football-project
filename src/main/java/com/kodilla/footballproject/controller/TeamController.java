package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Team;
import com.kodilla.footballproject.dto.TeamDto;
import com.kodilla.footballproject.mapper.TeamMapper;
import com.kodilla.footballproject.service.TeamDBService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.build.Plugin;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamMapper teamMapper;
    private final TeamDBService teamDBService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getTeams() {
        List<Team> teams = teamDBService.getAllTeams();
        return ResponseEntity.ok(teams.stream().map(teamMapper::mapToTeamDto).collect(Collectors.toList()));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTeam(@RequestBody TeamDto teamDto) {
        Team team = teamMapper.mapToTeam(teamDto);
        teamDBService.saveTeam(team);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{teamId}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long teamId) {
        Team team = teamDBService.getTeamById(teamId);
        return ResponseEntity.ok(teamMapper.mapToTeamDto(team));
    }

    @PutMapping
    public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamDto) {
        Team team = teamMapper.mapToTeam(teamDto);
        Team savedTeam =teamDBService.saveTeam(team);
        return ResponseEntity.ok(teamMapper.mapToTeamDto(savedTeam));
    }

    @DeleteMapping(value = "{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamId) {
        teamDBService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }

}
