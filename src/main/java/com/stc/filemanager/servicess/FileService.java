package com.stc.filemanager.servicess;

import com.stc.filemanager.entities.Item;
import com.stc.filemanager.entities.Permission;
import com.stc.filemanager.enums.ItemType;
import com.stc.filemanager.enums.PermissionLevel;
import com.stc.filemanager.repositories.FileRepository;
import com.stc.filemanager.repositories.ItemRepository;
import com.stc.filemanager.repositories.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PermissionRepository permissionRepository;

    public byte[] getFileContent(Long fileId, String user_email) throws Exception {
        // Applying security
        Permission permission = permissionRepository.findByUserEmail(user_email);
        if (permission == null) {
            throw new Exception("User is incorrect!");
        }

        if (permission.getPermissionLevel().equals(PermissionLevel.VIEW) || !permission.getPermissionGroup()
                .equals(itemRepository.findById(fileRepository.findById(fileId).get().getItem()).getPermissionGroupId())) {
            throw new Exception("User is not authorised");
        }

        byte[] file = fileRepository.findById(fileId).get().getBinary();
        return file;
    }

    public Item getFileMetadata(Long fileId, String user_email) throws Exception {
        // Applying security
        Permission permission = permissionRepository.findByUserEmail(user_email);
        if (permission == null) {
            throw new Exception("User is incorrect!");
        }

        if (permission.getPermissionLevel().equals(PermissionLevel.VIEW) || !permission.getPermissionGroup()
                .equals(itemRepository.findById(fileRepository.findById(fileId).get().getItem()).getPermissionGroupId())) {
            throw new Exception("User is not authorised");
        }

        return itemRepository.findById(fileRepository.findById(fileId).get().getItem());
    }
}
