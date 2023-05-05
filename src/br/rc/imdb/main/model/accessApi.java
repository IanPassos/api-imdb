package br.rc.imdb.main.model;

import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import br.rc.imdb.main.repository.Content;
import br.rc.imdb.main.utils.ConstantsEnum;

public class accessApi {

	public static void main(String[] args) throws Exception {
		
		String json = new ImdbApiClient(
				"https://imdb-api.com/en/API/Top250Movies/",ConstantsEnum.API_KEY.getValue())
				.getRequestBody();
		
		
		List<? extends Content> contents = new ImdbMovieJsonParser(json).parse();
		
//		Collections.sort(contents); 
		
		PrintWriter writer = new PrintWriter(new File("index.html"), "UTF-8");
		
		new HTMLGenerator(writer).generate(contents);
	
		writer.close();
	}
	
}
