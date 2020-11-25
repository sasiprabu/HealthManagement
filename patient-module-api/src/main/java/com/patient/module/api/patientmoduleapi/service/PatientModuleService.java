package com.patient.module.api.patientmoduleapi.service;

import com.patient.module.api.patientmoduleapi.dto.PatientDto;
import com.patient.module.api.patientmoduleapi.entity.PatientTable;
import com.patient.module.api.patientmoduleapi.serviceimpl.PatientModuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientModuleService {

    public PatientTable insertPatientDetail(PatientDto patientDto);

    public PatientTable getPatientDetail(int patientId);

    public List<PatientTable> allPatientDetails();

    public ResponseEntity<PatientTable> doUpdate(int patient_id, PatientDto patientDto) throws Exception;

    public void doDeleteAll();

    public void doDelete(int patient_id);
}
