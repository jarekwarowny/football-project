package com.kodilla.footballproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRENINGS")
public class Trening {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DATEOFTRENING")
    private LocalDate dateOfTrening;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    private Team team;

    public Trening(LocalDate dateOfTrening, String description, Team team) {
        this.dateOfTrening = dateOfTrening;
        this.description = description;
        this.team = team;
    }
}
