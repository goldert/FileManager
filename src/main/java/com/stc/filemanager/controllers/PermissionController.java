package com.stc.filemanager.controllers;

import com.stc.filemanager.servicess.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @GetMapping
    public @ResponseBody ResponseEntity<?> getPermissions() {
        try {
            return new ResponseEntity<>(permissionService.getPermissions(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
