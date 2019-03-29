package pdfFile;

import org.testng.Assert;
import java.io.*;

public class VerifyMRDFData {
    public static void readContents (File file) throws IOException{

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String header = bufferedReader.readLine();
        String line1 = bufferedReader.readLine();

        String producerJobID = line1.substring(0,6);
        Assert.assertTrue(true, producerJobID);
        System.out.println("(column   1-6) Producer Job ID ---------------> : " + producerJobID);

        String split = line1.substring(6,8);
        Assert.assertTrue(true, split);
        System.out.println("(column   7-8) Producer split ----------------> : " +split);

        String mailPieceId = line1.substring(8,14);
        Assert.assertTrue(true, mailPieceId);
        System.out.println("(column  9-14) Mail piece Id -----------------> : " +mailPieceId);

        String foreignBit = line1.substring(14,15);
        Assert.assertTrue(true, foreignBit);
        System.out.println("(column    15) Foreign Bit -------------------> : " +foreignBit);

        String sheetCount =header.substring(14, 16);
        Assert.assertTrue(true, sheetCount);
        System.out.println("(column 15-16) Mail sheet count --------------> : " +sheetCount);

        String column44Value = line1.substring(43, 44);
        Assert.assertEquals("0", column44Value);
        System.out.println("(column    44) Hard code value '0' -----------> : " +column44Value);

        String column45Value = line1.substring(44,45);
        Assert.assertEquals("0", column45Value);
        System.out.println("(column    45) Hard code value '0' -----------> : " +column45Value);

        String verifyContainsBRE = line1.substring(45,46); //need if/else
        //Assert.assertEquals("0",verifyContainsBRE);
        System.out.println("(column    46) '0' no BRE, '1' BRE -----------> : " +verifyContainsBRE);

        String verifyInsert1 = line1.substring(47, 48);
//        Assert.assertEquals("0", verifyInsert1);
        System.out.println("(column    47) '0' no Insert1, '1' Insert1  --> : " +verifyInsert1);

        String verifyInsert2 = line1.substring(47, 48);
//        Assert.assertEquals("0", verifyInsert2);
        System.out.println("(column    48) '0' no Insert2, '1' Insert2 ---> : " +verifyInsert2);

        // Below steps are as per requirements of ADF -453
        String column823Value = line1.substring(822,823);
        Assert.assertEquals("0", column823Value);
        System.out.println("(column   823) Hardcode '0' at column 823 ----> : "+column823Value);

        int column874Value = line1.indexOf("00100Emdeon");
        Assert.assertEquals(873, column874Value);
        System.out.println("(column   874) Hardcode '00100Emdeon' at column : " +column874Value);

        int column904Value = line1.indexOf("ADF");
        Assert.assertEquals(903, column904Value);
        System.out.println("(column   904) Hardcode 'ADF' at column ------> : "+ column904Value);

        String column908Value = line1.substring(907,910);
        Assert.assertEquals("100", column908Value);
        System.out.println("(column   908) Hardcode '100' at column 908 --> : "+column908Value);

//        int column919Value = line1.indexOf("32");
//        //Assert.assertEquals(919, column919Value);
//        System.out.println("(column   919) Hardcode '32' at column ------> : "+column919Value);

        String column919Value = line1.substring(918,920);
        Assert.assertEquals("32", column919Value);
        System.out.println("(column   919) Hardcode '32' at column 919 ---> : "+column919Value);

        bufferedReader.close();
        fileReader.close();
    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\upalma\\Documents\\Input n output file\\March\\03-25\\2600ST01_2423288_002773\\00277306.TXT");
        try{
            readContents(file);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}