package com.stc.filemanager.repositories;
import com.stc.filemanager.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findById(Long fileId);

   // @Query(value = "select p.user_email from permissions p where p.user_email = ?1", nativeQuery = true)
    //Optional<Permission> ss(String user_email);
}
