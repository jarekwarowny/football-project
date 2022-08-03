package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.domain.Team;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.dto.TeamDto;
import com.kodilla.footballproject.mapper.PlayerMapper;
import com.kodilla.footballproject.mapper.TeamMapper;
import com.kodilla.footballproject.service.PlayerDBService;
import com.kodilla.footballproject.service.TeamDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitConfig
@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamMapper teamMapper;

    @MockBean
    private TeamDBService teamDBService;

    @Test
    void getTeamsTest() throws Exception {
        List<Team> teams = List.of(new Team("Bay", "Bayern Munchen"));
        when(teamDBService.getAllTeams()).thenReturn(teams);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/teams")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getTeamTest() throws Exception {
        Team team = new Team("CHE", "Chealse");
        when(teamDBService.getTeamById(13L)).thenReturn(team);
        TeamDto teamDto = new TeamDto(13L, "ARS", "Arsenal", null, null, null, null, null, null, null);
        when(teamMapper.mapToTeamDto(team)).thenReturn(teamDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/teams/13")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}

