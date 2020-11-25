package com.vitalsigns.module.api.vitalsignsmoduleapi.repository;

import com.vitalsigns.module.api.vitalsignsmoduleapi.entity.VitalSignTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface VitalSignsModuleRepository extends JpaRepository<VitalSignTable,Integer> {
//    List<VitalSignTable> findByPatientConsultingDate(int patient_id, Date patient_consulting_date);
}
