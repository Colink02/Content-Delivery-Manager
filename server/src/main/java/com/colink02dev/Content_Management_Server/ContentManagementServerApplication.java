package com.colink02dev.Content_Management_Server;

import com.colink02dev.Content_Management_Server.utils.FileUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void getFiles(HttpServletResponse response, @RequestParam String directory) throws IOException {
		// TODO prevent directory traversal attacks using ../ ./ or absolute paths /
			if(baseFilePath.toFile().isDirectory()) {
				response.addHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("application/json");
				Path path = baseFilePath;
				if (directory != null) {
					path = path.resolve(directory);
				}
				response.getWriter().write(FileUtils.getFiles(path.toFile().listFiles()).toString());
			}
		// response.setContentType("application/json");
		// response.getWriter().write("Error");
	}




}
