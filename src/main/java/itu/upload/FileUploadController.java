package itu.upload;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileUploadController {
    private static String UPLOAD_DIR = "src\\main\\webapp\\public\\img\\uploaded";
    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.lastIndexOf(".") == -1) {
            return ""; // Retourne une chaîne vide si le nom de fichier est null ou ne contient pas de point
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file ,HttpSession session) {
        try {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

            // Ensure the directory exists
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Get the file and save it
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + File.separator + utilisateur.getId()+".jpg");
            Files.write(path, bytes);

            return "Image uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Image upload failed!";
        }
    }
}
