package com.colink02dev.Content_Management_Server.types.folder;

import com.nimbusds.jose.shaded.gson.JsonObject;

import java.io.File;
import java.util.Objects;

public final class MinecraftWorldFolderType implements FolderType {
    public boolean isType(File directory) {
        if(!directory.isDirectory()) return false;
        File[] files;
        if((files = directory.listFiles()) == null) return false;
        for(File file: files) {
            if(file.getName().equalsIgnoreCase("level.dat")) {
                return true;
            }
        }
        return false;
    }

@Override
public JsonObject getTypeData(File folder) {
        JsonObject typeData = new JsonObject();
        //TODO get data from level.dat and a perhaps load a map image of the world

        return typeData;
}
}
