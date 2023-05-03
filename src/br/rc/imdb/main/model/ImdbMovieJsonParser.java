package br.rc.imdb.main.model;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import br.rc.imdb.main.repository.Content;

public class ImdbMovieJsonParser implements br.rc.imdb.main.repository.JsonParser {
	
	private String json;

	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}
	
	@Override
	public List<? extends Content> parse(){
		
		JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
		JsonArray moviesJson = jsonObject.getAsJsonArray("items");
	
		Gson gson = new Gson();
		
		Type listType = new TypeToken<List<Movie>>() {}.getType();
		
		return gson.fromJson(moviesJson, listType);
	}

}
