package com.stc.filemanager.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission_groups")
public class PermissionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;


//    @OneToMany(mappedBy = "permissionGroup", cascade = CascadeType.ALL)
//    private Set<Item> items = new HashSet<>();


}
