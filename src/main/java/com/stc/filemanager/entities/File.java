package com.stc.filemanager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "files")
public class File {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Lob
        @Column(name = "file")
        private byte[] binary;

        @Column(name = "item_id")
        private Long item;

}
