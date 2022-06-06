package lt.viko.eif.vvilimaite.project.constructor;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FilmDao {
    /**
     * responsible to get film data from API
     * @param id looking film name by id
     * @return film info
     */
    static public Film getFilmData(String id) throws IOException, InterruptedException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://online-movie-database.p.rapidapi.com/title/get-images?tconst="+id))
                .header("rapidapi-host", "online-movie-database.p.rapidapi.com")
                .header("rapidapi-key", "b2d31de054msh0942a6c6bf4f68bp14b6a9jsn50bd2c082a4c")
                .build();
        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
        if(response.body().equals("null")){
            return null;
        }
        JSONObject obj = new JSONObject(response.body());
        if(obj.getInt("totalImageCount")==0){
            return null;
        }
        String url=obj.getJSONArray("images").getJSONObject(0).getString("url");
        String name=obj.getJSONArray("images").getJSONObject(0).getString("caption");
        Film film=new Film(id,url,name);
        return film;

    }
}