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
@Table(name = "adminuser")
public class AdminUser {

    @Id
    @Column(name = "admin_id")
    private String adminId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AdminRole role;

    @Column(name = "permissions")
    private String permission;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "modifyBy")
    private String modifyBy;

    @Column(name = "modifyDate")
    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;



    public String getPermissions() {
        return this.permission;
    }

    public void setPermissions(String permissions) {
        this.permission = permissions;
    }
}
