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

public class crawltest {
    static ArrayList<String> csvlinks = new ArrayList();
    static ArrayList<Document> csvfiles = new ArrayList();
    Pattern r = Pattern.compile(pattern);
    public static void main(String[] args) {
        try {
            // fetch the document over HTTP
            Document doc = Jsoup.connect("https://offshoreleaks.icij.org/pages/database").get();

            // get the page title
            String title = doc.title();
            System.out.println("title: " + title);

            // get all links in page
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                // get the value from the href attribute

                if(link.attr("href").r.matches("?i:(.*)csv(.*)")){
                    csvlinks.add(link.attr("href"));
                }


                for(String csvlink : csvlinks){

                 csvfiles.add(Jsoup.connect(csvlink).get());

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



