package my.hospital.hospitalapp.repositories;

import my.hospital.hospitalapp.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
        Page<Patient> findByNameContains(String Keyword, Pageable pageable);

        @Query("select p from Patient p where p.Name like :Kw")
        Page<Patient> Search(@Param("Kw") String Keyword, Pageable pageable);
}
