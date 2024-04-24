package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import java.time.Month;

public record DateTimeDetails(
        int day,
        Month month,
        int numberOfMonth,
        int numberOfDay,
        String nameOfDay,
        int year,
        int dayOfYear
) {
    public static class Builder {
        private int day;
        private Month month;
        private int numberOfMonth;
        private int numberOfDay;
        private String nameOfDay;
        private int year;
        private int dayOfYear;

        public Builder() {}

        public Builder day(int day) {
            this.day = day;
            return this;
        }

        public Builder month(Month month) {
            this.month = month;
            return this;
        }

        public Builder numberOfMonth(int numberOfMonth) {
            this.numberOfMonth = numberOfMonth;
            return this;
        }

        public Builder numberOfDay(int numberOfDay) {
            this.numberOfDay = numberOfDay;
            return this;
        }

        public Builder nameOfDay(String nameOfDay) {
            this.nameOfDay = nameOfDay;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder dayOfYear(int dayOfYear) {
            this.dayOfYear = dayOfYear;
            return this;
        }

        public DateTimeDetails build() {
            return new DateTimeDetails(day, month, numberOfMonth, numberOfDay, nameOfDay, year, dayOfYear);
        }
    }
}

