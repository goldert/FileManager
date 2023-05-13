package com.stc.filemanager;

import com.stc.filemanager.entities.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagerApplication.class, args);
    }

//    public void run(String... args) throws Exception {
//
//
       // Item item = new Item(1, "group");
//
//        item.save();
//    }
}
