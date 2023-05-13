package com.stc.filemanager.entities;

import com.stc.filemanager.enums.ItemType;
import lombok.Data;


import jakarta.persistence.*;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "parentId")
    private Long parentId;

    @Column(name = "type", nullable = false)
    private ItemType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "permissionGroupId")
    private Long permissionGroupId;

    public Item() {
    }

    public Item(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }
    //    @OneToMany(mappedBy = "space")
//    private List<Folder> folders;

//    public Space() {}

//    public Space(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }


}
