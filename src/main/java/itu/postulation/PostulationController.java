package itu.postulation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostulationController {

    @GetMapping("/postulation/{idTravail}")
    public String getMethodName(@PathVariable("idTravail") String idTravail) {
        return new String();
    }

}
