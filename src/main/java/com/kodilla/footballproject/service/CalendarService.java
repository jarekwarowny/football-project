package com.kodilla.footballproject.service;

import com.kodilla.footballproject.dto.CalendarDto;
import com.kodilla.footballproject.dto.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class CalendarService {

    private LocalDate date;
    private final String apiKey = "957J_lK6Ry98hHFNaLmwUUiVJrM";

    public void getCaledner() {
        RestTemplate restTemplate = new RestTemplate();
        CalendarDto calendarDto = restTemplate.getForObject("https://www.googleapis.com/calendar/v3/calendars/" + apiKey, CalendarDto.class);
        date = calendarDto.getDate();

    }
}
