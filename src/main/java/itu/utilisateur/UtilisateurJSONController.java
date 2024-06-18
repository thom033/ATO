package itu.utilisateur;

import org.springframework.web.bind.annotation.RestController;

import itu.contact.Contact;
import itu.contact.ContactRepository;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UtilisateurJSONController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/utilisateur/parametre/modify")
    public HashMap<String,Object> parametreGlobal(HttpSession session) {
        HashMap<String,Object> hashMap=new HashMap<String,Object>();
        //Utilisateur utilisateur=utilisateurRepository.findById(idUtilisateur).get();
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        hashMap.put("utilisateur",utilisateur);
        return hashMap;
    }

    @GetMapping("/utilisateur/connected")
    public Utilisateur liste(HttpSession session) {
        Utilisateur utilisateur=(Utilisateur)session.getAttribute("utilisateur");
        return utilisateur;
    }

    @PostMapping("/utilisateur/update")
    public String update(@RequestBody Utilisateur utilisateur,HttpSession session) {
        this.utilisateurRepository.save(utilisateur);
        session.setAttribute("utilisateur", utilisateur);
        return "updated";
    }

    @PostMapping("/utilisateur/contact/update")
    public String updateContact(@RequestBody Utilisateur utilisateur,HttpSession session) {
        Set<Contact> contacts=utilisateur.getContacts();
        Set<Contact> newContacts=new HashSet<Contact>();
        for (Contact contact : contacts) {
            List<Contact> contacts2=contactRepository.getContact(contact.getNumTelephone());
            if(contacts2.size()==0){
                contactRepository.save(contact);
            }
            contact=contactRepository.getContact(contact.getNumTelephone()).get(0);
            newContacts.add(contact);
        }
        utilisateur.setContacts(newContacts);
        this.utilisateurRepository.save(utilisateur);
        session.setAttribute("utilisateur", utilisateur);
        return "updated";
    }
    
}
