package com.stc.filemanager.servicess;

import com.stc.filemanager.entities.PermissionGroup;
import com.stc.filemanager.repositories.PermissionGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionGroupService  {

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;


    public void createPermissionGroup(PermissionGroup perm) {
      //  PermissionGroup group = new PermissionGroup();
     //   group.setGroupName(groupName);
        //return
         permissionGroupRepository.save(perm);
    }
//
//    @Override
//    public PermissionGroup getPermissionGroupById(Long id) {
//        return permissionGroupRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("PermissionGroup", "id", id));
//    }
//
//    @Override
//    public List<PermissionGroup> getAllPermissionGroups() {
//        return permissionGroupRepository.findAll();
//    }
//
//    @Override
//    public void deletePermissionGroup(Long id) {
//        PermissionGroup group = getPermissionGroupById(id);
//        permissionGroupRepository.delete(group);
//    }
//
//    @Override
//    public PermissionGroup updatePermissionGroup(Long id, PermissionGroup groupDetails) {
//        PermissionGroup group = getPermissionGroupById(id);
//        group.setGroupName(groupDetails.getGroupName());
//        return permissionGroupRepository.save(group);
//    }
}
