//import org.testng.util.Strings;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class MRDFColumns {
//    String ProducerJobId;
//    String ProducerSplit;
//    String TotalMailSheets;
//    String ReserveFeader;
//    String BRE;
//    String Insert1;
//    String Insert2;
//    String OutGoingEnvelop;
//    String BREValue;
//    String Insert1Value;
//    String Insert2Value;
//    String CameraPositionValue;
//    String PrinterStatus;
//
//}
//public class MRDFDataValidator {
//    public class MRDFColumnDataInfo {
//        String ProJobId;
//        String ProducerSplit;
//        String TotalMailSheets;
//        String ReserveFeader;
//        String BRE;
//        String Insert1;
//        String Insert2;
//        String OutGoingEnvelop;
//        String BREValue;
//        String Insert1Value;
//        String Insert2Value;
//        String CameraPositionValue;
//        String PrinterStatus;
//    }
//
//    /**
//     * Get Metadata Information and Files.
//  //   * @param path
//     * @return
//     * @throws IOException
//     */
//    public List<MRDFColumns> getMRDFDataInput(String filePath) throws IOException {
//        List<MRDFColumns> mrdfDataObject = new ArrayList<MRDFColumns>();
//        File file = new File(filePath);
//        Scanner scan = new Scanner(file);
//        while (scan.hasNext()) {
//            // Create a MRDFColumnData Object with all expected attributes.
//            String csv = scan.nextLine().replace(",", " ").replace("|", ",");
//            String Items[] = csv.split(",");
//            if (Items.length > 6) {
//                // map Metadata rows into MetadataColumns Object.
//                MRDFColumns mrdf = new MRDFColumns();
//                mrdf.ProducerJobId = Items[0];
//                mrdf.ProducerSplit = Items[1];
//                mrdf.TotalMailSheets = Items[2];
//                mrdf.ReserveFeader = Items[2];
//                mrdf.BRE = Items[4];
//                mrdf.Insert1 = Items[5];
//                mrdf.Insert2 = Items[6];
//                mrdf.OutGoingEnvelop = Items[7];
//                mrdf.BREValue = Items[8];
//                mrdf.Insert1Value = Items[9];
//                mrdf.Insert2Value = Items[10];
//                mrdf.CameraPositionValue = Items[11];
//                mrdf.PrinterStatus = Items[12];
//
//               mrdfDataObject.add(mrdf);
//            }
//        }
//        scan.close();
//        return mrdfDataObject;
//    }
//
//    /**
//     * Get Metadata Information list for different files contained on Metadata.
//     * @return List<MetaDataInfo>
//     * @throws IOException
//     */
//    public List<MRDFColumnDataInfo> getMRDFdata(String filePath) throws IOException {
//
//        List<MRDFColumns> mrdfData = this.getMRDFDataInput(filePath);
//        List<List<MRDFColumns>> files = getFileName(mrdfData);
//
//        List<MRDFColumnDataInfo> FileDataList = new ArrayList<MRDFColumnDataInfo>();
//        for (int index = 0; index < files.size(); index++) {
//            MRDFColumnDataInfo expectedData = new MRDFColumnDataInfo();
//
//            expectedData.ProJobId = String.valueOf(getPageCount(files.get(index)));
//
//            expectedData.ProducerSplit = getCheckAmount(files.get(index));
//            expectedData.TotalMailSheets = String.valueOf(getCheckCount(files.get(index)));
//
//            expectedData.ReserveFeader = getFeeder3(files.get(index));
//            expectedData.BRE = getFeeder3Total(files.get(index));
//
//            expectedData.Insert1 = getFeeder4(files.get(index));
//            expectedData.Insert2 = getFeeder4Total(files.get(index));
//
//            expectedData.OutGoingEnvelop = getFeeder5(files.get(index));
//            expectedData.BREValue = getFeeder5Total(files.get(index));
//
//            expectedData.Insert1Value = String.valueOf(getMailPieces(files.get(index)));
//            expectedData.Insert2Value = String.valueOf(getMailPieces(files.get(index)));
//
//            expectedData.CameraPositionValue = String.valueOf(getMailPieces(files.get(index)));
//            expectedData.PrinterStatus = String.valueOf(getMailPieces(files.get(index)));
//            FileDataList.add(expectedData);
//        }
//        return FileDataList;
//    }
//
//    /**
//     * Get Page count from Metadata
//     * @param metadataInfo
//     * @return
//     */
//    public int getPageCount(List<MRDFColumns> metadataInfo) {
//        int someSheetCount = 0;
//        for (MRDFColumns data : metadataInfo) {
//            someSheetCount += Integer.parseInt(data.ProducerJobId);
//        }
//        return someSheetCount;
//    }
//
//    /**
//     * Get check count from Metadata file
//     * @param metadataInfo
//     * @return Integer
//     */
//    public int getCheckCount(List<MRDFColumns> metadataInfo) {
//        int checkCount = 0;
//        for (MRDFColumns data : metadataInfo) {
//            int checkNumber = (!Strings.isNullOrEmpty(data.CheckNumber)) ? Integer
//                    .parseInt(data.CheckNumber) : 0;
//            checkCount += checkNumber;
//        }
//        return checkCount;
//    }
//
//    /**
//     * Get CheckAmout total from Metadata file.
//     * @param metadataInfo
//     * @return
//     */
//    public String getCheckAmount(List<MRDFColumns> metadataInfo) {
//        int checkAmount = 0;
//        for (MRDFColumns data : metadataInfo) {
//            double check = (!Strings.isNullOrEmpty(data.CheckAmount)) ? Float
//                    .parseFloat(data.CheckAmount) : 0;
//            checkAmount += check;
//        }
//        return (checkAmount == 0.0)?"0.00":String.valueOf(checkAmount);
//    }
//
//    /**
//     * Get feeder3 value from Metadata file.
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder3(List<MRDFColumns> metadataInfo) {
//        String feeder3 = "";
//        for (MRDFColumns data : metadataInfo) {
//            feeder3 = data.BRE;
//        }
//        return feeder3;
//    }
//
//    /**
//     * Get the Quantity some for Feeder3 from metadata file
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder3Total(List<MRDFColumns> metadataInfo) {
//        int feeder3Total = 0;
//        for (MRDFColumns data : metadataInfo) {
//            int feeder3 = (!Strings.isNullOrEmpty(data.BRE)) ? 1 : 0;
//            feeder3Total += feeder3;
//        }
//        return (feeder3Total == 0) ? "" : String.valueOf(feeder3Total);
//    }
//
//    /**
//     * Get feeder4 value from Metadata file.
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder4(List<MRDFColumns> metadataInfo) {
//        String feeder3 = "";
//        for (MRDFColumns data : metadataInfo) {
//            feeder3 = data.INSERT1;
//        }
//        return feeder3;
//    }
//
//    /**
//     * Get the Quantity some for Feeder4 from Metadata file
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder4Total(List<MRDFColumns> metadataInfo) {
//        int feeder4Total = 0;
//        for (MRDFColumns data : metadataInfo) {
//            int feeder4 = (!Strings.isNullOrEmpty(data.INSERT1)) ? 1 : 0;
//            feeder4Total += feeder4;
//        }
//        return (feeder4Total == 0) ? "" : String.valueOf(feeder4Total);
//    }
//
//    /**
//     * Get feeder5 value from Metadata file.
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder5(List<MRDFColumns> metadataInfo) {
//        String feeder5 = "";
//        for (MRDFColumns data : metadataInfo) {
//            feeder5 = data.INSERT2;
//        }
//        return feeder5;
//    }
//
//    /**
//     * Get the Quantity some for Feeder5 from Metadata file
//     * @param metadataInfo
//     * @return
//     */
//    public String getFeeder5Total(List<MRDFColumns> mrdfInfo) {
//        int feeder5Total = 0;
//        for (MRDFColumns data : mrdfInfo) {
//            int feeder4 = (!Strings.isNullOrEmpty(data.INSERT2)) ? 1 : 0;
//            feeder5Total += feeder4;
//        }
//        return (feeder5Total == 0) ? "" : String.valueOf(feeder5Total);
//    }
//
//    /**
//     * Get mail pieces count from Metadata file.
//     * @param metadataInfo
//     * @return
//     */
//    public int getMailPieces(List<MRDFColumns> mrdfInfo) {
//        List<String> BarCodes = new ArrayList<String>();
//        for (MRDFColumns data : mrdfInfo) {
//            BarCodes.add(data.Barcode_subset);
//        }
//        List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(
//                BarCodes));
//
//        System.out.println(listWithoutDuplicates);
//        return listWithoutDuplicates.size();
//    }
//
//    /**
//     * Get number of files that will be generated from Metadata file
//     * @param metadataInfo
//     * @return
//     */
//    public List<List<MRDFColumns>> getFileName(
//            List<MRDFColumns> metadataInfo) {
//        List<List<MRDFColumns>> Files = new ArrayList<List<MRDFColumns>>();
//        Files.add(new ArrayList<MRDFColumns>());
//        Files.add(new ArrayList<MRDFColumns>());
//
//        for (int index = 0; index < metadataInfo.size(); index++) {
//            if (metadataInfo.get(index).FileName.contains("_M.ps")
//                    || metadataInfo.get(index).FileName.contains("_I.ps")
//                    || metadataInfo.get(index).FileName.contains("_F.ps")) {
//                Files.get(0).add(metadataInfo.get(index));
//            } else if (metadataInfo.get(index).FileName.contains("_9.ps")) {
//                Files.get(1).add(metadataInfo.get(index));
//            }
//        }
//        if(Files.get(0).size()==0){
//            Files.remove(0);
//        } else { if(Files.get(1).size()==0)
//            Files.remove(1);
//        }
//        return Files;
//    }
//}