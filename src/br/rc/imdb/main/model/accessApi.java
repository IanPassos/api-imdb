package br.rc.imdb.main.model;

import java.lang.reflect.*;
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
import com.google.gson.reflect.TypeToken;

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
		JsonArray moviesJson = jsonObject.getAsJsonArray("items");
	
		Gson gson = new Gson();
		
		Type listType = new TypeToken<List<Movie>>() {}.getType();
		List<Movie> movies = gson.fromJson(moviesJson, listType);
		
		movies.forEach(System.out::println);

	}
	
}
