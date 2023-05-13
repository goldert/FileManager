package com.stc.filemanager.servicess;

import com.stc.filemanager.dto.FolderDto;
import com.stc.filemanager.dto.SpaceDTO;
import com.stc.filemanager.entities.File;
import com.stc.filemanager.entities.Item;
import com.stc.filemanager.enums.ItemType;
import com.stc.filemanager.repositories.FileRepository;
import com.stc.filemanager.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    FileRepository fileRepository;

    public Item createSpace(SpaceDTO spaceDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(spaceDTO, Item.class);
        item.setType(ItemType.SPACE);
        return itemRepository.save(item);
    }

    public Item createFolder(FolderDto folderDto) throws Exception {
        List<Item> isParentExist = itemRepository.findAllByIdAndType(folderDto.getParentId(), ItemType.SPACE);
        if (isParentExist.size() == 0) {
            throw new Exception("Parent doesn't exit");
        }

        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(folderDto, Item.class);
        item.setId(0L);
        item.setType(ItemType.FOLDER);
        return itemRepository.save(item);
    }

    public void createFile(Long parentId, MultipartFile file) throws Exception {
        List<Item> isParentExist = itemRepository.findAllByIdAndType(parentId, ItemType.FOLDER);
        if (isParentExist.size() == 0) {
            throw new Exception("Parent doesn't exit");
        }

        Item item  = new Item();
        item.setId(0L);
        item.setParentId(parentId);
        item.setType(ItemType.FILE);
        item.setName(file.getOriginalFilename());
        Item newRecord = itemRepository.save(item);

        File fileEntity = new File();
        fileEntity.setBinary(file.getBytes());
        fileEntity.setItem(newRecord.getId());
         fileRepository.save(fileEntity);
    }

    public Item getSpace(Long spaceId) {
//        PermissionGroup group = permissionGroupRepository.findByGroupName(groupName);
//        if (group == null) {
//            throw new NotFoundException("Permission group not found");
//        }
//        Item space = new Item(ItemType.SPACE, name);
//        space.setPermissionGroup(group);
//        itemRepository.save(space);
//        return new SpaceDto(space);

        return itemRepository.findAllById(spaceId);
    }


//    public FolderDto createFolder(Long spaceId, String name) {
//        Item space = itemRepository.findByIdAndType(spaceId, ItemType.SPACE);
//        if (space == null) {
//            throw new NotFoundException("Space not found");
//        }
//        Folder folder = new Folder(name);
//        folder.setParent(space);
//        itemRepository.save(folder);
//        return new FolderDto(folder);
//    }


//    public FileDto createFile(Long folderId, String name, byte[] binary) {
//        Item folder = itemRepository.findByIdAndType(folderId, ItemType.FOLDER);
//        if (folder == null) {
//            throw new NotFoundException("Folder not found");
//        }
//        File file = new File(name, binary);
//        file.setParent(folder);
//        itemRepository.save(file);
//        return new FileDto(file);
//    }
}
