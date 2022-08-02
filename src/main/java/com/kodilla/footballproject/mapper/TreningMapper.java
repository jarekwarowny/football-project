package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.Trening;
import com.kodilla.footballproject.dto.TreningDto;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.repository.TeamRepository;
import com.kodilla.footballproject.service.TeamDBService;
import com.kodilla.footballproject.service.TreningDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreningMapper {

    private final TeamRepository teamRepository;

    public Trening mapToTrening(final TreningDto treningDto) throws TeamNotFoundException {
        return new Trening(
                treningDto.getId(),
                treningDto.getDateOfTrening(),
                treningDto.getDescription(),
                teamRepository.findById(treningDto.getTeamId()).orElseThrow(TeamNotFoundException::new)
        );
    }

    public TreningDto mapToTreningDto(final Trening trening) throws TeamNotFoundException {
        return TreningDto.builder().id(
                trening.getId()).dateOfTrening(
                trening.getDateOfTrening()).description(
                trening.getDescription()).teamId(
                trening.getTeam().getId()).build();
    }

    public List<TreningDto> mapToTreningDtoList(List<Trening> treningList) {
        List<TreningDto> collect = new ArrayList<>();
        for (Trening trening : treningList) {
            TreningDto treningDto = null;
            try {
                if (trening.getTeam() == null) {
                    throw new TeamNotFoundException();
                }
                treningDto = TreningDto.factoryMethod(trening);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(treningDto);
        }
        return collect;
    }

    public List<Trening> mapToTreningList(List<TreningDto> treningDtoList) {
        List<Trening> collect = new ArrayList<>();
        for (TreningDto treningDto : treningDtoList) {
            Trening trening = null;
            try {
                trening = mapToTrening(treningDto);
            } catch (TeamNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(trening);
        }
        return collect;
    }
}
