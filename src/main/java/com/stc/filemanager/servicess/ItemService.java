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

    public List<Item> getItems() {
        return itemRepository.findAllBy();
    }
}
