package com.stc.filemanager.servicess;

import com.stc.filemanager.entities.Permission;
import com.stc.filemanager.repositories.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService  {

    private PermissionRepository permissionRepository;
//    private final ItemRepository itemRepository;


    public void createPermission(Permission perm) {

        permissionRepository.save(perm);
    }

//    public PermissionServiceImpl(PermissionRepository permissionRepository, ItemRepository itemRepository) {
//        this.permissionRepository = permissionRepository;
//        this.itemRepository = itemRepository;
//    }
//
//    @Override
//    public List<Permission> getPermissionsByUserAndItemId(String userEmail, Long itemId) {
//        List<Permission> permissions = permissionRepository.findByUserEmailAndItemId(userEmail, itemId);
//        return permissions;
//    }
//
//    @Override
//    public boolean hasPermission(String userEmail, Long itemId, PermissionLevel permissionLevel) {
//        List<Permission> permissions = getPermissionsByUserAndItemId(userEmail, itemId);
//        for (Permission permission : permissions) {
//            if (permission.getPermissionLevel().equals(permissionLevel)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean hasPermission(String userEmail, Long itemId, PermissionLevel[] permissionLevels) {
//        List<Permission> permissions = getPermissionsByUserAndItemId(userEmail, itemId);
//        for (Permission permission : permissions) {
//            for (PermissionLevel permissionLevel : permissionLevels) {
//                if (permission.getPermissionLevel().equals(permissionLevel)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean canUserAccessItem(String userEmail, Long itemId) {
//        List<Permission> permissions = getPermissionsByUserAndItemId(userEmail, itemId);
//        if (permissions.isEmpty()) {
//            return false;
//        }
//        for (Permission permission : permissions) {
//            if (permission.getPermissionLevel() != PermissionLevel.NONE) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void addPermission(Long itemId, String userEmail, PermissionLevel permissionLevel) {
//        Item item = itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
//        Permission permission = new Permission(userEmail, permissionLevel, item);
//        permissionRepository.save(permission);
//    }
//
//    @Override
//    public void removePermission(Long permissionId) {
//        permissionRepository.deleteById(permissionId);
//    }

}
