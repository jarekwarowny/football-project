package com.kodilla.footballproject.repository;

import com.kodilla.footballproject.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {


}
