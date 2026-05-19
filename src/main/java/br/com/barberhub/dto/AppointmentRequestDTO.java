package br.com.barberhub.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequestDTO(
        Long barberId,
        Long userId,
        Long serviceItemId,
        LocalDate availableDate,
        LocalTime availableTime

) {
}
