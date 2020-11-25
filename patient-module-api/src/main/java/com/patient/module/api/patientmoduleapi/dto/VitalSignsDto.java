package com.patient.module.api.patientmoduleapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

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
