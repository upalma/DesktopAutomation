package pdfFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadMRDFFile {
    public static void readLines (File file) throws IOException{
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        //int numberOfLine = 0;
        while((line = bufferedReader.readLine()) !=null){
            System.out.println(line);
            //numberOfLine++;
        }
        //System.out.println("Number of lines " + numberOfLine);
        bufferedReader.close();
        fileReader.close();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\upalma\\Documents\\Input n output file\\March\\03-25\\1080IRS1_2206997_002756\\00275601.TXT");
        try{
            readLines(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
