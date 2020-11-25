package com.vitalsigns.module.api.vitalsignsmoduleapi.service;

import com.vitalsigns.module.api.vitalsignsmoduleapi.dto.VitalSignsDto;
import com.vitalsigns.module.api.vitalsignsmoduleapi.entity.VitalSignTable;
import com.vitalsigns.module.api.vitalsignsmoduleapi.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VitalSignModuleService {

    public VitalSignTable addVitalSignRecord(VitalSignsDto vitalSignsDto);

    public VitalSignTable getPatientData(int consulting_id) throws ResourceNotFoundException;

    public void doDelete(int consulting_id) throws ResourceNotFoundException;

    public void doDeleteAll();

    public List<VitalSignTable> getAllRecords();

    public ResponseEntity<VitalSignTable> updateByUser(int consulting_id, VitalSignsDto vitalsignDto) throws ResourceNotFoundException;
}
