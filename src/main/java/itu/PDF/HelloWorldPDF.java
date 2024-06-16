package itu.PDF;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;

public class HelloWorldPDF {
    public static void main(String[] args) {
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

            System.out.println("PDF created successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
