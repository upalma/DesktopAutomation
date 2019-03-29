package pdfFile;

import de.redsix.pdfcompare.PdfComparator;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class VerifyData {
    public static void main(String[] args)throws IOException {
    File file = new File("C:\\Users\\upalma\\Documents\\PDFVerify\\DataFile\\FLOWFLAT_CTOP_TOL_002086-02.pdf");
    FileInputStream fileInputStream = new FileInputStream(file);

        PDFParser parser = new PDFParser(fileInputStream);
        parser.parse();
        COSDocument cosDocument = parser.getDocument();
        PDDocument pdDocument = new PDDocument(cosDocument);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String data = pdfTextStripper.getText(pdDocument);
        System.out.println(data);

        Assert.assertTrue(data.contains("Toledo"));
        cosDocument.close();
        pdDocument.close();

//        String fileName = "APS_CTOP_TOL_00";
//        Assert.assertEquals("APS_CTOP_TOL_00", fileName);
        System.out.println("Text found");
    }
}
