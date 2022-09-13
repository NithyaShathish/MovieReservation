package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        Reservation r = new Reservation(customer, showing, 3);
        assertTrue(r.totalFee() == 28.5);
    }

    @Test
    void totalFee7thseq(){
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                7,
                LocalDate.now().atTime(13, 0)
        );
        assertTrue(new Reservation(customer, showing, 5).totalFee() == 46.875);
    }

    @Test
    void totalFee2ndSeq(){
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("The Batman", Duration.ofMinutes(95), 9, 0),
                2,
                LocalDate.now().atTime(17, 0)
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 28);
    }
}
