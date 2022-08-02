package com.kodilla.footballproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEAMS")
public class Team {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(
            targetEntity = Player.class,
            mappedBy = "team",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Player> players = new ArrayList<>();

    @OneToMany(
            targetEntity = Coach.class,
            mappedBy = "team",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Coach> coaches = new ArrayList<>();

    @OneToMany(
            targetEntity = Trening.class,
            mappedBy = "team",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Trening> trenings = new ArrayList<>();

    @OneToMany(
            targetEntity = Match.class,
            mappedBy = "team1",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Match> matchesAs1= new ArrayList<>();

    @OneToMany(
            targetEntity = Match.class,
            mappedBy = "team2",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Match> matchesAs2 = new ArrayList<>();

    @OneToMany(
            targetEntity = TeamPlayer.class,
            mappedBy = "team",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<TeamPlayer> teamPlayers = new ArrayList<>();

    @OneToMany(
            targetEntity = TeamCoach.class,
            mappedBy = "team",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<TeamCoach> teamCoaches = new ArrayList<>();

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
