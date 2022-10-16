package com.kata.rover.service.interfaces;

import com.kata.rover.domain.Plateau;

public interface PlateauService {
    public boolean canMoveOnXAxis(Integer x, Plateau plateau);

    public boolean canMoveOnYAxis(Integer y, Plateau plateau);

}