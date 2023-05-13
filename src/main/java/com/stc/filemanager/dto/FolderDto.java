package com.stc.filemanager.dto;

import lombok.Data;

@Data
public class FolderDto {

    private Long parentId;
    private String name;
    private Long permissionGroupId;
}
