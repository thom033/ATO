package itu.PDF;

import java.util.ArrayList;
import java.util.List;

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

import itu.PDF.PDFGenerator;

public class App {
    public static void main(String[] args) {
        String dest = "example.pdf";

        try {
            // Initialize PDF writer
            PdfWriter writer = new PdfWriter(dest);

            // Initialize PDF document
            PdfDocument pdf = new PdfDocument(writer);

            // Initialize document
            Document document = new Document(pdf);

            // Create a table with 2 columns
            Table tableHeader = new Table(new float[] { 1, 1 });
            tableHeader.setWidth(UnitValue.createPercentValue(100));

            // Add logo to the top right
            String logoPath = "images/logo.jpg"; // Path to the logo file
            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData);
            logo.setHorizontalAlignment(HorizontalAlignment.LEFT);
            logo.setWidth(100); // Adjust the size as necessary
            Cell logoCell = new Cell().add(logo).setBorder(null);
            tableHeader.addCell(logoCell);

            // Add company name to the top left
            Paragraph anneeScolaire = new Paragraph("Année scolaire 2015-2016")
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontColor(ColorConstants.GRAY, 10)
                    .setItalic();
            Cell anneeScolaireCell = new Cell().add(anneeScolaire).setBorder(null);
            tableHeader.addCell(anneeScolaireCell);

            document.add(tableHeader);

            Paragraph title = new Paragraph("Releve de notes et resultats")
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontColor(ColorConstants.BLUE);
            document.add(title);

            Table tableDescription = new Table(new float[] { 1, 1 });
            tableDescription.setWidth(UnitValue.createPercentValue(100));
            Cell cellConstants = new Cell().add(new Paragraph("Nom:")).setBorder(null);
            tableDescription.addCell(cellConstants);
            Cell cellVariable = new Cell().add(new Paragraph("RABENARIVO")).setBorder(null);
            tableDescription.addCell(cellVariable);
            cellConstants = new Cell().add(new Paragraph("Prenom:")).setBorder(null);
            cellVariable = new Cell().add(new Paragraph("Ryan Lizka")).setBorder(null);
            tableDescription.addCell(cellConstants);
            tableDescription.addCell(cellVariable);
            cellConstants = new Cell().add(new Paragraph("Ne le:")).setBorder(null);
            cellVariable = new Cell().add(new Paragraph("12/08/2004")).setBorder(null);
            tableDescription.addCell(cellConstants);
            tableDescription.addCell(cellVariable);
            document.add(tableDescription);

            // Add space between header and table
            document.add(new Paragraph("\n\n"));

            List<String[]> data = new ArrayList<String[]>();

            // Add table rows
            for (int i = 0; i < 4; i++) {
                data.add(new String[] { "data" + i, "data" + (i + 2), "data" + (i + 3) });
            }

            Table table = PDFGenerator.makeTable(data);

            // Add table to the document
            document.add(table);

            // Add space between table and footer
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n"));

            // Add director's signature at the bottom right
            Paragraph directorSignature = new Paragraph("MR le directeur")
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(directorSignature);

            // Close document
            document.close();

            System.out.println("PDF Created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
