package com.backend.proyecto;

public class BirthdayResponse {
    private long days;
    private long hours;
    private long seconds;

    public BirthdayResponse(long days, long hours, long seconds) {
        this.days = days;
        this.hours = hours;
        this.seconds = seconds;
    }

    public long getDays() {
        return days;
    }

    public long getHours() {
        return hours;
    }

    public long getSeconds() {
        return seconds;
    }
}
