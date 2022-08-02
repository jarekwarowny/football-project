package com.kodilla.footballproject.service;

import com.kodilla.footballproject.dto.WeatherDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private Double currentTemp;
    private Integer humidity;
    private final String apiKey = "2042e48d1240bf53a60881fffc69ed4e";

    //Every hour
    @Scheduled(cron = "0 0 * * * * *")
    public void getCurrentWeather() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDto weatherDto = restTemplate.getForObject("https://api.openweathermap.org/data/3.0/onecall?lat=2&lon=41&exclude=hourly,daily,minutely,allerts&appid=" + apiKey, WeatherDto.class);
        currentTemp = weatherDto.getCurrentTemp();
        humidity = weatherDto.getCurrentHumidity();
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public Integer getHumidity() {
        return humidity;
    }
}
