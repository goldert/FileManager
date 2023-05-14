package com.stc.filemanager.controllers;


import com.stc.filemanager.dto.FolderDto;
import com.stc.filemanager.dto.SpaceDTO;
import com.stc.filemanager.servicess.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/space")
    public @ResponseBody ResponseEntity<?> createSpace(@RequestBody SpaceDTO spaceDTO) {
        try {
            return new ResponseEntity<>(itemService.createSpace(spaceDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/folder")
    public @ResponseBody ResponseEntity<?> createFolder(@RequestBody FolderDto folderDto, @RequestHeader String user_email) {
        try {
            return new ResponseEntity<>(itemService.createFolder(folderDto, user_email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "file/{parentId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public @ResponseBody ResponseEntity<?> createFile(@PathVariable Long parentId, @RequestParam("file") MultipartFile file, @RequestHeader String user_email) {
        try {
            itemService.createFile(parentId, file, user_email);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> getItems() {
        try {
            return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
