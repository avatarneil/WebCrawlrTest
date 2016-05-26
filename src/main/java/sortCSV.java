/**
 * Created by neil on 5/12/16.
 */
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import java.io.Reader;
import java.io.FileReader;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;



public class sortCSV {
    public static void parseCSV(ArrayList<String> fileLocation) throws IOException {
        try {

            final FileWriter sw = new FileWriter(fileLocation.get(0));
            final CSVPrinter printer = new CSVPrinter(sw, CSVFormat.INFORMIX_UNLOAD);
            Reader in = new FileReader(fileLocation.get(0));
            CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
            //System.out.println(parser.getHeaderMap().size());
            List<CSVRecord> list = parser.getRecords();
            System.out.println(list.get(1).size());
            int i=0;
            for (CSVRecord record : list) {
                printer.printRecord(list.get(i));
                i++;
            }
            i=0;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void parseCSVs(ArrayList<String> fileLocations) throws IOException{
        try {
            int j=0;
            while (j<=fileLocations.size()) {
                final FileWriter sw = new FileWriter(fileLocations.get(j));
                final CSVPrinter printer = new CSVPrinter(sw, CSVFormat.INFORMIX_UNLOAD);
                Reader in = new FileReader(fileLocations.get(j)); //NEED TO MAKE WORK WITH MULTIPLE FILES
                CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
                //System.out.println(parser.getHeaderMap().size());
                List<CSVRecord> list = parser.getRecords();
                System.out.println(list.get(1).size());
                int i = 0;
                for (CSVRecord record : list) {
                    printer.printRecord(list.get(i));
                    i++;
                }
                i = 0;
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

