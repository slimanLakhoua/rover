package com.kata.rover.service.implementation;

import com.kata.rover.domain.enums.Direction;
import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.domain.Rover;
import com.kata.rover.exception.FileConverterException;
import com.kata.rover.exception.PlateauOutOfBoundException;
import com.kata.rover.service.interfaces.DirectionService;
import com.kata.rover.service.interfaces.RoverService;
import com.kata.rover.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.kata.rover.utils.Constants.*;
import static java.util.stream.Collectors.toList;


@Service
@Slf4j
public class RoverServiceImpl implements RoverService {

    private final DirectionService directionService;

    @Autowired
    public RoverServiceImpl(DirectionService directionService) {
        this.directionService = directionService;
    }

    public String run(Rover rover) {
        if (!StringUtils.hasText(rover.getInstructions())) {
            throw new IllegalArgumentException("instructions can not be empty");
        }

        rover.getInstructions().chars().mapToObj(Character::toString).forEach(instruction -> {
            if (MOVE_FORWARD.equals(instruction)) {
                this.moveRover(rover);
            } else {
                this.changeDirection(rover, instruction);
            }
        });

        return rover.toString();
    }

    public void moveRover(Rover rover) {
        try {
            this.directionService.move(rover.getDirection(), rover.getPosition(), rover.getPlateau());
        } catch (PlateauOutOfBoundException e) {
            log.info("cannot move to desired position");
        }
    }

    private void changeDirection(Rover rover,String instruction) {
        if (RIGHT.equals(instruction)) {
            rover.setDirection(rover.getDirection().getRight());
        } else {
            rover.setDirection(rover.getDirection().getLeft());
        }
    }

    public List<String> processFile(String fileName) {
        try {
            if (Objects.isNull(fileName)) throw new IllegalArgumentException("fileName can not be null");
            if (fileName.isBlank()) throw new IllegalArgumentException("fileName can not be empty");
            var lines = FileUtils.readLinesFromFile(fileName);
            log.info("reading lines from file. {} line found", lines.size());
            if (lines.size() == 0) throw new FileConverterException("file is empty");
            var rovers = this.createRoversFromLines(lines);
            log.info("{} Rover found", rovers.size());
            log.info("Running Rovers ...");
            return this.proceed(rovers);

        } catch (IOException | URISyntaxException e) {
            throw new FileConverterException("error converting file to list of Rovers");
        }
    }

    private List<Rover> createRoversFromLines(List<String> lines) {
        List<Rover> rovers = new ArrayList<>();

        Plateau plateau = new Plateau(lines.get(0).trim());

        for (int i = 1; i < lines.size(); i = i + 2) {
            String[] coordinatesAsStringArray = lines.get(i).trim().split(SEPARATOR);
            log.info(Arrays.toString(coordinatesAsStringArray));
            Position position = new Position(Integer.parseInt(coordinatesAsStringArray[0]), Integer.parseInt(coordinatesAsStringArray[1]));
            String instructions = lines.get(i + 1).trim();
            Rover rover = new Rover(plateau, Direction.fromValue(coordinatesAsStringArray[2]), position, instructions);
            rovers.add(rover);
        }
        return rovers;
    }

    private List<String> proceed(List<Rover> rovers) {
        return rovers.stream().map(this::run).collect(toList());
    }
}
