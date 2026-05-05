package com.edu.Institiute.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import software.amazon.ion.Decimal;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "servicearea")
public class ServiceArea {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zipCode")
    private String zipCode;

    @Column(name="maxDistance")
    private Integer maxDistance;

    @Column(name="travelFee")
    private Decimal travelFee;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="modifyBy")
    private String modifyBy;

    @Column(name="modifyDate")
    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name="professional_id", referencedColumnName = "professional_id")
    private ServiceProfessional serviceProfessional;

    @ManyToOne
    @JoinColumn(name="status_id", referencedColumnName = "id")
    private Status status;
}
