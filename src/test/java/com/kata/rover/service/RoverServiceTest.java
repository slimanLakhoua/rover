package com.kata.rover.service;

import com.kata.rover.domain.Plateau;
import com.kata.rover.domain.Position;
import com.kata.rover.domain.Rover;
import com.kata.rover.domain.enums.Direction;
import com.kata.rover.exception.FileConverterException;
import com.kata.rover.exception.PlateauOutOfBoundException;
import com.kata.rover.service.interfaces.RoverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoverServiceTest {

    private final RoverService roverService;

    @Autowired
    RoverServiceTest(RoverService roverService) {
        this.roverService = roverService;
    }

    @Test
    void processFile_should_throw_exception_on_null_filename() {

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            roverService.processFile(null);
        });
        assertEquals("fileName can not be null", exception.getMessage());
    }

    @Test
    void processFile_should_throw_exception_on_filename_empty() {

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            roverService.processFile("");
        });
        assertEquals("fileName can not be empty", exception.getMessage());
    }

    @Test
    void processFile_should_throw_exception_on_empty_file() {

        var exception = assertThrows(FileConverterException.class, () -> {
            roverService.processFile("emptyFile.txt");
        });
        assertEquals("file is empty", exception.getMessage());
    }

    @Test
    void processFile_should_read_inputs_with_extra_spaces() {

        var results = roverService.processFile("instructionWithSpaces.txt");
        assertAll(() -> {
            assertEquals("0 2 S", results.get(0));
        });
    }


    @Test
    void run_should_throw_exception_on_empty_instructions() {

        var rover = new Rover(new Plateau(), Direction.N, new Position(), "");

        assertThrows(IllegalArgumentException.class, () -> {
            this.roverService.run(rover);
        });

    }

    @Test
    void processFile_should_return_valid_output() {

        var results = roverService.processFile("exercice.txt");
        assertAll(() -> {
            assertEquals("1 3 N", results.get(0));
            assertEquals("5 1 E", results.get(1));
        });
    }

}