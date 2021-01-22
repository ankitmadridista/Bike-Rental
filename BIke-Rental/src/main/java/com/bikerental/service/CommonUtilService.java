package com.bikerental.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonUtilService {
	@Autowired
	private ServletContext context;
	
	public String fetchImage(String fileName) {
		System.out.println(fileName);
		System.out.println(context.getRealPath("/"));
		String filePath = context.getRealPath("/images");
		System.out.println(filePath);
		String fileNamee = null;
		File fileFolder = new File(filePath);
		System.out.println(fileFolder);
		if(fileFolder!=null) {
			for(final File file : fileFolder.listFiles()) {
				if(!file.isDirectory() && file.getName().equals(fileName)) {
					String encodebase64 = null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						System.out.println(extension);
						FileInputStream input = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						input.read(bytes);
						encodebase64 = Base64.getEncoder().encodeToString(bytes);
						fileNamee = "data:image/" + extension + ";base64," + encodebase64;
						System.out.println("filenamee: " + fileNamee);
						input.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						
					}
				}
			}
		}
		System.out.println(fileNamee);
		return fileNamee;
	}
	
	public String saveImage(MultipartFile image){
		boolean isExists = new File(context.getRealPath("/images/")).exists();
		if(!isExists) {
			new File(context.getRealPath("/images/")).mkdir();
			System.out.println("context: " + context.getRealPath("/images/"));
		}
		
		String fileName = image.getOriginalFilename();
		String modifiedFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);
		File serverFile = new  File(context.getRealPath("/images/" + File.separator + modifiedFileName));
		System.out.println( fileName + " " + modifiedFileName + " "  + serverFile );
		try {
			FileUtils.writeByteArrayToFile(serverFile, image.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
		return modifiedFileName;
		
	}
}