package br.com.smartmenu.controller;

import br.com.smartmenu.dto.UserDTO;
import br.com.smartmenu.entities.User;
import br.com.smartmenu.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
@Validated
@Tag(name="User", description = "Controller para crud de Usuários")
public class UserController {

    private final UserService service;

    @Operation(description = "Busca todos os usuários",
            summary = "Busca de usuários",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            })
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(description = "Busca todos os usuários por nome",
            summary = "Busca de usuários por nome",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            })
    @GetMapping("/find")
    public ResponseEntity<List<User>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @Operation(description = "Criação usuários",
            summary = "Criação usuários",
            responses = {
                    @ApiResponse(description = "CREATED", responseCode = "201")
            })
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO dto) {
        User create = service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @Operation(description = "Alteração usuários",
            summary = "Alteração usuários",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@Valid @RequestBody UserDTO dto) {
        User update = service.updateUser(id,dto);
        return ResponseEntity.ok(update);
    }

    @Operation(description = "Exclusão usuários",
            summary = "Exclusão usuários")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.deleteUser(id);
    }
}
