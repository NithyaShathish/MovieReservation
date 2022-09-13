package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWithSequenceDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void specialMovieWithNewDiscount() {
        Movie BatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        Showing showing = new Showing(BatMan, 7, LocalDate.now().atTime(11, 30));
        assertEquals(6.75, BatMan.calculateTicketPrice(showing));
    }
}
