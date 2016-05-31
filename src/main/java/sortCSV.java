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
    public static void parseCSV(ArrayList<String> fileLocations) throws IOException {
        try {
            if (fileLocations.size() >= 1) {
                int j = 0;
                if (j <= fileLocations.size()) {
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
                } else {
                    System.out.println("No CSV files to convert.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


