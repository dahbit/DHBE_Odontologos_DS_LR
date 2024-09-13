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

    // Modificar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente pacienteActualizado) throws ResourceNotFoundException {
        Paciente paciente = pacienteServicio.buscarPorId(id);
        if (paciente == null) {
            throw new ResourceNotFoundException("Paciente no encontrado con ID: " + id);
        }
        paciente.setNombre(pacienteActualizado.getNombre());
        paciente.setApellido(pacienteActualizado.getApellido());
        paciente.setDni(pacienteActualizado.getDni());
        return ResponseEntity.ok(pacienteServicio.guardar(paciente));
    }

    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        Paciente paciente = pacienteServicio.buscarPorId(id);
        if (paciente == null) {
            throw new ResourceNotFoundException("Paciente no encontrado con ID: " + id);
        }
        pacienteServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
