package pdfFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Verify2DBarcode {
    public static void readContents (File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line1 = bufferedReader.readLine();

        String producerJobID = line1.substring(0,6);
        System.out.println("Producer Job ID         : " + producerJobID);

        String producerSplit = line1.substring(6,8);
        System.out.println("Producer split          : " + producerSplit);

        String HRI = line1.substring(8,14);
        System.out.println("HRI value               : " +HRI);

        String mailPieceId = line1.substring(14,18);
        System.out.println("Mail piece sheets       : " +mailPieceId);

        String foreignFlag = line1.substring(18,19);
        System.out.println("Foreign Flag            : " +foreignFlag);

        String noPerfRecipe =line1.substring(19,20);
        System.out.println("0/4/9=NoPerf/Perf/Check : "+noPerfRecipe);

        String PerfRecipe =line1.substring(20,21);
        System.out.println("0/4 = NoPerf/Perf       : "+PerfRecipe);

        String checks =line1.substring(21,22);
        System.out.println("4/9 = Perf/Check        : "+checks);

        bufferedReader.close();
        fileReader.close();
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\upalma\\Documents\\PDFVerify\\DataFile\\00234501.TXT");
        try{
            readContents(file);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}