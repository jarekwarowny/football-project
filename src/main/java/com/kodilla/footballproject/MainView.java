package com.kodilla.footballproject;

import com.kodilla.footballproject.domain.Player;
import com.kodilla.footballproject.dto.PlayerDto;
import com.kodilla.footballproject.repository.PlayerRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Route("players")
public class MainView extends VerticalLayout {

    private final PlayerRepository playerRepository;

    private Grid<Player> grid = new Grid<>(Player.class);
    private static String TD = "<td style=\"border: 1px solid lightgrey; width: 33.3%; padding: 3px;\">";
    private static String TABLEHEADER = "<tr>" + TD + "<b>Id</b></td>" + TD + "<b>Firstname</b></td>" + TD
            + "<b>Lastname</b></td>" + TD + "<b>Position</b></td></tr>";

    public MainView(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
        setHeight("500px");
        grid.setItems(getData());
        grid.setColumns("id", "firstname", "lastname", "position");
        grid.setSizeFull();
        add(grid);
    }

    public List<Player> getData() {
        return playerRepository.findAll();
    }

   /* public List<PlayerDto> getData() {
        RestTemplate restTemplate = new RestTemplate();
        PlayerDto[] players = restTemplate.getForObject("/v1/players" ,PlayerDto[].class);
        return Arrays.stream(players).collect(Collectors.toList());
    }
    */
}
