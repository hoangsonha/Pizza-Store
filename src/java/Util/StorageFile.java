/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author ADMIN
 */
public class StorageFile {
    private final Path storageFolder = Paths.get("D:\\NetBeans\\Asssiment\\web\\image");

    public StorageFile() {
        try {
            Files.createDirectories(storageFolder);
        } catch (Exception e) {

        }
    }

    public String isImage(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf);
    }
    
    public String getImageName(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(0, lastIndexOf);
    }
    
    public String storeFile(File file) {

        try {
            // file size must be <= 5mb

            float fileSize = file.getFreeSpace() / 1_000_000.0f;

            

            // file can phai rename do neu upload 2 file anh cung ten se bi ghi de

            String fileExtension = isImage(file);
            String generatedFileName = getImageName(file);
            generatedFileName = generatedFileName + fileExtension;

            Path destinationFilePath = this.storageFolder.resolve(Paths.get(generatedFileName)).normalize().toAbsolutePath();

            if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
                throw new RuntimeException("Khong the luu tru file ben ngoai folder hien tai");
            }

            try (InputStream inputStream = new FileInputStream(file)){
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
                return generatedFileName;
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
    
    
    public boolean uploadFile(InputStream is, String path) {
        boolean test = false;
        
        try {
            byte[] byt = new byte[is.available()];
            is.read(byt);
            FileOutputStream fops = new FileOutputStream(path);
            fops.write(byt);
            fops.flush();
            fops.close();
            
            test = true;
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return test;
    }

    public Path getStorageFolder() {
        return storageFolder;
    }
    
    
}
