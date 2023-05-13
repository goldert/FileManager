package com.stc.filemanager.repositories;

import com.stc.filemanager.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

  List<Permission> findAllBy();
}