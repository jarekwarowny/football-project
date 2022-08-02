package com.kodilla.footballproject.service;

import com.kodilla.footballproject.domain.Trening;
import com.kodilla.footballproject.exception.TreningNotFoundException;
import com.kodilla.footballproject.repository.TreningRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreningDBService {

    public final TreningRepository treningRepository;

    public List<Trening> getTrenings() {
        return treningRepository.findAll();
    }

    public Trening getTrening(final Long treningId) throws TreningNotFoundException {
        return treningRepository.findById(treningId).orElseThrow(TreningNotFoundException::new);
    }

    public Trening saveTrening(final Trening trening) {
        return treningRepository.save(trening);
    }

    public void deleteTrening(final Long treningId) {
        treningRepository.deleteById(treningId);
    }
}
