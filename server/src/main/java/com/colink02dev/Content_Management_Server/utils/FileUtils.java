package com.colink02dev.Content_Management_Server.utils;

import com.colink02dev.Content_Management_Server.types.folder.FolderTypes;
import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonObject;

import java.io.File;

public class FileUtils {

public static JsonObject getFiles(File[] files) {
    JsonObject obj = new JsonObject();
    JsonArray folderData = new JsonArray();
    JsonArray fileData = new JsonArray();
    for (File file : files) {
        if (file.isDirectory()) {
            JsonObject folderInfo = new JsonObject();
            folderInfo.addProperty("name", file.getName());
            folderInfo.add("special_types", checkForSpecialFolderTypes(file));
            folderData.add(folderInfo);
        } else {
            JsonObject fileInfo = new JsonObject();
            fileInfo.addProperty("name", file.getName());
            fileData.add(fileInfo);
        }
    }
    obj.add("folders", folderData);
    obj.add("files", fileData);
    return obj;
}

private static JsonArray checkForSpecialFolderTypes(File folder) {
    JsonArray specialTypes = new JsonArray();
    for(FolderTypes type: FolderTypes.values()) {
        if(type.getHandler().isType(folder)) {
            JsonObject obj = new JsonObject();
            obj.addProperty("name", folder.getName());
            obj.add("data", type.getHandler().getTypeData(folder));
            specialTypes.add(obj);
        }
    }
    return specialTypes;
}


}
