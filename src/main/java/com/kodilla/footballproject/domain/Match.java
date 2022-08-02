package com.kodilla.footballproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MATCHES")
public class Match {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DATEOFMATCH")
    private LocalDate dateOfMatch;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    private Team team1;

    @ManyToOne
    private Team team2;

    public Match(LocalDate dateOfMatch, String description, Team team1, Team team2) {
        this.dateOfMatch = dateOfMatch;
        this.description = description;
        this.team1 = team1;
        this.team2 = team2;
    }
}
