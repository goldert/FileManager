package com.stc.filemanager.dto;

import lombok.Data;

@Data
public class SpaceDTO {

    private String name;
    private Long permissionGroupId;

    public SpaceDTO(String name, Long permissionGroupId) {
        this.name = name;
        this.permissionGroupId = permissionGroupId;
    }
}
