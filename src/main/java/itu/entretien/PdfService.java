package itu.entretien;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import itu.utilisateur.Utilisateur;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfService {

        public void generatePDF(PdfWriter writer, Entretien entretien) throws MalformedURLException {
                PdfDocument pdf = new PdfDocument(writer);

                // Initialize document
                Document document = new Document(pdf);

                // Create a table with 2 columns
                Table tableHeader = new Table(new float[] { 1, 1 });
                tableHeader.setWidth(UnitValue.createPercentValue(100));

                // Add logo to the top right
                String logoPath = "src/main/webapp/public/img/logoTransparent2.png"; // Path to the logo file
                ImageData imageData = ImageDataFactory.create(logoPath);
                Image logo = new Image(imageData);
                logo.setHorizontalAlignment(HorizontalAlignment.LEFT);
                logo.setWidth(100); // Adjust the size as necessary
                Cell logoCell = new Cell().add(logo).setBorder(null);
                tableHeader.addCell(logoCell);

                // Add company name to the top left
                Paragraph nomEntreprise = new Paragraph("Entreprise Rohy\nAgence de recrutement")
                                .setFontSize(10)
                                .setTextAlignment(TextAlignment.RIGHT);

                Cell anneeScolaireCell = new Cell().add(nomEntreprise).setBorder(null);
                tableHeader.addCell(anneeScolaireCell);

                document.add(tableHeader);

                Paragraph title = new Paragraph("Convocation")
                                .setFontSize(24)
                                .setTextAlignment(TextAlignment.CENTER)
                                .setBold()
                                .setFontColor(ColorConstants.BLACK);
                document.add(title);

                document.add(new Paragraph("\n\n"));

                Paragraph introduction = new Paragraph("Entreprise Rohy\r\n" + //
                                "Fait à Antananarivo le "
                                + entretien.getDateEnvoi().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\r\n" + //
                                "\r\n" + //
                                "Madame / Monsieur " + entretien.getUtilisateur().getNom() + ",\r\n" + //
                                "\r\n" + //
                                "Suite à votre candidature pour le poste de " + entretien.getPoste().getPosteTitre()
                                + " au sein l'entreprise " + entretien.getPoste().getEntrepriseNom()
                                + ", nous \r\n"
                                + //
                                "avons le plaisir de vous informer que votre profil a retenu toute notre attention.\r\n"
                                + //
                                "\r\n" + //
                                "Nous souhaiterions donc vous inviter à un entretien d'embauche afin de mieux vous connaître et d'échanger sur vos \r\n"
                                + //
                                "compétences et vos motivations.\r\n" + //
                                "\r\n" + //
                                "Date : "
                                + entretien.getDateEntretien().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                + "\r\n" + //
                                "Heure : " + entretien.getDateEntretien().toLocalTime() + "\r\n" + //
                                "Lieu : Adresse de l'entreprise Rohy\r\n" + //

                                "\r\n" + //
                                "Nous vous prions de bien vouloir nous confirmer votre présence à cet entretien en nous contactant au numéro de téléphone de contact ci-dessus.\r\n"
                                + //
                                "De plus, nous vous demandons d'apporter les documents de votre CV lors de cet entretien.\r\n"
                                + //
                                "\r\n" + //
                                "Dans l'attente de votre confirmation, nous restons à votre disposition pour toute information complémentaire.\r\n"
                                + //
                                "").setFontSize(10);

                document.add(introduction);

                // Add space between header and table
                document.add(new Paragraph("\n\n"));

                List<String[]> data = new ArrayList<String[]>();

                // Add space between table and footer

                // Add director's signature at the bottom right
                Paragraph directorSignature = new Paragraph("Agence Rohy")
                                .setTextAlignment(TextAlignment.RIGHT);
                document.add(directorSignature);

                // Close document
                document.close();
        }
}
