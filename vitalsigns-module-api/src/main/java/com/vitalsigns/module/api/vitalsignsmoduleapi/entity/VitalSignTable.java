package com.vitalsigns.module.api.vitalsignsmoduleapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vitalsign_table")
@EntityListeners(AuditingEntityListener.class)
public class VitalSignTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
    @SequenceGenerator(initialValue = 1, allocationSize = 1000, name = "gen")
    @Column(name = "consulting_id")
    private int consultingId;

    @Column(name = "respiration_rate")
    private int respirationRate;

    @Column(name = "blood_pressure")
    private int bloodPressure;

    @Column(name = "body_temperature")
    private float bodyTemperature;

    @Column(name = "pulse_rate")
    private int pulseRate;

    @Column(name = "sugar_level")
    private int sugarLevel;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private float height;

    @Column(name = "SPO2_Sat")
    private float spo2_sat;

    @Column(name = "PT_INR")
    private float pt_inr;

    @Column(name = "scan_id")
    private int scanId;

    @Column(name = "scan_name")
    private String scanName;

    @Column(name = "scan_report_details")
    private String scanReportDetails;

    @Column(name = "patient_consulting_date")
    private Date patientConsultingDate;

    @Column(name = "patient_id")
    private int patientId;

    @CreatedBy
    @Column(name = "created_user", updatable = false)
    private String createdUser;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;

    @LastModifiedDate
    @Column(name = "last_updated_date")
    private LocalDateTime lastUpdateDate;
}
