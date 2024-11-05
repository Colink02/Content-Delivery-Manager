package com.colink02dev.Content_Management_Server;

import com.colink02dev.Content_Management_Server.utils.FileUtils;
import com.nimbusds.jose.shaded.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@RestController
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ContentManagementServerApplication {

	private final Path baseFilePath = new File("/").toPath();

	public static void main(String[] args) {
		SpringApplication.run(ContentManagementServerApplication.class, args);
	}


	@GetMapping("/files")
	public void getFiles(HttpServletResponse response, String directory) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		// TODO prevent directory traversal attacks using ../ ./ or absolute paths /
		if(directory == null || directory.isEmpty()) {
			if(baseFilePath.toFile().isDirectory()) {
				response.setContentType("application/json");
				response.getWriter().write(FileUtils.getFiles(baseFilePath.toFile().listFiles()).toString());
				return;
			}
		}
		response.setContentType("application/json");
		response.getWriter().write("Error");
	}




}
