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
    private static String UPLOAD_DIR_PROFIL= "src\\main\\webapp\\public\\img\\uploaded";

    @PostMapping("/upload/profil")
    public String uploadProfil(@RequestParam("file") MultipartFile file ,HttpSession session) {
        try {
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

            // Ensure the directory exists
            File directory = new File(UPLOAD_DIR_PROFIL);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Get the file and save it
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_PROFIL + File.separator + utilisateur.getId()+".jpg");
            Files.write(path, bytes);

            return "Image uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Image upload failed!";
        }
    }
    @PostMapping("/upload/poste/{posteId}")
    public String uploadPoste(@RequestParam("file") MultipartFile file, @PathVariable("posteId") Long posteId) {
        try {    
            // Ensure the directory exists
            File directory = new File(UPLOAD_DIR_PROFIL);
            if (!directory.exists()) {
                directory.mkdirs();
            }
    
            // Get the file and save it
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR_PROFIL + File.separator + "p_" + posteId+ ".jpg");
            Files.write(path, bytes);
    
            return "Image uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Image upload failed!";
        }
    }
    
}
