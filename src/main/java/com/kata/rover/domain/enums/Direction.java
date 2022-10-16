package com.kata.rover.domain.enums;

public enum Direction {
    N("N", "W", "E") ,
    E("E", "N", "S") ,
    S("S", "E", "W") ,
    W("W", "S", "N") ;

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direction getLeft() {
        return fromValue(this.left);
    }

    public Direction getRight() {
        return fromValue(this.right);
    }

    public static Direction fromValue(String value) {
        for (Direction d : values()) {
            if (d.value.equals(value)) {
                return d;
            }
        }
        throw new IllegalArgumentException("invalid enum value");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
