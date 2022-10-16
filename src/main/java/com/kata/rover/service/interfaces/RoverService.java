package com.kata.rover.service.interfaces;

import com.kata.rover.domain.Rover;

import java.util.List;

public interface RoverService {
    List<String> processFile(String fileName);
    String run(Rover rover);

}
