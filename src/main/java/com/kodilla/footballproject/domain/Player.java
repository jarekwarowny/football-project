package com.kodilla.footballproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLAYERS")
public class Player {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "BDAY")
    private LocalDate bday;

    @Column(name = "POSITION")
    private String position;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToMany(
            targetEntity = TeamPlayer.class,
            mappedBy = "player",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<TeamPlayer> teamPlayers = new ArrayList<>();

    public Player(String firstname, String lastname, LocalDate bday, String position, Team team) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.bday = bday;
        this.position = position;
        this.team = team;
    }
}
