package com.stc.filemanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "permission_level")
    private String permissionLevel;

    @Column(name = "group_id")
    private String permissionGroup;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id")
//    private PermissionGroup permissionGroup;

    // getters and setters
}