package com.kodilla.footballproject.repository;

import com.kodilla.footballproject.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {


}
