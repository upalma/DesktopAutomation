package pdfFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTXTFile {
    public static void main(String[] args) {
        try {
            //String filePath = "C:\\Users\\upalma\\Documents\\PDFVerify\\FileForReading\\Result1.TXT";
            FileWriter fileWriter = new FileWriter("Result1.TXT");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("controlNo: 40 credits");
            printWriter.println("DataNo: 30 credits");
            printWriter.println("OutputNo: 30 credits");

            printWriter.close();
        }catch (IOException e){
            System.out.println("Error!");
        }
    }
}
