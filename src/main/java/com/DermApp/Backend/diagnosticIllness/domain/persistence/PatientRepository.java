package com.DermApp.Backend.diagnosticIllness.domain.persistence;

import com.DermApp.Backend.diagnosticIllness.domain.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByAge(int age);

    Patient findByName(String name);
}
