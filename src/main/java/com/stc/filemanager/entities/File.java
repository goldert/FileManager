package com.stc.filemanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(name = "file")
        private byte[] binary;

//        @OneToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "item_id")
//        private Item item;
}
