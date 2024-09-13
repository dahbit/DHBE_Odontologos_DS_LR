package com.dh.TI_Clinica_Odontologica.controller;

import com.dh.TI_Clinica_Odontologica.entity.Odontologo;
import com.dh.TI_Clinica_Odontologica.exception.ResourceNotFoundException;
import com.dh.TI_Clinica_Odontologica.service.IOdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoServicio odontologoServicio;

    // Buscar odontólogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(odontologoServicio.buscarPorId(id));
    }

    // Guardar un nuevo odontólogo
    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoServicio.guardar(odontologo));
    }

    // Listar todos los odontólogos
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoServicio.listarTodos());
    }

    // Buscar odontólogo por matrícula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> buscarPorMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(odontologoServicio.buscarPorMatricula(matricula));
    }

    // Modificar un odontólogo existente
    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizar(@PathVariable Long id, @RequestBody Odontologo odontologoActualizado) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoServicio.buscarPorId(id);
        if (odontologo == null) {
            throw new ResourceNotFoundException("Odontólogo no encontrado con ID: " + id);
        }
        odontologo.setNombre(odontologoActualizado.getNombre());
        odontologo.setApellido(odontologoActualizado.getApellido());
        odontologo.setMatricula(odontologoActualizado.getMatricula());
        return ResponseEntity.ok(odontologoServicio.guardar(odontologo));
    }

    // Eliminar un odontólogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoServicio.buscarPorId(id);
        if (odontologo == null) {
            throw new ResourceNotFoundException("Odontólogo no encontrado con ID: " + id);
        }
        odontologoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
