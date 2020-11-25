package com.vitalsigns.module.api.vitalsignsmoduleapi.serviceimpl;

import com.vitalsigns.module.api.vitalsignsmoduleapi.dto.VitalSignsDto;
import com.vitalsigns.module.api.vitalsignsmoduleapi.entity.VitalSignTable;
import com.vitalsigns.module.api.vitalsignsmoduleapi.exception.ResourceNotFoundException;
import com.vitalsigns.module.api.vitalsignsmoduleapi.repository.VitalSignsModuleRepository;
import com.vitalsigns.module.api.vitalsignsmoduleapi.service.VitalSignModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/* VitalSignsModuleServiceImpl class used to access the VitalSignsModuleRepository
 * @Author Sasiprabu
 * */
@Service
public class VitalSignsModuleServiceImpl implements VitalSignModuleService {

    private VitalSignsModuleRepository vitalSignsModuleRepository;

    @Lazy
    @Autowired
    public VitalSignsModuleServiceImpl(VitalSignsModuleRepository vitalSignsModuleRepository) {
        this.vitalSignsModuleRepository = vitalSignsModuleRepository;
    }

    /* Inserting a vitalSigns data for consulting data
     * @param vitalSignsDto
     * @return patient_id data
     * */
    public VitalSignTable addVitalSignRecord(VitalSignsDto vitalSignsDto) {
        VitalSignTable vitalData = new VitalSignTable();
        vitalData.setConsultingId(vitalSignsDto.getConsultingId());
        vitalData.setBloodPressure(vitalSignsDto.getBloodPressure());
        vitalData.setBodyTemperature(vitalSignsDto.getBodyTemperature());
        vitalData.setPatientConsultingDate(vitalSignsDto.getPatientConsultingDate());
        vitalData.setPulseRate(vitalSignsDto.getPulseRate());
        vitalData.setRespirationRate(vitalSignsDto.getRespirationRate());
        vitalData.setScanId(vitalSignsDto.getScanId());
        vitalData.setScanName(vitalSignsDto.getScanName());
        vitalData.setScanReportDetails(vitalSignsDto.getScanReportDetails());
        vitalData.setWeight(vitalSignsDto.getWeight());
        vitalData.setHeight(vitalSignsDto.getHeight());
        vitalData.setPt_inr(vitalSignsDto.getPt_inr());
        vitalData.setSpo2_sat(vitalSignsDto.getSpo2_sat());
        vitalData.setSugarLevel(vitalSignsDto.getSugarLevel());
        vitalData.setPatientId(vitalSignsDto.getPatientId());
        return vitalSignsModuleRepository.save(vitalData);
    }

    /* Inserting a vitalSigns data for consulting data
     * @param patient_id
     * @return patient_id data
     * */
    public VitalSignTable getPatientData(int consulting_id) throws ResourceNotFoundException{
        System.out.println("Fetching from DB getPatientData() "+consulting_id);
        return vitalSignsModuleRepository.findById(consulting_id).orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + consulting_id));
    }

    public VitalSignTable updatePatientRecord(VitalSignTable vitalSignTable) {
        return vitalSignsModuleRepository.save(vitalSignTable);
    }

    public void doDelete(int consulting_id) throws ResourceNotFoundException {
        VitalSignTable vitalData = vitalSignsModuleRepository.findById(consulting_id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + consulting_id));
        vitalSignsModuleRepository.deleteById(consulting_id);
    }

    public void doDeleteAll() {
        vitalSignsModuleRepository.deleteAll();
    }

    public List<VitalSignTable> getAllRecords() {
        return vitalSignsModuleRepository.findAll();
    }

    public ResponseEntity<VitalSignTable> updateByUser(int consulting_id, VitalSignsDto vitalSignsDto) throws ResourceNotFoundException {
        VitalSignTable vitalData = vitalSignsModuleRepository.findById(consulting_id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + consulting_id));
        vitalData.setConsultingId(vitalSignsDto.getConsultingId());
        vitalData.setBloodPressure(vitalSignsDto.getBloodPressure());
        vitalData.setBodyTemperature(vitalSignsDto.getBodyTemperature());
        vitalData.setPatientConsultingDate(vitalSignsDto.getPatientConsultingDate());
        vitalData.setPulseRate(vitalSignsDto.getPulseRate());
        vitalData.setRespirationRate(vitalSignsDto.getRespirationRate());
        vitalData.setScanId(vitalSignsDto.getScanId());
        vitalData.setScanName(vitalSignsDto.getScanName());
        vitalData.setScanReportDetails(vitalSignsDto.getScanReportDetails());
        vitalData.setWeight(vitalSignsDto.getWeight());
        vitalData.setHeight(vitalSignsDto.getHeight());
        vitalData.setPt_inr(vitalSignsDto.getPt_inr());
        vitalData.setSpo2_sat(vitalSignsDto.getSpo2_sat());
        vitalData.setSugarLevel(vitalSignsDto.getSugarLevel());
        vitalData.setPatientId(vitalSignsDto.getPatientId());
        final VitalSignTable vitalUpdate = vitalSignsModuleRepository.save(vitalData);
        return ResponseEntity.ok(vitalUpdate);
    }
}
