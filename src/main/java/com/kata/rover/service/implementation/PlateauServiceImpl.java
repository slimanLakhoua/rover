package com.kata.rover.service.implementation;

import com.kata.rover.domain.Plateau;
import com.kata.rover.service.interfaces.PlateauService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlateauServiceImpl implements PlateauService {

    @Override
    public boolean canMoveOnXAxis(Integer x, Plateau plateau) {
        return x >= 0 && x <= plateau.getLastX();
    }

    @Override
    public boolean canMoveOnYAxis(Integer y, Plateau plateau) {
        return y >= 0 && y <= plateau.getLastY();
    }
}
