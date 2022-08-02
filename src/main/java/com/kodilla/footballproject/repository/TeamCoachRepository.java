package com.kodilla.footballproject.repository;

import com.kodilla.footballproject.domain.TeamCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TeamCoachRepository extends JpaRepository<TeamCoach, Long> {


}
