package com.kata.rover.service.implementation;

import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.exception.PlateauOutOfBoundException;
import com.kata.rover.service.interfaces.PlateauService;
import com.kata.rover.service.interfaces.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

    private final PlateauService plateauService;

    public PositionServiceImpl(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    @Override
    public void moveNorth(Position position, Plateau plateau) throws PlateauOutOfBoundException {
        if (plateauService.canMoveOnYAxis(position.getY() + 1, plateau)) {
            position.setY(position.getY()+1);
        } else {
            throw new PlateauOutOfBoundException();
        }
    }
    @Override
    public void moveSouth(Position position, Plateau plateau) throws PlateauOutOfBoundException {
        if (plateauService.canMoveOnYAxis(position.getY() - 1, plateau)){
            position.setY(position.getY()-1);
        } else {
            throw new PlateauOutOfBoundException();
        }
    }
    @Override
    public void moveWest(Position position, Plateau plateau) throws PlateauOutOfBoundException {
        if (plateauService.canMoveOnXAxis(position.getX() - 1, plateau)) {
            position.setX(position.getX() - 1);
        }else {
            throw new PlateauOutOfBoundException();
        }
    }
    @Override
    public void moveEast(Position position, Plateau plateau) throws PlateauOutOfBoundException {
        if (plateauService.canMoveOnXAxis(position.getX() + 1, plateau)) {
            position.setX(position.getX() + 1);
        } else {
            throw new PlateauOutOfBoundException();
        }
    }

}
