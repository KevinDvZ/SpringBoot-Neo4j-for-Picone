package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}