package com.kodilla.footballproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEAM_COACHES")
public class TeamCoach {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISCOACHINGNOW")
    private boolean isCoachingNow;

    @Column(name = "STARTOFCOACHING")
    private LocalDate startOfCoaching;

    @ManyToOne
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public TeamCoach(boolean isCoachingNow, LocalDate startOfCoaching, Coach coach, Team team) {
        this.isCoachingNow = isCoachingNow;
        this.startOfCoaching = startOfCoaching;
        this.coach = coach;
        this.team = team;
    }
}
