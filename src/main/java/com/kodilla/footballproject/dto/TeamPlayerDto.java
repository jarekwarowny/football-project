package com.kodilla.footballproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDto {

    private Long id;
    private boolean isPlayingNow;
    private LocalDate startOfPlaying;
    private Long playerId;
    private Long teamId;
}
