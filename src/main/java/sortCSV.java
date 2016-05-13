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


public class sortCSV {
    public static void main(String[] args) throws IOException {
        try {
            Reader in = new FileReader("data/GeoIPv6.csv");
            CSVParser parser = new CSVParser(in, CSVFormat.EXCEL);
            //System.out.println(parser.getHeaderMap().size());
            List<CSVRecord> list = parser.getRecords();
            System.out.println(list.size());
            for (CSVRecord record : list) {
                String lastName = record.get(0);
                //System.out.println(lastName + firstName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}