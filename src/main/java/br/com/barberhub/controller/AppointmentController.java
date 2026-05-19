package br.com.barberhub.controller;

import br.com.barberhub.dto.AppointmentRequestDTO;
import br.com.barberhub.dto.AppointmentResponseDTO;
import br.com.barberhub.dto.BarberRequestDTO;
import br.com.barberhub.dto.BarberResponseDTO;
import br.com.barberhub.service.AppointmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/appointment")
@RequiredArgsConstructor
@Validated
@Tag(name = "Appointment", description = "Controller para agendamentos do Barbeiro")
public class AppointmentController {

    private final AppointmentService service;

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAllAppointment() {
        return ResponseEntity.ok(service.findAllAppointments());
    }

    @GetMapping("/barber/{id}")
    public ResponseEntity<List<AppointmentResponseDTO>> findByBarberId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByBarber(id));

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AppointmentResponseDTO>> findByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByUser(id));

    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody @Valid AppointmentRequestDTO dto, UriComponentsBuilder uriBuilder ) {
        var appointment = service.createAppointment(dto);
        var uri = uriBuilder.path("/{id}").buildAndExpand(appointment.id()).toUri();
        return ResponseEntity.created(uri).body(appointment);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
            service.cancelAppointment(id);
            return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Void> completeAppointment(@PathVariable Long id) {
        service.completeAppointment(id);
        return ResponseEntity.noContent().build();
    }






}
