
/*package main.java; /**
 * Created by neil on 5/4/16.
 */
import java.io.IOException;
        import java.util.ArrayList;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;
//import org.w3c.dom.Element;
        import java.util.regex.Pattern;
        import java.util.regex.Matcher;
        import java.io.FileOutputStream;
        import java.nio.channels.*;
        import java.net.URL;
        import org.apache.commons.io.FilenameUtils;
public class crawltest {
    static ArrayList<String> csvlinks = new ArrayList();
    static ArrayList<String> csvfiles = new ArrayList();
    static String website ="https://support.spatialkey.com/spatialkey-sample-csv-data";
    static URL foundcvsfilelinks;

    static Pattern r = Pattern.compile("(.*)\\.csv$",Pattern.CASE_INSENSITIVE);

    //Re-add line above and edit line further down in order to restore "pattern" functions
    public static void main(String[] args) {
        try {
            // fetch the document over HTTP
            Document doc = Jsoup.connect(website).get();

            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);

            // get all links in page
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                // get the value from the href attribute
                Matcher m = r.matcher(link.attr("href"));
                if(m.find()) {
                    csvlinks.add(link.attr("href"));
                }


                for(String csvlink : csvlinks){
                    // this get the url path ei the /blah/blah/bla.whatever

                    foundcvsfilelinks= new URL(csvlink);
                    String foundcvsfilepath=foundcvsfilelinks.getPath();
                    String basename = FilenameUtils.getBaseName(foundcvsfilepath);
                    String extension = FilenameUtils.getExtension(foundcvsfilepath);
                    //downloades the file to the computer this only get 16mbs
                    ReadableByteChannel rbc = Channels.newChannel(foundcvsfilelinks.openStream());
                    FileOutputStream fos = new FileOutputStream(basename+extension);
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                    // saves the file name for the next part of the program to use
                    csvfiles.add(basename+extension);

                }

                //System.out.println("\nlink: " + link.attr("href"));
                //System.out.println("text: " + link.text());
            }




            System.out.println(csvfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


