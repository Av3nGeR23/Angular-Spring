package com.backend.proyecto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Configura la URL de tu aplicación Angular
public class BirthdayController {

    @PostMapping("/api/calculate-days")
    public BirthdayResponse calculateDaysToNextBirthday(@RequestBody BirthdayRequest request) {
        LocalDate birthdate = request.getBirthdate();
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthdate.withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long days = ChronoUnit.DAYS.between(today, nextBirthday);
        long hours = ChronoUnit.HOURS.between(LocalDateTime.now(), nextBirthday.atTime(LocalTime.MIDNIGHT));
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), nextBirthday.atTime(LocalTime.MIDNIGHT));

        return new BirthdayResponse(days, hours, seconds);
    }
}
