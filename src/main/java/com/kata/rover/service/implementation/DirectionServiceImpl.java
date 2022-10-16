package com.kata.rover.service.implementation;

import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.domain.enums.Direction;
import com.kata.rover.exception.PlateauOutOfBoundException;
import com.kata.rover.service.interfaces.DirectionService;
import com.kata.rover.service.interfaces.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionServiceImpl implements DirectionService {

    private final PositionService positionService;

    @Autowired
    public DirectionServiceImpl(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public void move(Direction direction, Position position, Plateau plateau) throws PlateauOutOfBoundException {
        switch (direction) {
            case N: this.positionService.moveNorth(position, plateau); break;
            case E: this.positionService.moveEast(position, plateau); break;
            case S: this.positionService.moveSouth(position, plateau); break;
            case W: this.positionService.moveWest(position, plateau); break;
            default: throw new IllegalArgumentException("wrong direction");
        }
    }

}
