package com.patient.module.api.patientmoduleapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PatientDto {

    private int patientId;

    private String patientUsername;

    private String patientFirstname;

    private String patientLastname;

    private Date patientDOB;

    private int patientAge;

    private String patientGender;

    private long patientMobileNumber;

    private String patientEmail;

    private String address;

    private long postalCode;

    private String city;

    private String state;

    private String country;

    private String maritalStatus;

    private String occupation;

    private Date registerDate;

    private Date admissionDate;

    private Date dischargeDate;

    private String createdUser;

    private LocalDateTime createdDate;

    private String lastUpdatedUser;

    private LocalDateTime lastUpdatedDate;
}
