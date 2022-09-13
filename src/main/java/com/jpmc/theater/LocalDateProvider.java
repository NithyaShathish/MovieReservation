package com.jpmc.theater;

import java.time.LocalDate;

public class LocalDateProvider {
    private static LocalDateProvider instance = null;

    /**
     * @return make sure to return singleton instance
     */
    public static LocalDateProvider singleton() {
        if (instance == null) {
            instance = new LocalDateProvider();
        }
            return instance;
        }

    public LocalDate currentDate() {
            return LocalDate.now();
    }
}
