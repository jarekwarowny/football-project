package com.kodilla.footballproject.repository;


import com.kodilla.footballproject.domain.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Long> {


}
