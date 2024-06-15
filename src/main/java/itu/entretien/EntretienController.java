package itu.entretien;

import java.io.FileNotFoundException;
import java.net.http.HttpHeaders;
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

import itu.utilisateur.Utilisateur;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class EntretienController {
    @Autowired
    EntretienRepository entretienRepository;

    @Autowired
    PdfService pdfService;

    @GetMapping("/generate-pdf/{idEntretien}")
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
        response.setHeader("Content-Disposition", "inline; filename=generated.pdf");

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
