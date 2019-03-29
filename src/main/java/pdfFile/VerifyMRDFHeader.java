package pdfFile;

import org.testng.Assert;
import java.io.*;

public class VerifyMRDFHeader {
    public static void readContents (File file) throws IOException {

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String header = bufferedReader.readLine();
        String line1 = bufferedReader.readLine();

        //Verify Header
        String producerJobID = header.substring(0,6);
        Assert.assertTrue(true, producerJobID);
        System.out.println("(column     1-6) Producer Job ID ---------------------------> : " + producerJobID);

        String split = header.substring(6,8);
        Assert.assertTrue(true, split);
        System.out.println("(column     7-8) Producer split ----------------------------> : " +split);

        String sheetCount =header.substring(14, 16);
        Assert.assertTrue(true, sheetCount);
        System.out.println("(column   15-16) Mail sheet count --------------------------> : " +sheetCount);

        String reservedFeeder = header.substring(287,288); //need if/else
        Assert.assertEquals("1",reservedFeeder);
        System.out.println("(column     288) '1' Reserved ES09 envelop -----------------> : " +reservedFeeder);

        String verifyContainsBRE = header.substring(288,289); //need if/else
        //Assert.assertEquals("1",verifyContainsBRE);
        System.out.println("(column     289) '1' no BRE, '2' BRE -----------------------> : " +verifyContainsBRE);

        String verifyInsert1 = header.substring(289,290);
        //Assert.assertEquals("1", verifyInsert1);
        System.out.println("(column     290) '1' no Insert1, '2' Insert1 ---------------> : " +verifyInsert1);

        String verifyInsert2 = header.substring(290, 291);
        //Assert.assertEquals("1", verifyInsert2);
        System.out.println("(column     291) '1' no Insert2, '2' Insert2 ---------------> : " +verifyInsert2);

        String verify292ColumnValue = header.substring(291, 292);
        Assert.assertEquals("1", verify292ColumnValue);
        System.out.println("(column     292) Hardcode '1' at column 292 ----------------> : " +verify292ColumnValue);

        String outGoingEnv = header.substring(302, 310); //need if/else
       //Assert.assertEquals("ST03 ", outGoingEnv);
        System.out.println("(column 303-307) Out going envelop value -------------------> : " +outGoingEnv);

        String justifyBreValue = header.substring(326, 334);
        //Assert.assertEquals("        ", justifyBreValue);
        System.out.println("(column 326-334) BRE value ---------------------------------> : " +justifyBreValue);

        String justifyInsert1Value = header.substring(334, 342);
        //Assert.assertEquals("       ", justifyInsert1Value);
        System.out.println("(column 335-342) Insert1 value -----------------------------> : " +justifyInsert1Value);

        String justifyInsert2Value = header.substring(342, 350);
        //Assert.assertEquals("       ", justifyInsert2Value);
        System.out.println("(column 343-350) Insert2 value -----------------------------> : " +justifyInsert2Value);

        String justifyCameraPosition = header.substring(446, 449);
        Assert.assertEquals("TOP", justifyCameraPosition);
        System.out.println("(column 447-449) Camera position value ---------------------> : " +justifyCameraPosition);

        String justifyPrinterOutPut = header.substring(468, 476);
        //Assert.assertEquals("TOP", j);
        System.out.println("(column 469-476) RollFed/IJET, Cutsheet/SmallColorPrinter --> : " +justifyPrinterOutPut);

        bufferedReader.close();
        fileReader.close();

    }
    public static void main(String[] args) {
        File file = new File("C:\\Users\\upalma\\Documents\\Input n output file\\March\\03-25\\2600ST01_2423288_002773\\00277304.TXT");
                try{
            readContents(file);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}