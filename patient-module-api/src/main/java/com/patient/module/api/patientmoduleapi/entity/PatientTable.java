package com.patient.module.api.patientmoduleapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name ="patient_table")
public class PatientTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pat_gen")
    @SequenceGenerator(initialValue = 200, allocationSize = 5000, name = "pat_gen")
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "username")
    private String patientUsername;

    @Column(name = "firstname")
    private String patientFirstname;

    @Column(name = "lastname")
    private String patientLastname;

    @Column(name = "gender")
    private String patientGender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "dob")
    private Date patientDOB;

    @Column(name = "age")
    private int patientAge;

    @Column(name = "mobile_no")
    private long patientMobileNumber;

    @Column(name = "email")
    private String patientEmail;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postal_code")
    private long postalCode;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "discharge_date")
    private Date dischargeDate;

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
    private LocalDateTime lastUpdatedDate;

}
