package com.patient.module.api.patientmoduleapi.client;

import com.patient.module.api.patientmoduleapi.dto.VitalSignsDto;
import com.patient.module.api.patientmoduleapi.exception.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "vitalsigns", url = "http://localhost:8585/vitalsigns")
public interface VitalSignClient {

    @GetMapping("/records")
    public List<VitalSignsDto> getAllRecords();

    @GetMapping("/{consulting_id}")
    public VitalSignsDto getPatientData(@PathVariable int consulting_id) throws ResourceNotFoundException;

}
