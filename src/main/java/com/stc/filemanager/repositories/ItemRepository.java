package com.stc.filemanager.repositories;

import com.stc.filemanager.entities.Item;
import com.stc.filemanager.enums.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends  JpaRepository<Item, Integer> {

    List<Item> findAllBy();

    List<Item> findAllByIdAndType(Long parentId, ItemType type);

    Item findById(Long Id);
}