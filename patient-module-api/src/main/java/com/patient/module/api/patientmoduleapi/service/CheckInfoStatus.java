package com.patient.module.api.patientmoduleapi.service;

import com.patient.module.api.patientmoduleapi.repository.PatientModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class CheckInfoStatus implements InfoContributor {

    private PatientModuleRepository patientModuleRepository;

    @Lazy
    @Autowired
    public CheckInfoStatus(PatientModuleRepository patientModuleRepository) {
        this.patientModuleRepository = patientModuleRepository;
    }

    @Override
    public void contribute(Info.Builder builder) {
        LinkedHashMap<String,Long> patientDetails = new LinkedHashMap<>();
        patientDetails.put("Patients-Total-Count", patientModuleRepository.count());
        patientDetails.put("senior-citizens", patientModuleRepository.getSeniorCitizensCount(50));
        patientDetails.put("Child-count", patientModuleRepository.getChildCount(10));
        builder.withDetail("Patient-details", patientDetails);
    }
}
