package com.colink02dev.Content_Management_Server.types.folder;

import com.nimbusds.jose.shaded.gson.JsonObject;

import java.io.File;

public interface FolderType {
    boolean isType(File folder);
    JsonObject getTypeData(File folder);
}
