package com.stc.filemanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permission_groups")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

}
