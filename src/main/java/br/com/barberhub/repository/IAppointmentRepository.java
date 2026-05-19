package br.com.barberhub.repository;

import br.com.barberhub.entities.Appointment;
import br.com.barberhub.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByUserIdAndBarberIdAndStatus(Long userId, Long barberId, AppointmentStatus status);

    List<Appointment> findByUserId(Long userId);

    List<Appointment> findByBarberId(Long barberId);

    // verifica se barbeiro está ocupado
    Optional<Appointment> findByBarberIdAndAvailableDateAndAvailableTime(Long barberId, LocalDate availableDate, LocalTime availableTime);

    // verifica se cliente está ocupado
    Optional<Appointment> findByUserIdAndAvailableDateAndAvailableTime(Long userId, LocalDate availableDate, LocalTime availableTime);
}
