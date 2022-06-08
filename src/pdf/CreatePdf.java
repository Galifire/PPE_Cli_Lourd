package pdf;

import java.io.IOException;
import entities.Commandes;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.fontbox.type1.*;

public class CreatePdf {

    public static void create(Commandes commandes) throws IOException {
        PDDocument pdfdoc= new PDDocument();
        PDPage page = new PDPage();

        pdfdoc.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(pdfdoc, page);
        PDFont font = new PDType1Font("Helvetica");

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.showText(commandes.getCdeNum().toString());
        contentStream.newLine();
        contentStream.showText(commandes.getMedicNum().toString());
        contentStream.newLine();
        contentStream.showText(commandes.getCliNum().toString());
        contentStream.newLine();
        contentStream.showText(commandes.getDateCde());
        contentStream.newLine();
        contentStream.showText(commandes.getQte().toString());
        contentStream.endText();
        contentStream.close();

        pdfdoc.save("C:\\Users\\rapha\\OneDrive\\Documents\\Cde_"+ commandes.getCdeNum().toString() +".pdf");
        pdfdoc.close();
        System.out.println("PDF created");

    }
}  