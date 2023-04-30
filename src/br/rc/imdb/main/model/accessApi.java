package br.rc.imdb.main.model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import br.rc.imdb.main.utils.ConstantsEnum;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class accessApi {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		
		
		HttpRequest getRequest = HttpRequest.newBuilder().
				uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + ConstantsEnum.API_KEY.getValue()))
				.GET()
				.build();
		 
		
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> getResponse = client.send(getRequest,BodyHandlers.ofString());
		
		
		String json = getResponse.body();
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonArray moviesArray = jsonObject.getAsJsonArray("items");


		List<String> titles = new ArrayList<>();
		List<String> images = new ArrayList<>();
		
		for(int i = 0; i < moviesArray.size(); i++) {
			String title = moviesArray.get(i).getAsJsonObject().get("title").getAsString();
			titles.add(title);

			String image = moviesArray.get(i).getAsJsonObject().get("image").getAsString();
			images.add(image);
		}

	}
	
}
