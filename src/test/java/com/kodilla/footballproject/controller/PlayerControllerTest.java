package com.kodilla.footballproject.controller;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.dto.CoachDto;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.mapper.CoachMapper;
import com.kodilla.footballproject.mapper.PlayerMapper;
import com.kodilla.footballproject.service.CoachDBService;
import com.kodilla.footballproject.service.PlayerDBService;
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
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerMapper playerMapper;

    @MockBean
    private PlayerDBService playerDBService;

    @Test
    void getPlayersTest() throws Exception {
        List<Player> players = List.of(new Player("Robert", "Lewandowski", null, "ST", null));
        when(playerDBService.getAllPlayers()).thenReturn(players);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/players")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getPlayerTest() throws Exception {
        Player player = new Player("AAA", "BBB", null, "MID", null);
        when(playerDBService.getPlayerById(13L)).thenReturn(player);
        PlayerDto playerDto = new PlayerDto(13L, "AAA", "BBB", null, "CCC", 1L, null);
        when(playerMapper.mapToPlayerDto(player)).thenReturn(playerDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/players/13")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
