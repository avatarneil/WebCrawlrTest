/*package main.java; /**
 * Created by neil on 5/4/16.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class crawltest {
    static ArrayList<String> a = new ArrayList();
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
                a.add("\nlink: " + link.attr("href"));
                //System.out.println("\nlink: " + link.attr("href"));
                //System.out.println("text: " + link.text());
            }
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

