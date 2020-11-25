package com.vitalsigns.module.api.vitalsignsmoduleapi.controller;

import com.vitalsigns.module.api.vitalsignsmoduleapi.advice.TrackingExecuteTime;
import com.vitalsigns.module.api.vitalsignsmoduleapi.dto.VitalSignsDto;
import com.vitalsigns.module.api.vitalsignsmoduleapi.entity.VitalSignTable;
import com.vitalsigns.module.api.vitalsignsmoduleapi.exception.ResourceNotFoundException;
import com.vitalsigns.module.api.vitalsignsmoduleapi.service.VitalSignModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitalsigns")
public class VitalSignsModuleController {

    private VitalSignModuleService vitalSignsModuleService;

    @Lazy
    @Autowired
    public VitalSignsModuleController(VitalSignModuleService vitalSignModuleService) {
        super();
        this.vitalSignsModuleService = vitalSignModuleService;
    }

    /**
    * Inserting a vitalSigns data for consulting data
    * @param vitalSignsDto
    * @return vitalSignsDto data
    * */
    @TrackingExecuteTime
    @PostMapping("/")
    public VitalSignTable addVitalSignRecord(@RequestBody VitalSignsDto vitalSignsDto) {
        return vitalSignsModuleService.addVitalSignRecord(vitalSignsDto);
    }

    /**
     * Getting the patient consulting data
     * @param consulting_id
     * @return consulting_id
     *  */
    @GetMapping("/{consulting_id}")
    @Cacheable(value = "vital", key = "#consulting_id")
    public VitalSignTable getPatientData(@PathVariable int consulting_id) throws ResourceNotFoundException{
        return vitalSignsModuleService.getPatientData(consulting_id);
    }

    /**
     * Getting the patient consulting data
     * @return all vitalsigns records
     *  */
    @GetMapping("/records")
    public List<VitalSignTable> getAllRecords() {
        return vitalSignsModuleService.getAllRecords();
    }

    /**
     * Getting the patient consulting data
     * @param  consulting_id
     * @throws:- If deleting records does not exits then throw ResourceNotFoundException
     *  */
    @CacheEvict(value = "vital", key="#consulting_id")
    @DeleteMapping("/{consulting_id}")
    public void doDelete(@PathVariable int consulting_id) throws ResourceNotFoundException{
        vitalSignsModuleService.doDelete(consulting_id);
    }

    /**
     * Delete all the patient consulting data
     *  */
    @DeleteMapping("/delete-all")
    public void doDeleteAll(){
        vitalSignsModuleService.doDeleteAll();
    }

    @PutMapping("/")
    @CachePut(value = "vital")
    public ResponseEntity<VitalSignTable> updateByUser(@PathVariable int consulting_id,
                                                  @RequestBody VitalSignsDto vitalsignDto) throws ResourceNotFoundException {
        return vitalSignsModuleService.updateByUser(consulting_id,vitalsignDto);
    }

}
