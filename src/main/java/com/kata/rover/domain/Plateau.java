package com.kata.rover.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.kata.rover.utils.Constants.SEPARATOR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Plateau {

    private int lastX ;
    private int lastY;

    public Plateau(String coordinatesAsString) {
        if (coordinatesAsString.length() != 3) {
            throw new IllegalArgumentException("invalid coordinates");
        }

        lastX = Integer.parseInt(coordinatesAsString.substring(0, 1));
        lastY = Integer.parseInt(coordinatesAsString.substring(coordinatesAsString.lastIndexOf(SEPARATOR) + 1));
    }
}
