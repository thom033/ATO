package itu.entretien;

import java.io.FileNotFoundException;
import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.io.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import itu.entreprise.Entreprise;
import itu.entreprise.EntrepriseController;
import itu.entreprise.EntrepriseRepository;
import itu.notification.Notification;
import itu.notification.NotificationRepository;
import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class EntretienController {
    @Autowired
    EntretienRepository entretienRepository;

    @Autowired
    PdfService pdfService;

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    EntrepriseRepository entrepriseRepository;

    @GetMapping("/admin/entretien/liste")
    public ModelAndView listerEntretien() {
        ModelAndView mv = new ModelAndView("admin/template");
        mv.addObject("page", "entretien/entretienEnCours.jsp");

        return mv;
    }

    @GetMapping("/admin/entretien/delete/{idEntretien}")
    public String supprimer(@PathVariable("idEntretien") String idEntretien) {
        Entretien entretien = entretienRepository.findById(Long.valueOf(idEntretien)).get();
        entretien.setReussite(false);
        entretienRepository.save(entretien);

        Notification notification = new Notification();
        notification.setEntretien(entretien);
        notification.setDateNotification(LocalDateTime.now());
        notification.setUtilisateur(entretien.getUtilisateur());
        notification.setMessage(
                "Votre candidature n'a pas été retenue après l'entretien du" + entretien.getDateEntretien());
        notification.setReussite(false);
        notificationRepository.save(notification);
        return "redirect:/admin/entretien/liste";
    }

    @GetMapping("/admin/entretien/valider/{idEntretien}")
    public String valider(@PathVariable("idEntretien") String idEntretien) {
        Entretien entretien = entretienRepository.findById(Long.valueOf(idEntretien)).get();
        entretien.setReussite(true);
        entretienRepository.save(entretien);

        Entreprise entreprise = entrepriseRepository.findById(entretien.getPoste().getPosteEntreprise()).get();
        entreprise.setPoint(entreprise.getPoint() + 2);
        entrepriseRepository.save(entreprise);

        Notification notification = new Notification();
        notification.setEntretien(entretien);
        notification.setDateNotification(LocalDateTime.now());
        notification.setUtilisateur(entretien.getUtilisateur());
        notification.setMessage(
                "Nous avons le plaisir de vous informer que vous avez ete sélectionné apres l'entretien du "
                        + entretien.getDateEntretien());
        notification.setReussite(true);
        notificationRepository.save(notification);
        return "redirect:/admin/entretien/liste";
    }

    @GetMapping("/generer-pdf/{idEntretien}")
    public void generatePdf(HttpServletResponse response, @PathVariable("idEntretien") String idEntretien)
            throws IOException, java.io.IOException {
        // Create a ByteArrayOutputStream to hold the PDF data
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Initialize PDF writer and document
        PdfWriter writer = new PdfWriter(baos);
        Long id = Long.valueOf(idEntretien);
        Entretien entretien = entretienRepository.getById(id);
        pdfService.generatePDF(writer, entretien);

        // Set response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=convocation.pdf");

        // Write PDF to response output stream
        response.getOutputStream().write(baos.toByteArray());
        response.getOutputStream().flush();
    }

    @GetMapping("/entretien/pdf")
    public ModelAndView notification(HttpSession session) {
        ModelAndView mv = new ModelAndView("template");
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur == null) {
            mv.setViewName("login/login-register");
        } else {

            try {
                // Create a PdfWriter
                String dest = "hello_world.pdf";
                PdfWriter writer = new PdfWriter(dest);

                // Create a PdfDocument
                PdfDocument pdf = new PdfDocument(writer);

                // Create a Document
                Document document = new Document(pdf);

                // Add a Paragraph
                Paragraph paragraph = new Paragraph("Hello, World!")
                        .setTextAlignment(TextAlignment.CENTER);

                document.add(paragraph);

                // Close the Document
                document.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            mv.setViewName("template");
            mv.addObject("page", "notification/notification");
        }
        return mv;
    }
}
