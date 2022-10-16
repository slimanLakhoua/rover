package com.kata.rover.service.interfaces;

import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.exception.PlateauOutOfBoundException;

public interface PositionService {

    void moveNorth(Position position, Plateau plateau) throws PlateauOutOfBoundException;

    void moveSouth(Position position, Plateau plateau) throws PlateauOutOfBoundException;

    void moveWest(Position position, Plateau plateau) throws PlateauOutOfBoundException;

    void moveEast(Position position, Plateau plateau) throws PlateauOutOfBoundException;
}
