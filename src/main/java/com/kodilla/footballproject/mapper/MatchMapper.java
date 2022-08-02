package com.kodilla.footballproject.mapper;

import com.kodilla.footballproject.domain.Match;
import com.kodilla.footballproject.dto.MatchDto;
import com.kodilla.footballproject.exception.TeamNotFoundException;
import com.kodilla.footballproject.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchMapper {

    private final TeamRepository teamRepository;

    public Match mapToMatch(final MatchDto matchDto) {
        return new Match(
                matchDto.getId(),
                matchDto.getDateOfMatch(),
                matchDto.getDescription(),
                teamRepository.findById(matchDto.getTeam1Id()).orElseThrow(TeamNotFoundException::new),
                teamRepository.findById(matchDto.getTeam2Id()).orElseThrow(TeamNotFoundException::new)
        );
    }

    public MatchDto mapToMatchDto(final Match match) {
        return new MatchDto(
                match.getId(),
                match.getDateOfMatch(),
                match.getDescription(),
                match.getTeam1().getId(),
                match.getTeam2().getId()
        );
    }

    public List<MatchDto> mapToMatchDtoList(final List<Match> matchList) {
        return matchList.stream()
                .map(this::mapToMatchDto)
                .collect(Collectors.toList());
    }
}
