package com.patient.module.api.patientmoduleapi.serviceimpl;

import com.patient.module.api.patientmoduleapi.dto.PatientDto;
import com.patient.module.api.patientmoduleapi.entity.PatientTable;
import com.patient.module.api.patientmoduleapi.repository.PatientModuleRepository;
import com.patient.module.api.patientmoduleapi.service.PatientModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientModuleServiceImpl implements PatientModuleService {

    private PatientModuleRepository patientModuleRepository;

    @Lazy
    @Autowired
    public PatientModuleServiceImpl(PatientModuleRepository patientModuleRepository) {
        this.patientModuleRepository = patientModuleRepository;
    }

    public PatientTable insertPatientDetail(PatientDto patientDto) {
        PatientTable patientTable = new PatientTable();
        patientTable.setPatientUsername(patientDto.getPatientUsername());
        patientTable.setPatientFirstname(patientDto.getPatientFirstname());
        patientTable.setPatientLastname(patientDto.getPatientLastname());
        patientTable.setPatientGender(patientDto.getPatientGender());
        patientTable.setAddress(patientDto.getAddress());
        patientTable.setAdmissionDate(patientDto.getAdmissionDate());
        patientTable.setCity(patientDto.getCity());
        patientTable.setCountry(patientDto.getCountry());
        patientTable.setMaritalStatus(patientDto.getMaritalStatus());
        patientTable.setPatientAge(patientDto.getPatientAge());
        patientTable.setPatientDOB(patientDto.getPatientDOB());
        patientTable.setOccupation(patientDto.getOccupation());
        patientTable.setDischargeDate(patientDto.getDischargeDate());
        patientTable.setState(patientDto.getState());
        patientTable.setRegisterDate(patientDto.getRegisterDate());
        patientTable.setPatientEmail(patientDto.getPatientEmail());
        patientTable.setPostalCode(patientDto.getPostalCode());
        patientTable.setPatientMobileNumber(patientDto.getPatientMobileNumber());
        return patientModuleRepository.save(patientTable);
    }

    public PatientTable getPatientDetail(int patientId) {
        return patientModuleRepository.findByPatientId(patientId);
    }

    public List<PatientTable> allPatientDetails() {
        return patientModuleRepository.findAll();
    }

    public ResponseEntity<PatientTable> doUpdate(int patient_id, PatientDto patientDto) throws Exception {
        PatientTable patientTable = patientModuleRepository.findById(patient_id)
                .orElseThrow(() -> new Exception("Patient not found for this id :: " + patient_id));
        patientTable.setPatientUsername(patientDto.getPatientUsername());
        patientTable.setPatientFirstname(patientDto.getPatientFirstname());
        patientTable.setPatientLastname(patientDto.getPatientLastname());
        patientTable.setAddress(patientDto.getAddress());
        patientTable.setAdmissionDate(patientDto.getAdmissionDate());
        patientTable.setCity(patientDto.getCity());
        patientTable.setCountry(patientDto.getCountry());
        patientTable.setMaritalStatus(patientDto.getMaritalStatus());
        patientTable.setPatientAge(patientDto.getPatientAge());
        patientTable.setPatientDOB(patientDto.getPatientDOB());
        patientTable.setOccupation(patientDto.getOccupation());
        patientTable.setDischargeDate(patientDto.getDischargeDate());
        patientTable.setState(patientDto.getState());
        patientTable.setRegisterDate(patientDto.getRegisterDate());
        patientTable.setPatientEmail(patientDto.getPatientEmail());
        patientTable.setPostalCode(patientDto.getPostalCode());
        patientTable.setPatientMobileNumber(patientDto.getPatientMobileNumber());
        final PatientTable updateData = patientModuleRepository.save(patientTable);
        return ResponseEntity.ok(updateData);
    }

    public void doDeleteAll() {
        patientModuleRepository.deleteAllInBatch();
    }

    public void doDelete(int patient_id) {
        patientModuleRepository.deleteById(patient_id);
    }
}
