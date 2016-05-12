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


public class sortCSV {
    public static void makeArray() throws IOException{
        Reader in = new FileReader("data/GeoIPv6.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            String lastName = record.get("Last Name");
            String firstName = record.get("First Name");
            System.out.println(lastName + firstName);
        }
    }
}
