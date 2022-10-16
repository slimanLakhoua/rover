package com.kata.rover.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {

    private int x;
    private int y;

    @Override
    public String toString() {
        return
                x + " " + y;
    }
}
