
package com.dh.TI_Clinica_Odontologica.repository;

import com.dh.TI_Clinica_Odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {

    // Métodos agregados para búsquedas por paciente y odontólogo
    List<Turno> findByPacienteId(Long pacienteId);
    List<Turno> findByOdontologoId(Long odontologoId);
}
