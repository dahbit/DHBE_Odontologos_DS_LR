package com.dh.TI_Clinica_Odontologica.controller;

import com.dh.TI_Clinica_Odontologica.entity.Paciente;
import com.dh.TI_Clinica_Odontologica.exception.ResourceNotFoundException;
import com.dh.TI_Clinica_Odontologica.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteServicio pacienteServicio;

    // Buscar paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteServicio.buscarPorId(id));
    }

    // Guardar un nuevo paciente
    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteServicio.guardar(paciente));
    }

    // Listar todos los pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteServicio.listarTodos());
    }


}
