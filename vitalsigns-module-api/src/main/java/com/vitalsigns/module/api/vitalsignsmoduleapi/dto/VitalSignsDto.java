package com.vitalsigns.module.api.vitalsignsmoduleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalSignsDto {

    private int consultingId;

    private int respirationRate;

    private int bloodPressure;

    private float bodyTemperature;

    private int pulseRate;

    private int sugarLevel;

    private float weight;

    private float height;

    private float spo2_sat;

    private float pt_inr;

    private int scanId;

    private String scanName;

    private String scanReportDetails;

    private Date patientConsultingDate;

    private int patientId;

    private String createdUser;

    private LocalDateTime createdDate;

    private String lastUpdatedUser;

    private LocalDateTime lastUpdateDate;
}
