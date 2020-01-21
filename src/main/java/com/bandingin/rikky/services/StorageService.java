package com.bandingin.rikky.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
@PropertySource("classpath:application.properties")
@Service
public class StorageService {
	
	public String PathImageName = "C:\\images\\";
	public String PathFileName = "C:\\images\\";
	
	public StorageService(@Value("${app.init.isProduction}") Boolean production) {
		if(production) {
			 PathImageName = "/opt/tomcat/webapps/assets/images";
			 PathFileName = "/opt/tomcat/webapps/assets/file";
		}else {
			 PathImageName = "C:\\images\\";
			 PathFileName = "C:\\images\\";
		}
	}
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocationImage = Paths.get(PathImageName);
    private final Path rootLocationFiles = Paths.get(PathFileName);
 
    public void store(MultipartFile file, String url, String hashName) {
        try {
        	// Init Check Folder Images for the first time
//        	Path imageFolderLocation = Paths.get("images");
//        	if(!Files.exists(imageFolderLocation)) {
//        		this.initImageFolder(imageFolderLocation);
//        	}
        	
        	Path folderLocation = Paths.get(rootLocationImage + url);
        	System.out.println(folderLocation.toString());
        	if(Files.exists(folderLocation)) {
        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
        	}else {
        		this.init(folderLocation);
        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
        	}
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
    
    public void storeFile(MultipartFile file, String url, String hashName) {
        try {
        	// Init Check Folder Images for the first time
//        	Path imageFolderLocation = Paths.get("images");
//        	if(!Files.exists(imageFolderLocation)) {
//        		this.initImageFolder(imageFolderLocation);
//        	}
        	
        	Path folderLocation = Paths.get(rootLocationFiles + url);
        	System.out.println(folderLocation.toString());
        	if(Files.exists(folderLocation)) {
        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
        	}else {
        		this.init(folderLocation);
        		Files.copy(file.getInputStream(), folderLocation.resolve(hashName));
        	}
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
 
    public Resource loadFileImage(String folder, String filename) {
        try {
            Path file = rootLocationImage.resolve(folder +"/"+ filename);
            System.out.println(file.toUri());
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
    
    public Resource loadFile(String folder, String filename) {
        try {
            Path file = rootLocationFiles.resolve(folder+ "/" + filename);
            System.out.println(file);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
 
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocationImage.toFile());
    }
 
    public void init(Path uri) {
        try {
        	Files.createDirectory(uri);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
    
    public void initImageFolder(Path uri) {
    	try {
        	Files.createDirectory(uri);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
    
}
