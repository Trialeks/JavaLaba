import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;


public class pr11_2 {
    public static void parsHTML() {
        try {
            Document html = Jsoup.connect("https://www.mirea.ru").get();
            //System.out.println(html.toString());

            Elements elements = html.getElementsByTag("img");
            File fale= new File("C:\\Users\\Admin\\IdeaProjects\\practice11_2\\images");
            if(!fale.isDirectory())
            {
                boolean created = fale.mkdir();
            }

            for (Element element : elements) {

                String str = element.attr("abs:src");
                    if ((str.contains(".png") || str.contains(".jpeg") || str.contains(".jpg")))
                    {
                    String nameim = str.substring(str.lastIndexOf("/") + 1);
                    System.out.println(nameim);
                    try {
                        URL url = new URL(str);
                        InputStream in = new BufferedInputStream(url.openStream());
                        ByteArrayOutputStream bit = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while ((n = in.read(buf)) != -1) {
                            bit.write(buf, 0, n);
                        }
                        bit.close();
                        in.close();
                        byte[] response = bit.toByteArray();

                        FileOutputStream file = new FileOutputStream("C:\\Users\\Admin\\IdeaProjects\\practice11_2\\images\\" + nameim);
                        file.write(response);

                        file.close();

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());

                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
            {
                parsHTML();
            }
 }
