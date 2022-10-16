package com.kata.rover.domain;

import com.kata.rover.domain.enums.Direction;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Rover {

    private Plateau plateau;
    private Direction direction;
    private Position position;
    private String instructions;

    @Override
    public String toString() {
        return position + " " + direction;
    }
}
