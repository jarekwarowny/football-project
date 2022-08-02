package com.kodilla.footballproject.repository;

import com.kodilla.footballproject.domain.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TreningRepository extends JpaRepository<Trening, Long> {


}
