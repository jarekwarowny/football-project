package com.kodilla.footballproject;

import com.kodilla.footballproject.domain.Coach;
import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.repository.CoachRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("coaches")
public class CoachView extends VerticalLayout {

    private final CoachRepository coachRepository;

    private Grid<Coach> grid = new Grid<>(Coach.class);
    private static String TD = "<td style=\"border: 1px solid lightgrey; width: 33.3%; padding: 3px;\">";
    private static String TABLEHEADER = "<tr>" + TD + "<b>Id</b></td>" + TD + "<b>Firstname</b></td>" + TD
            + "<b>Lastname</b></td>" + TD + "<b>Description</b></td></tr>";

    public CoachView(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
        setHeight("500px");
        grid.setItems(getData());
        grid.setColumns("id", "firstname", "lastname", "description");
        grid.setSizeFull();
        add(grid);
    }

    public List<Coach> getData() {
        return coachRepository.findAll();
    }
}
