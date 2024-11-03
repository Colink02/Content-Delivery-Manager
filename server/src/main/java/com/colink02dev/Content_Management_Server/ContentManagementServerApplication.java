package com.colink02dev.Content_Management_Server;

import com.nimbusds.jose.shaded.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Path;

@RestController
@SpringBootApplication
public class ContentManagementServerApplication {

	private final Path baseFilePath = new File("/").toPath();

	public static void main(String[] args) {
		SpringApplication.run(ContentManagementServerApplication.class, args);
	}

	@GetMapping("/files")
	public JsonObject getFiles(String directory) {
		// TODO prevent directory traversal attacks using ../ ./ or absolute paths /
		if(directory.isEmpty()) {
			if(baseFilePath.getParent().toFile().isDirectory()) {
				baseFilePath.getParent().toFile().listFiles();
				//TODO use FileUtils
			}
		}
	}




}
