package com.stc.filemanager.controllers;

import com.stc.filemanager.servicess.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @Autowired
    private FileService fileService;


    @GetMapping("/{fileId}")
    public ResponseEntity<String> getFile(@PathVariable Long fileId) {
        byte[] resource = fileService.getFile(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=33" )
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.length)
                .body("");
    }
}