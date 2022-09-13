package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Math.max;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(),showing.getStartTime().getHour());
    }

    private double getDiscount(int showSequence, int startHour) {
        double specialDiscount = 0, timeDiscount =0, sequenceDiscount = 0;;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }
        if (startHour >= 11 && startHour< 16){
            timeDiscount = ticketPrice * 0.25;
        }

        switch (showSequence) {
            case 1: sequenceDiscount = 3; // $3 discount for 1st show
                    break;
            case 2: sequenceDiscount = 2; // $2 discount for 2nd show
                    break;
            case 7: sequenceDiscount = 1; // $2 discount for 7th show
                break;
            default: sequenceDiscount = 0;
        }

        // biggest discount wins
        return max(max(sequenceDiscount,timeDiscount),specialDiscount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}