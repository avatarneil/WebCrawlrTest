/**
 * Created by neil on 5/23/16.
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

public class htmlTableParse {
    public static void parseTableOnSite(String fileName) {
        String html = fileName;
        ArrayList<ArrayList<String>> rowStrings = new ArrayList();
        try {
            Document doc = Jsoup.connect(html).get();
            Elements tableElements = doc.select("table");

            Elements tableHeaderEles = tableElements.select("thead tr th");
            System.out.println("headers");
            ArrayList<String> headers = new ArrayList();
            for (int i = 0; i < tableHeaderEles.size(); i++) {
                headers.add(tableHeaderEles.get(i).text());
            }
            System.out.println();

            Elements tableRowElements = tableElements.select(":not(thead) tr");

            for (int i = 0; i < tableRowElements.size(); i++) {
                ArrayList<String> currentList = new ArrayList();
                Element row = tableRowElements.get(i);
                Elements rowItems = row.select("td");
                for (int j = 0; j < rowItems.size(); j++) {
                    currentList.add(rowItems.get(j).text());
                }
                System.out.println(rowStrings);
                rowStrings.add(currentList);
            }
            final FileWriter sw = new FileWriter("myfile.csv");
            final CSVPrinter printer = new CSVPrinter(sw, CSVFormat.EXCEL.withRecordSeparator('\n'));
            printer.printRecord(headers);
            printer.printRecords(rowStrings);
            printer.close();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
