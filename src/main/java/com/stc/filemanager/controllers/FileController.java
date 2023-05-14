package com.stc.filemanager.controllers;

import com.stc.filemanager.servicess.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/{fileId}")
    public ResponseEntity<?> getFile(@PathVariable Long fileId, @RequestHeader String user_email) {
        try {
            byte[] resource = fileService.getFileContent(fileId, user_email);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileService.getFileMetadata(fileId, user_email).getName())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(resource.length)
                    .body(resource);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/metadata/{fileId}")
    public ResponseEntity<?> getFileMetadata(@PathVariable Long fileId, @RequestHeader String user_email) {
        try {
            return new ResponseEntity<>(fileService.getFileMetadata(fileId, user_email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}