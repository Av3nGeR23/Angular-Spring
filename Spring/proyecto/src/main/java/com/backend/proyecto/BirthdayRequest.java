package com.backend.proyecto;

import java.time.LocalDate;

public class BirthdayRequest {
    private LocalDate birthdate;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
