package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar {
    public static LocalDate date;
    public static int[] dayOfMonth = new int[32];
    public static ColorOfDays ColorForDay = new ColorOfDays();

    public void Calendar(LocalDate date) {
        this.date = date;
    }

    private static void namesOfTheDays() {
        DayOfWeek dayOfWeek = DayOfWeek.from(date);
        for (int i = 1; i <= 7; i++) {
            System.out.print(dayOfWeek.of(i).getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " ");
        }
        System.out.println();
    }

    private static void createMonth() {
        int day = 1;
        for (int i = 0; i < date.lengthOfMonth(); i++) {
            dayOfMonth[i] = day;
            day++;
        }
    }

    private static boolean isLastDayOfWeek(int getDayOfMonth, int firstDay) {
        return ((getDayOfMonth + firstDay) % 7 == 0);
    }

    public static void writeDays() {
        namesOfTheDays();
        int firstDay = (date.getDayOfWeek().minus(date.getDayOfMonth())).getValue();
        createMonth();
        for (int j = 0; j < firstDay; j++) {
            System.out.print("\t");
        }
        for (int i = 0; i <= dayOfMonth[i]; i++) {
            System.out.print(ColorForDay.colorForDayInWeek(dayOfMonth[i], date) + "\t");
            if (isLastDayOfWeek(dayOfMonth[i], firstDay)) {
                System.out.println();
            }
        }
    }
}
