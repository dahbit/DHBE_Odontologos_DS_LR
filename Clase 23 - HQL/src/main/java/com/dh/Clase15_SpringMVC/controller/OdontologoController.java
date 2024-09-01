package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.service.IOdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoServicio odontologoServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id) {
        Odontologo odontologo = odontologoServicio.buscarPorId(id);
        return odontologo != null ? ResponseEntity.ok(odontologo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoServicio.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody Odontologo odontologo) {
        if (odontologoServicio.buscarPorId(odontologo.getId()) != null) {
            odontologoServicio.actualizar(odontologo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        odontologoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> buscarPorMatricula(@PathVariable String matricula) {
        Odontologo odontologo = odontologoServicio.buscarPorMatricula(matricula);
        return odontologo != null ? ResponseEntity.ok(odontologo) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoServicio.listarTodos());
    }
}
