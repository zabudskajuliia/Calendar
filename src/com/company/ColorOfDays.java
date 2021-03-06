package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ColorOfDays {
    private static String colorForCurrentDay = "\033[36m";
    private static String colorForWeekend = "\033[31m";
    private static String colorForWorkDays = "\033[37m";

    private static boolean isWeekend(DayOfWeek getDayOfMonth) {
        return (getDayOfMonth == DayOfWeek.SATURDAY || getDayOfMonth == DayOfWeek.SUNDAY);
    }

     public static String colorForDayInWeek(int numberOfDay, LocalDate date) {
        DayOfWeek dayOfWeek = DayOfWeek.from(date.withDayOfMonth(numberOfDay));
        if (date.getDayOfMonth() == numberOfDay) {
            return colorForCurrentDay + numberOfDay;
        } else if (isWeekend(dayOfWeek)) {
            return colorForWeekend + numberOfDay;
        } else {
            return colorForWorkDays + numberOfDay;
        }
    }
}

