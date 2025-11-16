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
@Table(name = "client")
public class Client {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="homeAddress")
    private String homeAddress;

    @Column(name="preferredContactMethod")
    private String preferredContactMethod;

    @Column(name="emergencyContactName")
    private String emergencyContactName;

    @Column(name="emergencyContactPhone")
    private String emergencyContactPhone;

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
