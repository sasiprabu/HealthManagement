package com.patient.module.api.patientmoduleapi.controller;

import com.patient.module.api.patientmoduleapi.client.VitalSignClient;
import com.patient.module.api.patientmoduleapi.dto.PatientDto;
import com.patient.module.api.patientmoduleapi.dto.VitalSignsDto;
import com.patient.module.api.patientmoduleapi.entity.PatientTable;
import com.patient.module.api.patientmoduleapi.exception.ResourceNotFoundException;
import com.patient.module.api.patientmoduleapi.service.PatientModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientModuleController {

    private PatientModuleService patientModuleService;

    @Autowired
    private VitalSignClient vitalSignClient;

    @Lazy
    @Autowired
    public PatientModuleController(PatientModuleService patientModuleService) {
        this.patientModuleService = patientModuleService;
    }

    @GetMapping("/vitalsign/findAllDetails")
    public List<VitalSignsDto> getAllDetails(){
        return vitalSignClient.getAllRecords();
    }

    /**
     * Getting the patient consulting data
     * @param consulting_id
     * @return consulting_id
     *  */
    @GetMapping("/vitalsign/{consulting_id}")
//    @Cacheable(value = "vital", key = "#consulting_id")
    public VitalSignsDto getPatientData(@PathVariable int consulting_id) throws ResourceNotFoundException {
        return vitalSignClient.getPatientData(consulting_id);
    }

    /**
     * Register a new patient for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @PostMapping("/")
    public PatientTable insertPatientDetail(@RequestBody PatientDto patientDto) {
        return patientModuleService.insertPatientDetail(patientDto);
    }

    /**
     * Register a new user for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @GetMapping("/{patient_id}")
    public PatientTable getPatientDetail(@PathVariable int patient_id) {
        return patientModuleService.getPatientDetail(patient_id);
    }

    /**
     * Register a new user for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @GetMapping("/patientList")
    public List<PatientTable> allPatientDetails() {
        return patientModuleService.allPatientDetails();
    }

    /**
     * Register a new user for respective roles
     * @Param   Identification for a new user
     * @return  the user data,if not found return a null
     * */
    @PutMapping("/{patient_id}")
    public ResponseEntity<PatientTable> doUpdate(@PathVariable int patient_id,
                                                  @RequestBody PatientDto patientDto) throws Exception{
        return patientModuleService.doUpdate(patient_id,patientDto);
    }

    @DeleteMapping("/{patient_id}")
    public void doDelete(@PathVariable int patient_id){
        patientModuleService.doDelete(patient_id);
    }

    @DeleteMapping("/remove-all")
    public void doDeleteAll(){
        patientModuleService.doDeleteAll();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/vitalAPI")
    public String invokeVitalSignService() {
        URI uri = discoveryClient.getInstances("Vitalsigns-Module-API").stream().map(si -> si.getUri()).findFirst()
                .map(s -> s.resolve("/vitalsigns/records")).get();
        return restTemplate.getForObject(uri, String.class);
    }
}
