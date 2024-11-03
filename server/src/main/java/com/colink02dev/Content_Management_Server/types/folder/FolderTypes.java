package com.colink02dev.Content_Management_Server.types.folder;

import java.io.File;
import java.util.function.Function;

public enum FolderTypes {
    MINECRAFT_WORLD("minecraft_world", new MinecraftWorldFolderType());

    private final FolderType typeHandler;
    private final String folderType;
    FolderTypes(String folderType, FolderType typeHandler) {
        this.folderType = folderType;
        this.typeHandler = typeHandler;
    }

    public FolderType getHandler() {
        return typeHandler;
    }

public String getTypeId() {
        return folderType;
}
}
