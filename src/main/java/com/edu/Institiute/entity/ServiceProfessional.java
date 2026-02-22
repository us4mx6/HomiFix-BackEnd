package com.edu.Institiute.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "serviceprofessional")
public class ServiceProfessional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professionalId;

    @Column(name="businessName")
    private String businessName;

    @Column(name="businessRegistrationNumber")
    private String businessRegistrationNumber;

    @Column(name="businessAddress")
    private String businessAddress;

    @Column(name="description")
    private String description;

    @Column(name="yearsOfExperience")
    private String yearsOfExperience;

    @Column(name="isVerified")
    private Boolean isVerified;

    @Column(name="verificationDate")
    private Date verificationDate;

    @Column(name="overallRating")
    private Long overallRating;

    @Column(name="totalJobsCompleted")
    private Integer totalJobsCompleted;

    @Column(name="responseRate")
    private Long responseRate;

    @Column(name="avgResponseTime")
    private String avgResponseTime;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="modifyBy")
    private String modifyBy;

    @Column(name="modifyDate")
    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;
}
