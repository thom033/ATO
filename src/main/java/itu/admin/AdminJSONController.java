package itu.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AdminJSONController {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/admin/liste")
    public List<Admin> liste() {
        return adminRepository.findAll();
    }

    @PostMapping("/admin/insert")
    public List<Admin> insert(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return adminRepository.findAll();
    }

    @GetMapping("/admin/delete")
    public List<Admin> delete(@RequestParam("idAdmin") Long idAdmin) {
        adminRepository.deleteById(idAdmin);
        return adminRepository.findAll();
    }

    @GetMapping("/admin/information")
    public Admin getUtilisateur(@RequestParam("idAdmin") Long idAdmin) {
        return adminRepository.findById(idAdmin).get();
    }
    
    @PostMapping("/admin/update")
    public List<Admin> modifier(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return adminRepository.findAll();
    }

}
