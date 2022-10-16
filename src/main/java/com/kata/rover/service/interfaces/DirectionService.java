package com.kata.rover.service.interfaces;

import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.domain.enums.Direction;
import com.kata.rover.exception.PlateauOutOfBoundException;
import org.springframework.stereotype.Service;

public interface DirectionService {
    void move(Direction direction, Position position, Plateau plateau) throws PlateauOutOfBoundException;
}
