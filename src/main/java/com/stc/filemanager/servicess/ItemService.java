package com.stc.filemanager.servicess;

import com.stc.filemanager.dto.FolderDto;
import com.stc.filemanager.dto.SpaceDTO;
import com.stc.filemanager.entities.File;
import com.stc.filemanager.entities.Item;
import com.stc.filemanager.entities.Permission;
import com.stc.filemanager.entities.PermissionGroup;
import com.stc.filemanager.enums.ItemType;
import com.stc.filemanager.enums.PermissionLevel;
import com.stc.filemanager.repositories.FileRepository;
import com.stc.filemanager.repositories.ItemRepository;
import com.stc.filemanager.repositories.PermissionGroupRepository;
import com.stc.filemanager.repositories.PermissionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    FileRepository fileRepository;

    public Item createSpace(SpaceDTO spaceDTO) throws Exception {
        Optional<PermissionGroup> isGroupExist = permissionGroupRepository.findById(spaceDTO.getPermissionGroupId());
        if (isGroupExist.isEmpty()) {
            throw new Exception("Group id is incorrect!");
        }

        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(spaceDTO, Item.class);
        item.setId(0L);
        item.setType(ItemType.SPACE);
        return itemRepository.save(item);
    }

    public Item createFolder(FolderDto folderDto, String user_email) throws Exception {
        // Applying security
        Permission permission = permissionRepository.findByUserEmail(user_email);
        if (permission == null) {
            throw new Exception("User is incorrect!");
        }

        List<Item> isParentExist = itemRepository.findAllByIdAndType(folderDto.getParentId(), ItemType.SPACE);
        if (isParentExist.size() == 0) {
            throw new Exception("Parent doesn't exit");
        }

        Item parentGroupId = itemRepository.findById(folderDto.getParentId());
        if (permission.getPermissionLevel().equals(PermissionLevel.VIEW) || !permission.getPermissionGroup().equals(parentGroupId.getPermissionGroupId())) {
            throw new Exception("User is not authorised");
        }

        Optional<PermissionGroup> isGroupExist = permissionGroupRepository.findById(folderDto.getPermissionGroupId());
        if (isGroupExist.isEmpty()) {
            throw new Exception("Group id is incorrect!");
        }

        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(folderDto, Item.class);
        item.setId(0L);
        item.setType(ItemType.FOLDER);
        return itemRepository.save(item);
    }

    public void createFile(Long parentId, MultipartFile file, String user_email) throws Exception {
        // Applying security
        Permission permission = permissionRepository.findByUserEmail(user_email);
        if (permission == null) {
            throw new Exception("User is incorrect!");
        }

        List<Item> isParentExist = itemRepository.findAllByIdAndType(parentId, ItemType.FOLDER);
        if (isParentExist.size() == 0) {
            throw new Exception("Parent doesn't exit");
        }

        Item parentGroupId = itemRepository.findById(parentId);
        if (permission.getPermissionLevel().equals(PermissionLevel.VIEW) || !permission.getPermissionGroup().equals(parentGroupId.getPermissionGroupId())) {
            throw new Exception("User is not authorised");
        }

        Item item  = new Item();
        item.setId(0L);
        item.setParentId(parentId);
        item.setType(ItemType.FILE);
        item.setName(file.getOriginalFilename());
        item.setPermissionGroupId(permission.getPermissionGroup());

        Item fileMetadata = itemRepository.save(item);

        File fileEntity = new File();
        fileEntity.setBinary(file.getBytes());
        fileEntity.setItem(fileMetadata.getId());
        fileRepository.save(fileEntity);
    }

    public List<Item> getItems() {
        return itemRepository.findAllBy();
    }
}
