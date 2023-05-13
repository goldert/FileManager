package com.stc.filemanager.repositories;

import com.stc.filemanager.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
  //  Optional<Permission> findByUserEmailAndItem(String userEmail, Item item);
 //   List<Permission> findByItem(Item item);

  Permission findAllById(Long spaceId);
}