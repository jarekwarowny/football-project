package com.kodilla.footballproject.controller;

import com.google.gson.Gson;
import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.dto.CoachDto;
import com.kodilla.footballproject.mapper.CoachMapper;
import com.kodilla.footballproject.service.CoachDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

@SpringJUnitConfig
@WebMvcTest(CoachController.class)
public class CoachControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoachMapper coachMapper;

    @MockBean
    private CoachDBService coachDBService;

    @Test
    void getCoachesTest() throws Exception {
        List<Coach> coaches = List.of(new Coach("AAA", "BBB", null, "Head Coach", null));
        when(coachDBService.getAllCoaches()).thenReturn(coaches);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/coaches")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void getCoachTest() throws Exception {
        Coach coach = new Coach("AAA", "BBB", null, "Head Coach", null);
        when(coachDBService.getCoachById(13L)).thenReturn(coach);
        CoachDto coachDto = new CoachDto(13L, "AAA", "BBB", null, "CCC", 1L, null);
        when(coachMapper.mapToCoachDto(coach)).thenReturn(coachDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/coaches/13")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
