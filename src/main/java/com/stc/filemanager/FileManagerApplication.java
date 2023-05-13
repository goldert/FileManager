package com.stc.filemanager;

import com.stc.filemanager.dto.SpaceDTO;
import com.stc.filemanager.entities.Item;
import com.stc.filemanager.repositories.ItemRepository;
import com.stc.filemanager.servicess.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagerApplication {


    public static void main(String[] args) {
        SpringApplication.run(FileManagerApplication.class, args);

//        Item item = new Item(1L, "group");
//        SpaceDTO spaceDTO = new SpaceDTO("group",1L);
//       // ItemService itemService = new ItemService() ;
//        itemService.createSpace(spaceDTO);
//
//        //ItemRepository.save(item);
//        System.out.println("tttttttttttttttttttttttttttttttttttttttttt");


    }





}
