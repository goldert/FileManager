package com.stc.filemanager.servicess;

import com.stc.filemanager.entities.Permission;
import com.stc.filemanager.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService  {

     @Autowired
     PermissionRepository permissionRepository;

     public List<Permission> getPermissions() {
         return permissionRepository.findAllBy();
     }
}
