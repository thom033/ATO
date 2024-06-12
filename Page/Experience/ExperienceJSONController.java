package itu.experience;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
public class ExperienceJSONController {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    HttpSession httpSession;

    // Fetch all experiences
    @GetMapping("/experience/liste")
    public List<Experience> liste() {
        return experienceRepository.findAll();
    }

    // Insert a new experience
    @PostMapping("/experience/insert")
    public List<Experience> insert(@RequestBody Experience experience) {
        experienceRepository.save(experience);
        return experienceRepository.findAll();
    }

    // Delete an experience by id
    @GetMapping("/experience/delete")
    public List<Experience> delete(@RequestParam("idExperience") Long idExperience) {
        experienceRepository.deleteById(idExperience);
        return experienceRepository.findAll();
    }

    // Fetch a specific experience by id
    @GetMapping("/experience/information")
    public Experience getExperience(@RequestParam("idExperience") Long idExperience) {
        return experienceRepository.findById(idExperience).orElse(null);
    }

    // Update an existing experience
    @PostMapping("/experience/update")
    public List<Experience> update(@RequestBody Experience experience) {
        experienceRepository.save(experience);
        return experienceRepository.findAll();
    }
}
