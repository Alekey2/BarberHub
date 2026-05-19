package br.com.barberhub.controller;

import br.com.barberhub.dto.BarberResponseDTO;
import br.com.barberhub.dto.ReviewRequestDTO;
import br.com.barberhub.dto.ReviewResponseDTO;
import br.com.barberhub.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/review")
@RequiredArgsConstructor
@Validated
@Tag(name = "Review", description = "Controller para avaliações dos barbeiros")
public class ReviewController {

    private final ReviewService service;


    @GetMapping("/{id}")
    public ResponseEntity<List<ReviewResponseDTO>> findByBarberId(@RequestParam long barberId) {
        return ResponseEntity.ok(service.findByBarber(barberId));
    }


    @PutMapping("/create")
    public ResponseEntity<ReviewResponseDTO> createAssessment(@RequestParam @Valid ReviewRequestDTO dto, UriComponentsBuilder uriBuilder) {
        var review = service.createAssessment(dto);
        var uri = uriBuilder.path("/{id}").buildAndExpand(review.id()).toUri();

        return ResponseEntity.created(uri).body(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarberResponseDTO> deleteAssessment(@PathVariable long id) {
        service.deleteAssessment(id);

        return ResponseEntity.noContent().build();
    }


}
