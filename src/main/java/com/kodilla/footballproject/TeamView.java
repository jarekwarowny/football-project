package com.kodilla.footballproject;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.domain.Team;
import com.kodilla.footballproject.repository.CoachRepository;
import com.kodilla.footballproject.repository.TeamRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("teams")
public class TeamView extends VerticalLayout {

    private final TeamRepository teamRepository;

    private Grid<Team> grid = new Grid<>(Team.class);
    private static String TD = "<td style=\"border: 1px solid lightgrey; width: 33.3%; padding: 3px;\">";
    private static String TABLEHEADER = "<tr>" + TD + "<b>Id</b></td>" + TD + "<b>Name</b></td>" + TD
            + "<b>Description</b></td>";

    public TeamView(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
        setHeight("500px");
        grid.setItems(getData());
        grid.setColumns("id", "name", "description");
        grid.setSizeFull();
        add(grid);
    }

    public List<Team> getData() {
        return teamRepository.findAll();
    }
}
