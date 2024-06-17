package itu.PDF;

import java.util.List;

import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class PDFGenerator {
    public static Table makeTable(List<String[]> text) {
        float[] colonne = new float[text.get(0).length];
        for (int i = 0; i < text.get(0).length; i++) {
            colonne[i] = 1;
        }
        Table table = new Table(colonne).useAllAvailableWidth();
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < text.get(i).length; j++) {
                Cell cell = new Cell().add(new Paragraph(text.get(i)[j])).setBorder(null);
                table.addCell(cell);
            }
        }
        return table;
    }

    public static Table makeTable(List<IBlockElement> element, int column) {
        float[] colonne = new float[column];
        for (int i = 0; i < column; i++) {
            colonne[i] = 1;
        }
        Table table = new Table(colonne);
        table.setWidth(UnitValue.createPercentValue(100));
        for (int i = 0; i < element.size(); i++) {
            Cell celulle = new Cell().add(element.get(i));
            table.addCell(celulle);
        }
        return table;
    }
}
