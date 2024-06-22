package itu.entreprise;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itu.contact.Contact;
import itu.contact.ContactRepository;
import jakarta.servlet.http.HttpSession;

@RestController
public class EntrepriseJSONController {
    @Autowired
    EntrepriseRepository entrepriseRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/entreprise/liste")
    public List<Entreprise> liste() {
        return entrepriseRepository.findAll();
    }

    @PostMapping("/entreprise/insert")
    public List<Entreprise> insert(@RequestBody Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return entrepriseRepository.findAll();
    }

    @GetMapping("/entreprise/delete")
    public List<Entreprise> delete(@RequestParam("idEntreprise") Long idEntreprise) {
        entrepriseRepository.deleteById(idEntreprise);
        return entrepriseRepository.findAll();
    }

    @GetMapping("/entreprise/information")
    public Entreprise getUtilisateur(@RequestParam("idEntreprise") Long idEntreprise) {
        return entrepriseRepository.findById(idEntreprise).get();
    }

    @GetMapping("/entreprise/choosed")
    public Entreprise getUtilisateur(HttpSession session) {
        return (Entreprise)session.getAttribute("entreprise");
    }
    
    @PostMapping("/entreprise/update")
    public List<Entreprise> modifier(@RequestBody Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
        return entrepriseRepository.findAll();
    }

    @PostMapping("/entreprise/contact/update")
    public String modifierContact(@RequestBody Entreprise entreprise) {
        Set<Contact> contacts=entreprise.getContacts();
        Set<Contact> newContacts=new HashSet<Contact>();
        for (Contact contact : contacts) {
            List<Contact> contacts2=contactRepository.getContact(contact.getNumTelephone());
            if(contacts2.size()==0){
                contactRepository.save(contact);
            }
            contact=contactRepository.getContact(contact.getNumTelephone()).get(0);
            newContacts.add(contact);
        }
        entreprise.setContacts(newContacts);
        this.entrepriseRepository.save(entreprise);
        entrepriseRepository.save(entreprise);
        return "updated";
    }
}
