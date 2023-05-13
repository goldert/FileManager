package com.stc.filemanager.entities;

import com.stc.filemanager.enums.PermissionLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "permission_level")
    private PermissionLevel permissionLevel;

    @Column(name = "group_id")
    private String permissionGroup;
}