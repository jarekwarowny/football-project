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
@Table(name = "TEAM_PLAYERS")
public class TeamPlayer {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISPLAYINGNOW")
    private boolean isPlayingNow;

    @Column(name = "STARTOFPLAYING")
    private LocalDate startOfPlaying;

    @ManyToOne
    @JoinColumn(name = "PLAYER_ID")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public TeamPlayer(boolean isPlayingNow, LocalDate startOfPlaying, Player player, Team team) {
        this.isPlayingNow = isPlayingNow;
        this.startOfPlaying = startOfPlaying;
        this.player = player;
        this.team = team;
    }
}
