
package com.duoc.usuarios.controller;

import com.duoc.usuarios.dto.*;
import com.duoc.usuarios.security.JwtService;
import com.duoc.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public UsuarioController(UsuarioService usuarioService, JwtService jwtService) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    // ---------- AUTH ----------
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req){
        // valida credenciales
        usuarioService.login(req);
        String token = jwtService.generateToken(
                req.getEmail(),
                Map.of("scope","USER"),  // puedes incluir roles
                1000L * 60 * 60          // 1 hora
        );
        return ResponseEntity.ok(new LoginResponse(token));
    }

    // ---------- CRUD USUARIOS ----------
    @PostMapping("/api/usuarios")
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody UsuarioCreateDTO dto){
        return ResponseEntity.ok(usuarioService.crear(dto));
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioUpdateDTO dto){
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }
}
