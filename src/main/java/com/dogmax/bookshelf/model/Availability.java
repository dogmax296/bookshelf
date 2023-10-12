package com.dogmax.bookshelf.model;


import jakarta.persistence.Entity;

import java.util.Objects;
import java.util.stream.Stream;

public enum Availability {
    IN_STOCK(0),
    OUT_OF_STOCK(1);
    private final Integer available;

    Availability(Integer available) {
        this.available = available;
    }

    public Integer getAvailable() {
        return available;
    }
    public static Availability of(Integer available){
        return Stream.of(Availability.values())
                .filter(a -> Objects.equals(a.getAvailable(), available))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}