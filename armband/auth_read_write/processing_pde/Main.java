
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by aa on 25/03/17.
 */
public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        BufferedReader br = null;
        String address = "/Users/Manav/Documents/codeforgood_part2/team-3/armband/auth_read_write/processing_pde/id.txt";
        String value = "";
        try {
            br = new BufferedReader(new FileReader(address));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            value = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert br != null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        

        try {
          System.out.println("Value = " + value);
            String link = "http://kkmonlee.com/codeforgood/checkout.php?id=" + value;
            String results = doHttpUrlConnectionAction(link);
            System.out.println(results);
            
          

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          try {
             PrintWriter writer = new PrintWriter("/Users/Manav/Documents/codeforgood_part2/team-3/armband/auth_read_write/processing_pde/id.txt", "UTF-8");
             writer.println("");
             writer.close();
          } catch (FileNotFoundException|UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
    }

    private String doHttpUrlConnectionAction(String desired) throws Exception {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder sb;

        try { //<>//
            url = new URL(desired);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
             connection.addRequestProperty("User-Agent", "Mozilla/4.76"); 

            connection.setRequestMethod("GET");

            connection.setReadTimeout(15*1000);
            connection.connect();
  
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            sb = new StringBuilder();
            

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
                     System.out.println(sb.toString());
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}