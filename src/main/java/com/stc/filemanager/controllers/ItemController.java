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
    private ItemService spaceService;

    @PostMapping("/space")
    public @ResponseBody ResponseEntity<?> createSpace(@RequestBody SpaceDTO spaceDTO) {
        try {
            return new ResponseEntity<>(spaceService.createSpace(spaceDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/folder")
    public @ResponseBody ResponseEntity<?> createFolder(@RequestBody FolderDto folderDto) {
        try {
            return new ResponseEntity<>(spaceService.createFolder(folderDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "file/{parentId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public @ResponseBody ResponseEntity<?> createFile(@PathVariable Long parentId, @RequestParam("file") MultipartFile file) {
        try {
            spaceService.createFile(parentId, file);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping("/{spaceId}")
//    public @ResponseBody ResponseEntity<?> getSpace(@PathVariable Long spaceId) {
//        try {
//            Item space = spaceService.getSpace(spaceId);
//            return new ResponseEntity<>(space, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

//    @GetMapping("/{spaceId}/folders")
//    public ResponseEntity<?> getFolders(@PathVariable Long spaceId) {
//        try {
//            List<FolderDto> folders = spaceService.getFolders(spaceId);
//            return ResponseEntity.ok().body(folders);
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/{spaceId}/folders")
//    public ResponseEntity<?> createFolder(@PathVariable Long spaceId, @RequestBody FolderDto folderDto) {
//        try {
//            Folder folder = spaceService.createFolder(spaceId, folderDto);
//            return ResponseEntity.ok().body(folder);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
}
