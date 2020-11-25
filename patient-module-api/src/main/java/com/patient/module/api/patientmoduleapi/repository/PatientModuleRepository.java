package com.patient.module.api.patientmoduleapi.repository;

import com.patient.module.api.patientmoduleapi.entity.PatientTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientModuleRepository extends JpaRepository<PatientTable,Integer> {
    PatientTable findByPatientId(int patientId);

    @Query("From patient_table where age>=?1")
    Long getSeniorCitizensCount(long age);

    @Query("From patient_table where age<=?1")
    Long getChildCount(long age);
}
