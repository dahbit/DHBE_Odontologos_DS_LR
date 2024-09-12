
package com.dh.TI_Clinica_Odontologica.controller;

import com.dh.TI_Clinica_Odontologica.entity.Turno;
import com.dh.TI_Clinica_Odontologica.exception.ResourceNotFoundException;
import com.dh.TI_Clinica_Odontologica.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoServicio turnoServicio;

    // Buscar turno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoServicio.buscarPorId(id));
    }

    // Guardar un nuevo turno
    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoServicio.guardar(turno));
    }

    // Listar todos los turnos
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(turnoServicio.listarTodos());
    }

    // Eliminar un turno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        turnoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar turnos por paciente ID
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Turno>> buscarPorPacienteId(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(turnoServicio.buscarPorPacienteId(pacienteId));
    }

    // Buscar turnos por odontologo ID
    @GetMapping("/odontologo/{odontologoId}")
    public ResponseEntity<List<Turno>> buscarPorOdontologoId(@PathVariable Long odontologoId) {
        return ResponseEntity.ok(turnoServicio.buscarPorOdontologoId(odontologoId));
    }

}
