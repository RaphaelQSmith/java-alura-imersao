import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        // create a http connection and search for the top 250
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //extract only the data that we (title, poster, rating)
        var parser = new JsonParser();    
        List<Map<String, String>> filmList = parser.parse(body);
        
        // show and handle data
        for (Map<String,String> film : filmList) {  
            System.out.println(film.get("title"));
            
            System.out.println(film.get("image"));
            
            System.out.println(film.get("imDbRating"));
        }
    }
}
