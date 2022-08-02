package com.kodilla.footballproject.dto;

import com.kodilla.footballproject.domain.Trening;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreningDto {

    private Long id;
    private LocalDate dateOfTrening;
    private String description;
    private Long teamId;

    public static TreningDto factoryMethod(Trening trening) {
           return new TreningDto(
                   trening.getId(),
                   trening.getDateOfTrening(),
                   trening.getDescription(),
                   trening.getTeam().getId()
           );
    }
}
